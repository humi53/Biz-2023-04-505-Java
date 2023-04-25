package com.yopheu.classes.exec;

public class ExecD {
	public static void main(String[] args) {
		int st1Kor = (int)(Math.random() * 50) + 51;
		int st2Kor = (int)(Math.random() * 50) + 51;
		int st3Kor = (int)(Math.random() * 50) + 51;
		int st4Kor = (int)(Math.random() * 50) + 51;
		int st5Kor = (int)(Math.random() * 50) + 51;
		
		int total = st1Kor;
		total += st2Kor;
		total += st3Kor;
		total += st4Kor;
		total += st5Kor;
		
		float avg = total / 5;
		
		System.out.printf("국어점수 합계 : %d, 평균 %2.2f", total, avg);
		
	}
}
