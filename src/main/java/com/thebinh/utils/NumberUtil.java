package com.thebinh.utils;

public class NumberUtil {
	public static boolean checkNumber(String data) {
		try {
			Long s = Long.parseLong(data);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}
