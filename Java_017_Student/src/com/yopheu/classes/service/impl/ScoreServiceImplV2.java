package com.yopheu.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.yopheu.classes.datas.DataIndex;
import com.yopheu.classes.models.ScoreDto;

public class ScoreServiceImplV2 extends ScoreServiceImplV1{

	public ScoreServiceImplV2() {
		// V1 에서 protected 로 선언 scList 를 사용할수 있도록
		// 초기화 하는 작업, 반드시 필요.
		scList = new ArrayList<>();
	}
	
	@Override
	public void loadScore() {
		
		String scoreFile = "src/com/yopheu/classes/datas/score.csv";
		
		Scanner fileScan = null;	// 스캐너 변수선언
		InputStream is = null;		// 인풋스트림 변수 선언
		try {
			is = new FileInputStream(scoreFile);	//스캐너에 인풋스트림을 이용하여 파일인풋스트림 객체를 생성.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		fileScan = new Scanner(is);	//  fileScan 이라는 Scanner에 is 을 넣어서 스캐너를 생성하고 변수에 넣는다.
		
		while(fileScan.hasNext()) {
			scList.add(str2Dto(fileScan.nextLine()));
		}
		fileScan.close();
		
		
	}
	
	// 데이터 저장 메소드 재정의
	
	// 데이터 문자열 가져오기
	
	// 데이터에서 한줄을 가져와 ,을 이용해서 배열생성.
	// 집어넣어야된다. 저장해야된다.

	
	// 리스트를 이용해서 ScoreDto를 생성한다.
	// ScoreDto로 객체를 생성해야된다.
	
	
	// scoreDto 객체에 데이터 배열을 매칭해서 집어넣는다.
	
	// 셋팅된 scoreDto를 리스트에 추가한다. add()로. add(scDto);
	
	
}
