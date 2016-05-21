package com.lhs.pay.common.utils;

import java.io.UnsupportedEncodingException;

/**
 * Strings
 *
 * 字符串工具类
 *
 * @author longhuashen
 * @since 16/5/21
 */
public class Strings {

    /**
     * 将字符串左填充成固定长度(长度按字节数计算)
     *
     * @param str 待填充的字符串
     * @param size 填充后的长度
     * @param pddChar 用来填充的字符
     * @param enCoding 计算字符串长度的编码方式
     * @return
     */
    public static String leftPadWithBytes(String str, int size, char pddChar, String enCoding) {
        if (str == null) {
            return null;
        }
        int strLen;
        try {
            strLen = str.getBytes(enCoding).length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncoding:" + enCoding, e);
        }

        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }

        char[] padChars = new char[pads];
        for (int i = 0; i < padChars.length; i++) {
            padChars[i] = pddChar;
        }

        return new String(padChars) + str;
    }
}
