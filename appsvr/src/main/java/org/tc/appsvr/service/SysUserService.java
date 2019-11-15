package org.tc.appsvr.service;


import org.tc.appsvr.entity.SysUser;

public interface SysUserService {



    Integer addUser(SysUser user);
    Integer updateUser(SysUser user);
    Integer removeUser(SysUser user);

    SysUser queryByUsername(String userName);

}
