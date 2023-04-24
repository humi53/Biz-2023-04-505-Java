package com.yopheu.classes.module;

public class ServiceE {
	public void score(int kor, int eng, int math) {
		int total = kor + eng + math;
		float avg = (float)total / 3;
		System.out.printf("국어 : %d  영어 : %d   수학 : %d\n", kor, eng, math);
		System.out.println("===========================================");
		System.out.printf("총점 : %d \t평균 : %2.2f", total, avg);
		
	}
}
