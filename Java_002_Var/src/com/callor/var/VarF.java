package com.callor.var;

public class VarF {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 43;
		boolean bEven1=false;
		boolean bEven2=false;
		
		// 데이터 type 이 true, false 로만 나타나는
		bEven1 = num1 % 2 == 0;
		bEven2 = num2 % 2 == 0;
		
		System.out.println(bEven1);
		System.out.println(bEven2);
		
		
	}
}
