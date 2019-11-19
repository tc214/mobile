package org.tc.appsvr.jwt;

public class JWTConst {
    /**
     * 过期时间是3600秒，既是1个小时
     */
    public static final long CONN_TOKEN_EXPIRATION = 3600L;

    /**
     * 选择了记住我之后的过期时间为7天
     */
    public static final long CONN_TOKEN_EXPIRATION_REMEMBER = 604800L;


    /**
     * HEADER
     */

    public static final String CONN_LOGIN_TOKEN_HEADER = "Authorization";


    /**
     * 认证身份
     */
    public static final String CONN_LOGIN_AUTHORIZATION_BEARER = "Bearer ";


    /**
     * 随时可以更换密码
     */
    public static final String CONN_JWT_SECRET = "www.org.com";

    /**
     * 颁发者
     */
    public static final String CONN_JWT_ISS = "org"; //


    /**
     * 登录状态
     */
    // 登录状态正常
    public static final Integer LOGIN_STATUS_OK = 0;
    // 异地登录
    public static final Integer LOGIN_STATUS_KICK_OUT = 1;
    // 登录状态过期
    public static final Integer LOGIN_STATUS_EXPIRED = 2;
    /**
     * 登录设备
     */
    // pc
    public static final Integer DEVICE_PC = 1;
    // app
    public static final Integer DEVICE_APP = 2;
    // stb
    public static final Integer DEVICE_STB = 3;


}
