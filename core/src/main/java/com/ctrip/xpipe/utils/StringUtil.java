package com.ctrip.xpipe.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenchao.meng
 *
 *         2016年3月28日 下午6:46:26
 */
public class StringUtil {

	public static String randomString(int length) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append((char) ('a' + (int) (26 * Math.random())));
		}

		return sb.toString();
	}

	public static String join(String split, Object... args) {

		String[] tmp = new String[args.length];
		int i = 0;
		for (Object arg : args) {
			if (arg != null) {
				tmp[i++] = arg.toString();
			} else {
				tmp[i++] = null;
			}
		}
		return join(split, tmp);
	}

	public static String join(String split, String... args) {

		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			if (arg != null) {

				if (i > 0) {
					sb.append(split);
				}
				sb.append(arg);
				i++;
			}
		}
		return sb.toString();
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public static String []splitRemoveEmpty(String regex, String str){
		
		String []temp = str.split(regex);
		List<String> result = new ArrayList<>(temp.length);
		
		for(String each : temp){
			if(isEmpty(each)){
				continue;
			}
			result.add(each);
		}
		return result.toArray(new String[0]);		
	}
	
	public static boolean trimEquals(String str1, String str2, boolean ignoreCase){

		if(str1 == null){
			return str2 == null;
		}
		
		if(str2 == null){
			return false;
		}

		str1 = str1.trim();
		str2 = str2.trim();
		
		if(ignoreCase){
			return str1.equalsIgnoreCase(str2);
		}
		return str1.equalsIgnoreCase(str2);
	}

	public static boolean trimEquals(String str1, String str2){
		return trimEquals(str1, str2, false);
	}

	public static String[] splitByLen(String buff, int splitLen) {

		int count = buff.length()/splitLen;
		if(buff.length()%splitLen > 0){
			count++;
		}
		String []result = new String[count];
		int index =0;
		for(int i=0;i<count;i++){
			result[i] = buff.substring(index, Math.min(index+splitLen, buff.length()));
			index += splitLen;
		}
		return result;
	}

}
