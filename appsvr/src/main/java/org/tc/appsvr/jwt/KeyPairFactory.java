package org.tc.appsvr.jwt;

import org.springframework.core.io.ClassPathResource;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

/**
 * KeyPairFactory
 * 从指定路径读取证书
 * @author tc
 *
 **/
class KeyPairFactory {

    private KeyStore store;

    private final Object lock = new Object();

    /**
     * 获取公私钥.
     *
     * @param keyPath  the key path
     * @param keyAlias the key alias
     * @param keyPass   keytool 生成的  -storepass 值
     * @return the key pair 公私钥对
     */
    KeyPair create(String keyPath, String keyAlias, String keyPass) {
        ClassPathResource resource = new ClassPathResource(keyPath);
        char[] pem = keyPass.toCharArray();
        try {
            synchronized (lock) {
                if (store == null) {
                    synchronized (lock) {
                        store = KeyStore.getInstance("jks");
                        store.load(resource.getInputStream(), pem);
                    }
                }
            }
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) store.getKey(keyAlias, pem);
            RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
            return new KeyPair(publicKey, key);
        } catch (Exception e) {
            throw new IllegalStateException("Cannot load keys from store: " + resource, e);
        }

    }
}
/**
 生成证书命令参考：

 ```shell script keytool -genkey -alias felordcn -keypass felordcn -keyalg RSA -storetype PKCS12 -keysize 1024 -validity 365 -keystore d:/keystores/felordcn.jks -storepass 123456 -dname "CN=(Felord), OU=(felordcn), O=(felordcn), L=(zz), ST=(hn), C=(cn)"




 */