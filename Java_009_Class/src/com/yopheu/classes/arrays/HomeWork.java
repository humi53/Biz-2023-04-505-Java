package com.yopheu.classes.arrays;

import com.yopheu.classes.model.ScoreDto;
import com.yopheu.classes.service.ScoreServiceA;

public class HomeWork {
	public static void main(String[] args) {
		// ScoreDto type 요소 10를 갖는 배열 선언
		ScoreDto[] scores = new ScoreDto[10];
		// class type 의 배열 요소 전체를 객체 요소로 생성하기
		for(int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreDto();
		}
		
		ScoreServiceA scoreServiceA = new ScoreServiceA();
		
		//이름 입력부
		scores[0].stName ="홍길동";
		scores[1].stName ="이몽룡";
		scores[2].stName = "성춘향";
		scores[3].stName = "장보고"; 
		scores[4].stName = "임꺽정"; 
		scores[5].stName = "김철수"; 
		scores[6].stName = "김희경"; 
		scores[7].stName = "이기동"; 
		scores[8].stName = "박철수"; 
		scores[9].stName = "한동후";
		// 데이터 입력부
		for(int i = 0; i < scores.length; i++) {
			scores[i].stNum = String.format("%04d", i+1);
			scores[i].scKor = scoreServiceA.getScore();
			scores[i].scEng = scoreServiceA.getScore();
			scores[i].scMath = scoreServiceA.getScore();
		}
		


		
		// 라벨들 출력부
		System.out.println("=".repeat(70));
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-".repeat(70));
		// 데이터 출력부
		// & total들 계산도 함께
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		for(int i = 0; i < scores.length; i++) {
			scoreServiceA.scorePrint(scores[i]);
			korTotal += scores[i].scKor;
			engTotal += scores[i].scEng;
			mathTotal += scores[i].scMath;
		}
		// totals 출력부
		System.out.println("-".repeat(70));
		scoreServiceA.scoreTotalPrint(korTotal, engTotal, mathTotal);
		System.out.println("=".repeat(70));
		
	}
}
