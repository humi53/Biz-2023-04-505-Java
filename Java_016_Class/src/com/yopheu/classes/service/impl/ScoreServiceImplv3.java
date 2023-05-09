package com.yopheu.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.classes.models.ScData;
import com.yopheu.classes.models.ScoreDto;
import com.yopheu.classes.models.StudentDto;
import com.yopheu.classes.service.ScoreService;

/*
 * interface(class)를 implements 한 클래스는
 * interface에 선언된 모든 method 를 의무적으로 구현해야 한다
 * interface에 선언된 method 를 한개라도 생략하면 
 * 		클래스 코드는 문법 오류가 발생하고 실행 불가 상태가 된다
 */
public class ScoreServiceImplv3 implements ScoreService{

	List<ScoreDto> scList;
	// ScData.SCORE 배열을 loading 하여
	// scList 데이터로 변환하기
	@Override
	public void makeScore() {
		scList = new ArrayList<>();
		// TODO Auto-generated method stub		
		for(String str : ScData.SCORE) {
			String[] score = str.split(",");
			ScoreDto scDto = new ScoreDto(score[ScData.ST_NUM],
					Integer.valueOf(score[ScData.SC_KOR]), 
					Integer.valueOf(score[ScData.SC_ENG]), 
					Integer.valueOf(score[ScData.SC_MATH]),
					Integer.valueOf(score[ScData.SC_MUSIC]),
					Integer.valueOf(score[ScData.SC_ART]),
					Integer.valueOf(score[ScData.SC_SOFTWARE]),
					Integer.valueOf(score[ScData.SC_DATABASE])
					);
			scList.add(scDto);
		}
	}

	@Override
	public void makeScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printScore() {
		StudentServiceImplV1 stdService = new StudentServiceImplV1();
		stdService.localStudent();
		
		System.out.println("=".repeat(100));
		System.out.println("학번\t이름\t학과\t\t국어\t영어\t수학\t음악\t미술\tSW\tDB");
		System.out.println("-".repeat(100));
		for(ScoreDto dto : scList) {
			StudentDto student = stdService.getStudent(dto.getStNum());
			System.out.print(dto.getStNum() + "\t");
			System.out.print(student.stName + "\t");
			System.out.print(student.stDept + "\t");
			System.out.print(dto.getScKor() + "\t");
			System.out.print(dto.getScEng() + "\t");
			System.out.print(dto.getScMath() + "\t");
			System.out.print(dto.getScMusic() + "\t");
			System.out.print(dto.getScArt() + "\t");
			System.out.print(dto.getScSoftWare() + "\t");
			System.out.print(dto.getScDataBase() + "\t");
			System.out.println();
		}
		System.out.println("=".repeat(100));
	}

	
	@Override
	public void printScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub
		
	}

}
