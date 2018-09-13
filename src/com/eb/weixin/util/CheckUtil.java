package com.eb.weixin.util;

import java.util.Arrays;

public class CheckUtil {
    //开发者自定义的Tooken
    public static final String token = "gzhmaven";

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        //加密/校验流程如下：
        // 1）将token、timestamp、nonce三个参数进行字典序排序
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        String[] array = {token, timestamp, nonce};
        //排序
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : array) {
            stringBuffer.append(s);
        }
        //sha1加密
        String temp = SHA1.encode(stringBuffer.toString());
        return temp.equals(signature);
    }
}
