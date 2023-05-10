package com.yopheu.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.classes.config.Line;
import com.yopheu.classes.datas.DataIndex;
import com.yopheu.classes.datas.DataSource;
import com.yopheu.classes.models.ScoreDto;
import com.yopheu.classes.models.StudentDto;
import com.yopheu.classes.service.ScoreService;
import com.yopheu.classes.service.StudentService;

/*
 * interface(class)를 implements 한 클래스는
 * interface에 선언된 모든 method 를 의무적으로 구현해야 한다
 * interface에 선언된 method 를 한개라도 생략하면 
 * 		클래스 코드는 문법 오류가 발생하고 실행 불가 상태가 된다
 */
public class ScoreServiceImplV1 implements ScoreService{

	protected List<ScoreDto> scList;
	public ScoreServiceImplV1() {
		scList = new ArrayList<>();
	}

	// 성적정보 문자열 1개를 컴마(,)로 분해하고
	// ScoreDto 객체로 변환하여 return 하는 method
	protected ScoreDto str2Dto(String str) {
		String[] score = str.split(",");
		
		// ScoreDto 클래스는 field 생성자가 있다
		// field 생성자를 통하여 데이터가 포함된 stDto 객체를 생성
		ScoreDto scDto = new ScoreDto(score[DataIndex.SCORE.ST_NUM],
				Integer.valueOf(score[DataIndex.SCORE.SC_KOR]), 
				Integer.valueOf(score[DataIndex.SCORE.SC_ENG]), 
				Integer.valueOf(score[DataIndex.SCORE.SC_MATH]),
				Integer.valueOf(score[DataIndex.SCORE.SC_MUSIC]),
				Integer.valueOf(score[DataIndex.SCORE.SC_ART]),
				Integer.valueOf(score[DataIndex.SCORE.SC_SOFTWARE]),
				Integer.valueOf(score[DataIndex.SCORE.SC_DATABASE])
				);
		return scDto;
	}
	
	// ScData.SCORE 배열을 loading 하여
	// scList 데이터로 변환하기
	@Override
	public void loadScore() {
		// DataSource.SCORE 문자열 배열의 값을
		// List<ScoreDto> type의 리스트 데이터로 변환하기
		for(String str : DataSource.SCORE) {
			scList.add(str2Dto(str));
		}
	}

	protected void printHeader() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t\t국어\t영어\t수학\t음악\t미술\tSW\tDB");
		System.out.println(Line.sLine(100));
	}
	@Override
	public void printScore() {
		printHeader();
	
		StudentService stdService = new StudentServiceImplV2();
		stdService.loadStudent();
		for(ScoreDto dto : scList) {
			StudentDto stDto = stdService.getStudent(dto.getStNum());
			System.out.print(dto.getStNum() + "\t");
			try {
				System.out.print(stDto.stName + "\t");
				System.out.print(stDto.stDept + "\t");
			} catch (NullPointerException e) {
				System.out.print("-\t");
				System.out.print("-\t\t");
			}
			System.out.print(dto.getScKor() + "\t");
			System.out.print(dto.getScEng() + "\t");
			System.out.print(dto.getScMath() + "\t");
			System.out.print(dto.getScMusic() + "\t");
			System.out.print(dto.getScArt() + "\t");
			System.out.print(dto.getScSoftWare() + "\t");
			System.out.print(dto.getScDataBase() + "\t");
			System.out.println();
		}
		System.out.println(Line.dLine(100));
	}

}
