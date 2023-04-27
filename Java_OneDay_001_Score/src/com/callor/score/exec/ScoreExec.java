package com.callor.score.exec;

import com.callor.score.model.ScoreDto;
import com.callor.score.service.ScoreService;

public class ScoreExec {
	// 점수를 랜덤하게 생성.
	public static int getScore() {
		return (int)(Math.random() * 50) + 51;
	}
	
	public static void main(String[] args) {
		// 학생 배열을 생성 & 초기화
		ScoreDto[] students = new ScoreDto[10];
		for(int i = 0; i < students.length; i++) {
			students[i] = new ScoreDto();
		}
		
		// 학생 데이터 입력부.
		for(int i = 0; i < students.length; i++) {
			students[i].stNum = String.format("23%03d", (i+1));
			students[i].stKor = getScore();
			students[i].stEng = getScore();
			students[i].stMath = getScore();
			students[i].stMusic = getScore();
			students[i].stArt = getScore();
		}
		
		// 출력을 해줄 서비스
		ScoreService service = new ScoreService();
		
		// 제목 & 라벨 출력부
		service.printLable();
		
		// 학생들 데이터 + 총점&평균  출력부
		// + 각 과목별 합산을 출력할때 더한다. (출력관련이라)
		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		int totalMusic = 0;
		int totalArt = 0;
		for(int i = 0; i < students.length; i++) {
			service.printDto(students[i]);
			totalKor += students[i].stKor;
			totalEng += students[i].stEng;
			totalMath += students[i].stMath;
			totalMusic += students[i].stMusic;
			totalArt += students[i].stArt;
		}
		
		// 총점 & 평균 출력부. (마지막 파라미터는 학생수)
		service.printDtoTotalsAvgs(totalKor, totalEng, totalMath, totalMusic, totalArt, students.length);
		
		
		
	}
}
