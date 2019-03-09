package com.dhruvalkodinariya.account;

import java.text.DecimalFormat;
import java.util.Random;

public class CommonUtils {
	public static String getUUID(int length) {
		String str = "";
		String basic = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random rand = new Random();
		for(int i= 0;i <= length;i++) {
			int index = rand.nextInt(36);
			char c =basic.charAt(index);
			str = str + c;
		}
		return str;
	}
	public static String getCurrency(String str) {
		double number = Double.parseDouble(str);

        DecimalFormat format = new DecimalFormat("0.00");
        String formatted = format.format(number);
		return formatted;
	}
}
