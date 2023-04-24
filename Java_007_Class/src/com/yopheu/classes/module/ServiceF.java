package com.yopheu.classes.module;

public class ServiceF {
	public void score(int kor, int eng, int math, int his, int mus, int art, int phy) {
		int total = kor + eng + math + his + mus + art + phy;
		float avg = (float)total / 7;
		System.out.println("total : " + total);
		System.out.printf("avg : %2.2f\n", avg);
	}
}
