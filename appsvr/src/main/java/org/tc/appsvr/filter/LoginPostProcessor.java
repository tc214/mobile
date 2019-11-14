package org.tc.appsvr.filter;


import org.tc.appsvr.enums.LoginTypeEnum;

import javax.servlet.ServletRequest;

/**
 * The interface Login post processor.
 *
 * @author tc
 * @since 2019-11-14
 */
public interface LoginPostProcessor {



    /**
     * 获取 登录类型
     *
     * @return the type
     */
    LoginTypeEnum getLoginTypeEnum();

    /**
     * 获取用户名
     *
     * @param request the request
     * @return the string
     */
    String obtainUsername(ServletRequest request);

    /**
     * 获取密码
     *
     * @param request the request
     * @return the string
     */
    String obtainPassword(ServletRequest request);

}
