package com.laoshe.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;


/**
 * 数据加密工具类
 * @author hyw
 * 2018年11月18日
 */
public class DesUtil {
	
	private static final String key = "12345678";

    /**
     * 加密
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static String encrypt(String srcStr) throws UnsupportedEncodingException {
        byte[] src = srcStr.getBytes("UTF-8");
        byte[] buf = Des.encrypt(src, key);
        return Des.parseByte2HexStr(buf);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr) throws Exception {
        byte[] src = Des.parseHexStr2Byte(hexStr);
        byte[] buf = Des.decrypt(src, key);
        return new String(buf, "UTF-8");
    }
    /**
     * 根据秘钥加密
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static String encryptByKey(String srcStr,String serKey) throws UnsupportedEncodingException {
        byte[] src = srcStr.getBytes("UTF-8");
        byte[] buf = Des.encrypt(src, key);
        return Des.parseByte2HexStr(buf);
    }

    /**
     * 根据秘钥解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decryptByKey(String hexStr,String serKey) throws Exception {
        byte[] src = Des.parseHexStr2Byte(hexStr);
        byte[] buf = Des.decrypt(src, serKey);
        return new String(buf, "UTF-8");
    }
    
}

