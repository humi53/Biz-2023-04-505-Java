package com.coller.controller.var;

public class VarF {
	public static void main(String[] args) {
		String str = "Republic of Korea";
		char cVar = str.charAt(3);
		System.out.println(cVar);
		System.out.println(str.length());
		
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + "\t");
		}
	}
}
