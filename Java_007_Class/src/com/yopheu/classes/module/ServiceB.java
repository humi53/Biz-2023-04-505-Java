package com.yopheu.classes.module;

public class ServiceB {
	public void scorePrint(String name, int kor, int eng, int math) {
		int intTotal = kor + eng + math;
		float floatAvg = (float)intTotal / 3;
		
		System.out.println("===============================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%2.1f\n", name, kor, eng, math, intTotal, floatAvg);
		System.out.println("===============================================");
		
	}
}
