package com.callor.score.service;

import com.callor.score.model.ScoreDto;

public class ScoreService {
	int repetNum = 70;	// 구분선 길이
	
	// 라벨 출력메소드
	public void printLable() {
		System.out.println("=".repeat(this.repetNum));
		System.out.println("\t\t      * 한울 고교 성적 리스트 * ");
		System.out.println("=".repeat(this.repetNum));
		System.out.println(" 학번\t\t국어\t영어\t수학\t음악\t미술\t총점\t평균");
		System.out.println("-".repeat(this.repetNum));
	}
	
	// 학생 출력메소드 
	// 한명의 학생의 정보만 출력. 
	public void printDto(ScoreDto score) {
		System.out.printf(" %s\t\t%d\t%d\t%d\t%d\t%d\t%d\t%3.2f\n",
				score.stNum,
				score.stKor,
				score.stEng,
				score.stMath,
				score.stMusic,
				score.stArt,
				score.getTotal(),
				score.getAvg()
				);
	}
	
	// 출력부. 각 과목의 총점 & 평균 을 출력.
	// 전체 총점 & 평균도 출력.
	// (각과목별 합산 점수) 국어, 영어, 수학, 음악, 미술 이미합산한 점수를 입력 요망. 
	// 마지막 파라미터 = quota(학생정원) 
	public void printDtoTotalsAvgs(int tKor, int tEng, int tMath, int tMusic, int tArt, int quota) {
		int allTotal = tKor + tEng + tMath + tMusic + tArt;
		float fQuoat = (float)quota;
		// 총점 출력부.
		System.out.println("-".repeat(this.repetNum));
		System.out.printf(" 총점\t\t%d\t%d\t%d\t%d\t%d\t%d\n",
				tKor, tEng, tMath, tMusic, tArt, allTotal
				);
		
		// 평균 출력부.
		System.out.printf(" 평균\t\t%3.2f\t%3.2f\t%3.2f\t%3.2f\t%3.2f\t\t%3.2f\n",
				tKor/fQuoat,
				tEng/fQuoat,
				tMath/fQuoat,
				tMusic/fQuoat,
				tArt/fQuoat,
				allTotal/(fQuoat*5)
				);
		System.out.println("=".repeat(this.repetNum));
	}
}
