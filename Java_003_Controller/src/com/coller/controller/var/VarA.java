package com.coller.controller.var;

public class VarA {
	public static void main(String[] args) {
		int intKor = 0;
		int intEng = 0;
		int intMath = 0;
		
		int intTotal = 0;
//		int intAvg = 0;
		float floatAvg = 0.0f;
		
		intKor = ((int)(Math.random() * 50)) + 51;
		intEng = ((int)(Math.random() * 50)) + 51;
		intMath = ((int)(Math.random() * 50)) + 51;
		
//		intTotal = intKor + intEng + intMath;
		intTotal = intKor;
		intTotal += intEng;
		intTotal += intMath;
//		intAvg = intTotal / 3;
		floatAvg = (float)intTotal / 3f;
		
		System.out.println("===========================");
		System.out.printf("국어 : %3d\n", intKor);
		System.out.printf("영어 : %3d\n", intEng);
		System.out.printf("수학 : %3d\n", intMath);
		System.out.println("---------------------------");
		System.out.printf("총점 : %3d, 평균 : %5.2f\n", intTotal, floatAvg);
		
		
		
	}
	
		
		
		
}
