package org.tc.appsvr.service;


import org.tc.appsvr.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface SysUserService {



    Integer addUser(SysUser user);
    Integer updateUser(SysUser user);
    Integer removeUser(SysUser user);

    SysUser queryByUsername(String userName);
    Map getAuthToken(HttpServletRequest request, HttpServletResponse response, String loginName, String enLoginPwd, String roleId);

}
