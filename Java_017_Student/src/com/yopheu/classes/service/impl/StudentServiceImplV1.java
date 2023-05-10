package com.yopheu.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.classes.config.Line;
import com.yopheu.classes.datas.DataIndex;
import com.yopheu.classes.datas.DataSource;
import com.yopheu.classes.models.StudentDto;
import com.yopheu.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService{

	protected List<StudentDto> stdList;
	
	// stdList 객체는 SErvice 생성자에서 초기화 한다.
	public StudentServiceImplV1() {
		this.stdList = new ArrayList<>();
	}
	
	@Override
	public void loadStudent() {
		for (int index = 0; index < DataSource.STUDENT.length; index++) {
			StudentDto dto = new StudentDto();
			String[] student = DataSource.STUDENT[index].split(",");
			dto.stNum = student[DataIndex.STUDENT.ST_NUM];
			dto.stName = student[DataIndex.STUDENT.ST_NAME];
			dto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			dto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			dto.stTel = student[DataIndex.STUDENT.ST_TEL];
			dto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];
			stdList.add(dto);
		}
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호\t주소");
		System.out.println(Line.sLine(100));		
		for(StudentDto dto : stdList) {
			System.out.print(dto.stNum + "\t");
			System.out.print(dto.stName + "\t");
			System.out.print(dto.stDept + "\t");
			System.out.print(dto.stGrade + "\t");
			System.out.print(dto.stTel + "\t");
			System.out.print(dto.stAddress + "\t");
			System.out.println();
		}
		System.out.println(Line.dLine(100));		
	}

	/*
	 * stdList 에서 stNum 학번의 학생데이터를 찾아서
	 * 학생데이터를 return 
	 */
	@Override
	public StudentDto getStudent(String stNum) {
		for(StudentDto dto : stdList) {
			if(dto.stNum.equals(stNum)) {
				return dto;
			}
		}
		return null;
	}

}
