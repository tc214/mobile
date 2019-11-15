package org.tc.appsvr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tc.appsvr.entity.SysUser;
import org.tc.appsvr.mapper.SysUserMapper;
import org.tc.appsvr.service.SysUserService;

import javax.annotation.Resource;


@Service
public class SysUserServiceImpl implements SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;




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









}
