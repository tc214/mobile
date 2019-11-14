package org.tc.appsvr.jwt;

import cn.hutool.json.JSONUtil;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.tc.appsvr.util.IdUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * jwt内容装载
 */
public class JwtPayloadBuilder {

    private Map<String,String> payLoad = new HashMap<>();
    private Map<String,String> additional; // 附件属性
    private String iss;   // jwt签发者
    private String sub;  // jwt面向的用户
    private String aud;  // 接收jwt的一方
    private LocalDateTime exp;  // 过期时间
    private LocalDateTime iat = LocalDateTime.now(); // 签发时间
    private Set<String> roles = new HashSet<>();
    private String jti = IdUtil.simpleUUID();



    public JwtPayloadBuilder iss(String iss) {
        this.iss = iss;
        return this;
    }

    public JwtPayloadBuilder sub(String sub) {
        this.sub = sub;
        return this;
    }

    public JwtPayloadBuilder aud(String aud) {
        this.aud = aud;
        return this;
    }

    public JwtPayloadBuilder roles(Set<String> roles) {
        this.roles = roles;
        return this;
    }

    public JwtPayloadBuilder additional(Map<String,String> additional) {
        this.additional = additional;
        return this;
    }

    public JwtPayloadBuilder expDays(int days) {
        Assert.isTrue(days>0," jwt expireData must after now");
        this.exp = this.iat.plusDays(days);
        return this;
    }

    public String builder() {
        payLoad.put("iss", this.iss);
        payLoad.put("sub", this.sub);
        payLoad.put("exp", this.exp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        payLoad.put("iat", this.iat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        payLoad.put("jti", this.jti);

        if (CollectionUtils.isEmpty(additional)) {
            payLoad.putAll(additional);
        }
        payLoad.put("roles", JSONUtil.toJsonStr(this.roles));
        return JSONUtil.toJsonStr(JSONUtil.parse(payLoad));

    }

}
