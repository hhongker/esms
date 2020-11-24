package com.dyedu.test;

import com.dyedu.util.MD5Util;

/**
 * @author gdx
 * @description 测试Md5
 * @date 2019/12/27
 */
public class MD5UtilTest {
    public static void main(String[] args) {
        String  password = "123";
        System.out.println(MD5Util.md5Str(password));
        System.out.println(MD5Util.md5StrAndSalt(password,"edward"));
    }
}
