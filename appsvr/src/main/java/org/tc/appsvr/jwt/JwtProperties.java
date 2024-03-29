package org.tc.appsvr.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static org.tc.appsvr.jwt.JwtProperties.JWT_PREFIX;

/**
 * Jwt 在 springboot application.yml 中的配置文件
 *
 * @author tc
 * @since 2019-11-14
 */
@Data
@ConfigurationProperties(prefix= JWT_PREFIX)
public class JwtProperties {
    static final String JWT_PREFIX= "jwt.config";
    /**
     * 是否可用
     */
    private boolean enabled;
    /**
     * jks 路径
     */
    private String keyLocation;
    /**
     * key alias
     */
    private String keyAlias;
    /**
     * key store pass
     */
    private String keyPass;
    /**
     * jwt签发者
     **/
    private String iss;
    /**
     * jwt所面向的用户
     **/
    private String sub;
    /**
     * access jwt token 有效天数
     */
    private int accessExpDays;
    /**
     * refresh jwt token 有效天数
     */
    private int refreshExpDays;
}
