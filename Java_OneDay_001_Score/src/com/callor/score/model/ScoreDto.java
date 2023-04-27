package com.callor.score.model;

public class ScoreDto {
	public String stNum;	// 학번
	public int stKor;		// 국어
	public int stEng;		// 영어
	public int stMath;		// 수학
	public int stMusic;		// 음악
	public int stArt;		// 미술
	
	// 학생의 총점.
	public int getTotal() {
		int total = 0;
		total = this.stKor;
		total += this.stEng;
		total += this.stMath;
		total += this.stMusic;
		total += this.stArt;
		return total;
	}
	
	// 학생의 평균.
	public float getAvg() {
		return (float)getTotal() / 5;
	}
}
