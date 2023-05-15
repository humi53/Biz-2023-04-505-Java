package com.yopheu.student.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.student.models.StudentDto;
import com.yopheu.student.utils.Line;

public class StudentExecA {
	public static String inputData(String stCUI) {
		Scanner scan = new Scanner(System.in);
		String str = "";
		System.out.print(stCUI + " >> ");
		str = scan.nextLine();
//		scan.close();
		return str; 
	}
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
		
		List<StudentDto> stdList = new ArrayList<>();
		
		String sNum = "";
		String sName = "";
		String sDept = "";
		String sGrade = "";
		int iGrade = 0;
		String sTel = "";
		
		/*
		 * 어떤 데이터를 입력할것인가 라는 안내메시지
		 * 각 속성(요소)를 입력할때 prompt 보이기
		 */
		System.out.println(Line.dLine(80));
		System.out.println(" 학생 정보 입력");
		System.out.println(Line.sLine(80));
//		System.out.print("학번 >> ");
//		sNum = scan.nextLine();
//		System.out.print("학생이름 >> ");
//		sName = scan.nextLine();
//		System.out.print("학과 >> ");
//		sDept = scan.nextLine();
//		System.out.print("학년(정수) >> ");
//		sGrade = scan.nextLine();
//		iGrade = Integer.valueOf(sGrade);
//		System.out.print("전화번호 >> ");
//		sTel = scan.nextLine();
		
		sNum = inputData("학번");
		sName = inputData("학생이름");
		sDept = inputData("학과");
		sGrade = inputData("학년(정수)");
		iGrade = Integer.valueOf(sGrade);
		sTel = inputData("전화번호");
		
		StudentDto stDto = new StudentDto();
		stDto.stNum = sNum;
		stDto.stName = sName;
		stDto.stDept = sDept;
		stDto.stGrade = iGrade;
		stDto.stTel = sTel;
		
		stDto = new StudentDto(sNum, sName, sDept, iGrade, sTel);
		
		System.out.println(stDto.toString());
		
		stdList.add(stDto);
		System.out.println(stdList.toString());

		
//		scan.close();
	}
}
