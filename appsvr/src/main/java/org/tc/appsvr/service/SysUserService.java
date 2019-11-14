package org.tc.appsvr.service;


import org.tc.appsvr.entity.SysUser;

public interface SysUserService {



    void addUser(SysUser user);
    void updateUser(SysUser user);
    void removeUser(SysUser user);

    SysUser queryByUsername(String userName);

}
