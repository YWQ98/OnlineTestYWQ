package com.xmut.olt.seventh.tool;

public class IsNumeric {//判断字符串是否是数字


	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
