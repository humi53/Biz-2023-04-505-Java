package com.yopheu.classes.arrays;

import com.yopheu.classes.model.ScoreDto;

public class ArrayA {
	public static void main(String[] args) {
		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();
		
		홍길동.stName = "홍길동";
		홍길동.stNum = "0001";
		홍길동.scEng = (int)(Math.random() * 101);
		홍길동.scKor = (int)(Math.random() * 101);
		홍길동.scMath = (int)(Math.random() * 101);
		이몽룡.stName = "이몽룡";
		이몽룡.stNum = "0002";
		이몽룡.scEng = (int)(Math.random() * 101);
		이몽룡.scKor = (int)(Math.random() * 101);
		이몽룡.scMath = (int)(Math.random() * 101);
		성춘향.stName = "성춘향";
		성춘향.stNum = "0003";
		성춘향.scEng = (int)(Math.random() * 101);
		성춘향.scKor = (int)(Math.random() * 101);
		성춘향.scMath = (int)(Math.random() * 101);
		
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-".repeat(60));
		System.out.printf("%s\t%s\t%3d\t%3d\t%3d\t%3d\t%5.2f\n",
				홍길동.stName, 
				홍길동.stNum, 
				홍길동.scKor, 
				홍길동.scEng, 
				홍길동.scMath, 
				홍길동.getTotal(),
				홍길동.getAvg());
		System.out.printf("%s\t%s\t%3d\t%3d\t%3d\t%3d\t%5.2f\n",
				이몽룡.stName, 
				이몽룡.stNum, 
				이몽룡.scKor, 
				이몽룡.scEng, 
				이몽룡.scMath, 
				이몽룡.getTotal(),
				이몽룡.getAvg());
		System.out.printf("%s\t%s\t%3d\t%3d\t%3d\t%3d\t%5.2f\n",
				성춘향.stName, 
				성춘향.stNum, 
				성춘향.scKor, 
				성춘향.scEng, 
				성춘향.scMath, 
				성춘향.getTotal(),
				성춘향.getAvg());
		
		
		
	}
}
