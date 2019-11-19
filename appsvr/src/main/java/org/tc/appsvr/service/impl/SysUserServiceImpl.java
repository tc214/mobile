package org.tc.appsvr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.tc.appsvr.cache.RedisConstants;
import org.tc.appsvr.cache.RedisUtils;
import org.tc.appsvr.entity.SysUser;
import org.tc.appsvr.jwt.JWTConst;
import org.tc.appsvr.jwt.JwtTokenGenerator;
import org.tc.appsvr.jwt.JwtTokenPair;
import org.tc.appsvr.mapper.SysUserMapper;
import org.tc.appsvr.service.SysUserService;
import org.tc.appsvr.util.ConstUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Service
public class SysUserServiceImpl implements SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private JwtTokenGenerator jwtTokenGenerator;

    @Resource
    private RedisUtils redisUtils;





    @Override
    public SysUser queryByUsername(String username) {
        return sysUserMapper.queryByUsername(username);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addUser(SysUser sysUser) {
        return sysUserMapper.addUser(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updateUser(SysUser sysUser) {
        return sysUserMapper.updateUser(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer removeUser(SysUser sysUser) {
        return sysUserMapper.removeUser(sysUser);
    }

    @Override
    public Map getAuthToken(HttpServletRequest request, HttpServletResponse response, String loginName, String loginPwd, String roleId) {
        Map map=new HashMap();

        SysUser sysUser = queryByUsername(loginName);
        // 脱敏
        sysUser.setEncodePassword("[PROTECT]"); // 不返回真实的密码
        HashMap<String,String> claims = new HashMap<String,String>();
        claims.put(ConstUtil.CONN_LOGIN_ROLE_ID, roleId);
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        JwtTokenPair tokenPair = jwtTokenGenerator.jwtTokenPair(loginName, roles, claims);
        // 保存token到redis
        redisUtils.set(ConstUtil.CONN_AUTH_ACCESS_TOKEN, tokenPair.getAccessToken(), JWTConst.CONN_TOKEN_EXPIRATION);
        redisUtils.set(ConstUtil.CONN_AUTH_REFRESH_TOKEN, tokenPair.getRefreshToken(),JWTConst.CONN_TOKEN_EXPIRATION_REMEMBER);
        System.out.println("access_token:"+redisUtils.get(ConstUtil.CONN_AUTH_ACCESS_TOKEN, RedisConstants.CONN_REDIS_DB_INDIX_0));
        System.out.println("refresh_token:"+redisUtils.get(ConstUtil.CONN_AUTH_REFRESH_TOKEN, RedisConstants.CONN_REDIS_DB_INDIX_0));

        map.put("user", sysUser);
        map.put("token", tokenPair.getAccessToken());
        return map;
    }







}
