package org.tc.appsvr.jwt;

import lombok.Data;

import java.io.Serializable;

/**
 * JwtTokenPair
 *
 * @author tc
 * @since 2019-11-14
 **/
@Data
public class JwtTokenPair implements Serializable {
    private static final long serialVersionUID = -8518897818107784049L;
    private String accessToken;
    private String refreshToken;
}
