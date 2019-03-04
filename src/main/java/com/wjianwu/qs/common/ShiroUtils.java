package com.wjianwu.qs.common;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author wjianwu 2019/2/26 17:55
 */
public class ShiroUtils {

    /**
     * 加密算法
     */
    public final static String hashAlgorithmName = "SHA-256";
    /**
     * 循环次数
     */
    public final static int hashIterations = 16;

    public static String encrypt(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

}
