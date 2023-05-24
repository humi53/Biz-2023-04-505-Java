package com.yopheu.bank.utils;

public class Line {
	public static final String dLine = "=".repeat(60);
	public static final String sLine = "=".repeat(60);
	
	public static final String dLine(int lenght) {
		return "=".repeat(lenght);
	}
	
	public static final String sLine(int lenght) {
		return "-".repeat(lenght);
	}
}
