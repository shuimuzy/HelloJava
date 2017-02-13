package com.samples;


public class HelloWorld {

	public static void main(String arg[]){
		System.out.println("Hello Java!!!");
		String str1 = "abc";
		String str2 = "def";
		StringBuffer sb = new StringBuffer();
		String str = sb.append(str1).append(str2).toString();
		System.out.println(str);
	}
	
}
