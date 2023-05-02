package com.yopheu.score.model;

/*
 * 성적처리를 수행하는데
 *  학번(230001), 국어, 영어, 수학, 음악, 미술 교과목의
 *  점수를 저장하고 
 *  총점, 평균을 계산하는 method 를 선언
 *  
 */
public class ScoreDto {

	// 각 객체의 데이터를 저장할 변수를 선언하기 
	public String stNum;
	public int scKor;
	public int scEng;
	public int scMath;
	public int scMusic;
	public int scArt;

	/*
	 * 학생의 성적을 변수에 저장하고
	 * getTotal() method 를 호출하면
	 * 과목 총점을 계산하여 return 하는 역할
	 * 
	 * this keyword
	 * (data) 클래스를 객체로 선언했을때
	 * 객체의 포함된 속성임을 명확히 하기 위한 keyword
	 * 
	 */
	
	public int getTotal() {
		int total = this.scKor;
		total += this.scEng;
		total += this.scMath;
		total += this.scMusic;
		total += this.scArt;
		return total;
	}
	
	/*
	 * 클래스에 선언된 getTotal() method 를 호출하여
	 * 총점을 계산하도록 하고,
	 * 계산된 총점을 float 로 변환하여 평균을 계산하고
	 * 그 결과를 return
	 * 
	 */
	public float getAvg() {
		float avg = (float)(this.getTotal()) / 5;
		return avg;
	}
	
	
}
