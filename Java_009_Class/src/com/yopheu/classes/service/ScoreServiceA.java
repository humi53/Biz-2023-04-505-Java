package com.yopheu.classes.service;

import com.yopheu.classes.model.ScoreDto;

public class ScoreServiceA {

	// 51 ~ 100 까지 범위의 랜덤수를 만들어 return 하는 method
	public int getScore() {
		int score = (int)(Math.random() * 50) + 51;
		return score;
	}
	
	// ScoreDto type 매개변수를 통하여
	// 성적정보 데이터를 받아서 출력하기
	public void scorePrint(ScoreDto score) {
		System.out.printf("%s\t%s\t%3d\t%3d\t%3d\t%3d\t%5.2f\n",
				score.stNum, 
				score.stName, 
				score.scKor, 
				score.scEng, 
				score.scMath, 
				score.getTotal(),
				score.getAvg());
	}
	public void scoreTotalPrint(int kor, int eng, int math) {
		System.out.printf("\t\t%d\t%d\t%d\t%d\n",
				kor, eng, math, kor+eng+math			
				);
	}
}
