package com.hniu.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 加密工具
 */
public class EncryptUtil {
    /**
     * @param password 密码
     * @return 加密后的密码 和盐
     */
    public static Map<String, String> encryption(String password) {

        String salt = UUID.randomUUID().toString().replace("-", "");
        return encryption(password, salt);
    }

    public static Map<String, String> encryption(String password, String salt) {
        SimpleHash md = new SimpleHash("MD5", password, salt, 2);
        Map<String, String> map = new HashMap<>();
        map.put("salt", salt);
        map.put("password", md.toHex());
        return map;
    }
}
