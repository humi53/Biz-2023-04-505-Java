package com.yopheu.classes.service.impl;

import java.util.ArrayList;

import com.yopheu.classes.config.Line;
import com.yopheu.classes.models.StudentDto;

public class StudentServiceImplV4 extends StudentServiceImplV3{
	public StudentServiceImplV4() {
		// stdList 객체는 V3 클래스에서 protected 로 선언한 객체이다
		// 이 객체는 V3 클래스를 상속(extends)받은 클래스에서 접근 가능하다
		stdList = new ArrayList<>();
	}
	
	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학년\t\t학과\t전화번호\t주소");
		System.out.println(Line.sLine(100));
		
		int rows = 0;
		for(StudentDto dto : stdList) {
			System.out.printf("%s\t", dto.stNum);
			System.out.printf("%s\t", dto.stName.substring(0, 3));
			System.out.printf("%s\t", dto.stDept);
			System.out.printf("%d\t", dto.stGrade);
			System.out.printf("%s\t", dto.stTel);
			System.out.printf("%s\t", dto.stAddress);
			System.out.println();
			if(++rows % 5 == 0 && rows < stdList.size()) {
				System.out.println(Line.sLine(100));
			}
		}
		System.out.println(Line.dLine(100));
	}
}
