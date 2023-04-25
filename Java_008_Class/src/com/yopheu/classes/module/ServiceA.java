package com.yopheu.classes.module;

public class ServiceA {
	public void score(int kor, int eng, int math, int his, int mus, int art, int phy) {
		int total = kor + eng + math + his + mus + art + phy;
		float avg = (float)total / 7;
		System.out.println("=======================================================");
		System.out.println("국어\t영어\t수학\t국사\t음악\t미술\t체육");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\n", kor, eng, math, his, mus, art, phy);
		System.out.println("=======================================================");
		System.out.printf("총점 : %d \t 평균 : %2.2f", total, avg);
		
	}
}
