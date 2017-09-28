package com.mjwise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ASUS on 2017/9/28.
 */
public class TestReg {

	public static void main(String[] args) {
		String resultCount = "424 records";
		String regEx = "[^0-9]";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(resultCount);
		resultCount = matcher.replaceAll("");
		System.out.println(resultCount);
		String pageNumber = Integer.parseInt(resultCount)/100 + 1 + "";
		System.out.println(pageNumber);
	}
}
