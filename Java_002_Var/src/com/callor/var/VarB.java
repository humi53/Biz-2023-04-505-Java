package com.callor.var;

public class VarB {
	public static void main(String[] args) {
		int num1=0,num2=0;
		// 변수에 어떤 값을 저장, 할당, 대입하려면
		// 반드시 먼저 선언되어야 한다.
		
		// 선언하고, 두 변수의 덧셈 결과 저장
		int sum1=0;
		
		// 선언과 동시에 두 변수의 덧셈 결과 저장
		int sum2 = num1 + num2;
		
		num1 = 30;
		num2 = 40;
		
		sum1 = num1 + num2;
		System.out.println(sum1);
	}
}
