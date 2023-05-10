package com.yopheu.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.classes.config.Line;
import com.yopheu.classes.datas.DataIndex;
import com.yopheu.classes.models.StudentDto;
import com.yopheu.classes.service.StudentService;

public class StudentServiceImplV2 implements StudentService{
	private List<StudentDto> stList;
	public StudentServiceImplV2() {
		this.stList = new ArrayList<>();
	}

	private StudentDto getStudentDto(String str) {
		StudentDto dto = new StudentDto();
		String[] student = str.split(",");
		dto.stNum = student[DataIndex.STUDENT.ST_NUM];
		dto.stName = student[DataIndex.STUDENT.ST_NAME];
		dto.stDept = student[DataIndex.STUDENT.ST_DEPT];
		dto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
		dto.stTel = student[DataIndex.STUDENT.ST_TEL];
		dto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];
		return dto;
	}
	
	@Override
	public void loadStudent() {
		String studentFile = "src/com/yopheu/classes/datas/student.csv";
		Scanner fileScan = null;
		InputStream is = null;
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		fileScan = new Scanner(is);
		while(fileScan.hasNext()) {
			StudentDto dto = new StudentDto();
			String[] student = fileScan.nextLine().split(",");
			dto.stNum = student[DataIndex.STUDENT.ST_NUM];
			dto.stName = student[DataIndex.STUDENT.ST_NAME];
			dto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			dto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			dto.stTel = student[DataIndex.STUDENT.ST_TEL];
			dto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];
			stList.add(dto);
//			stList.add(getStudentDto(fileScan.nextLine()));
		}
		fileScan.close();
		
	}
	
	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호\t주소");
		System.out.println(Line.sLine(100));		
		int count = 0;
		for(StudentDto dto : stList) {
			count++;
			System.out.print(dto.stNum + "\t");
			System.out.print(dto.stName + "\t");
			System.out.print(dto.stDept + "\t");
			System.out.print(dto.stGrade + "\t");
			System.out.print(dto.stTel + "\t");
			System.out.print(dto.stAddress + "\t");
			System.out.print(dto.stNum.length());
//			System.out.print(dto.stNum.substring(dto.stNum.length()-4));
			System.out.println();
			if((count) % 5 == 0) {
				System.out.println(Line.sLine(100));
			}
		}
		System.out.println(Line.dLine(100));	
		
	}

	@Override
	public StudentDto getStudent(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
