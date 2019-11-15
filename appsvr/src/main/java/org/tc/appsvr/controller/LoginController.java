package org.tc.appsvr.controller;


import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tc.appsvr.entity.Rest;
import org.tc.appsvr.entity.RestBody;
import org.tc.appsvr.entity.SysUser;
import org.tc.appsvr.service.SysUserService;

import javax.annotation.Resource;



@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private SysUserService sysUserService;



    @PostMapping(value="/success")
    public Rest myLoginSuccess() {
        // 登录成功后用户的认证信息 UserDetails会存在 SecurityContextHolder 中
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        SysUser sysUser = sysUserService.queryByUsername(username);
        // 脱敏
        sysUser.setEncodePassword("[PROTECT]"); // 不返回真实的密码
        return RestBody.okData(sysUser,"登录成功");
    }


    /**
     * 登录失败返回401
     * @return
     */
    @PostMapping(value="/failure")
    public Rest myLoginFailure() {
        return RestBody.failure(HttpStatus.HTTP_UNAUTHORIZED, "登录失败");
    }




}
