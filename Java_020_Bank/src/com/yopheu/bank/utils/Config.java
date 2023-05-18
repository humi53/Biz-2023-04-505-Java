package com.yopheu.bank.utils;

public class Config {
	public static final String BUYER_FILE = "src/com/yopheu/bank/datas/buyer.txt"; 
	
	public static final void bankTitel(String jobTitle) {
		System.out.println(Line.dLine(100));
		System.out.printf("대한은행 시스템(%s)\n", jobTitle);
		System.out.println(Line.sLine(100));
	}
}
