package com.laoshe.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.javassist.expr.NewArray;

/**
 * @author hyw
 * 2018年11月12日
 */
public class DataUtil {
	public static String getToken(){
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sFormat.format(date);
		String uuid = UUID.randomUUID().toString().substring(0, 10);
		String token = str + uuid;
		
		return token;
	}
	public static String getOrderMainId(){
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderMainId = sFormat.format(new Date())
				+random9();
		return orderMainId;
	}
	private static String random9(){
        Date date = new Date();
        long timeMill = date.getTime();
        Random rand = new Random(timeMill);
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < 2; i++){
            str.append(rand.nextInt(50));
        }
        return str.toString();
    }
	public static String getTopicId(){
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sFormat.format(date);
		String uuid = UUID.randomUUID().toString().substring(0, 8);
		String token = str + uuid;
		
		return token;
	}
}
