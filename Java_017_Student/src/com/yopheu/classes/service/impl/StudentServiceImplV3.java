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
import com.yopheu.classes.service.impl.StudentServiceImplV1;
import com.yopheu.classes.service.impl.StudentServiceImplV2;

/*
 * StudentServiceImplV1 은 StudentService interface 를 implements 하였고
 * StudentServiceImplV3 는 StudentServiceImplV1 을 extends 하였다
 */

public class StudentServiceImplV3 implements StudentService{
	
	protected List<StudentDto> stdList;
	public StudentServiceImplV3() {
		stdList = new ArrayList<>();
	}
	
	@Override
	public void loadStudent() {
		String studentFile = "src/com/yopheu/classes/datas/student.csv";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return;
		}
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] student = line.split(",");
			StudentDto stDto = new StudentDto();
			stDto.stNum = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			stDto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stTel = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];
			stdList.add(stDto);
		}
		scan.close();
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호\t주소");
		System.out.println(Line.sLine(100));	
		int rows = 0;
		for(StudentDto dto : stdList) {
			System.out.print(dto.stNum + "\t");
			System.out.print(dto.stName + "\t");
			System.out.print(dto.stDept + "\t");
			System.out.print(dto.stGrade + "\t");
			System.out.print(dto.stTel + "\t");
			System.out.print(dto.stAddress + "\t");
			System.out.println();
			// 5줄 마다 구분선을 출력
			// 다만 구분선 출력 위치가 리스트의 끝보다 작을때만
			if(++rows % 5 == 0 && rows < stdList.size()) {
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
