package com.yopheu.scanner.service;

import java.util.Scanner;

import com.yopheu.scanner.models.StudentDto;

public class StudentServiceV1 {

	public void inputStudent() {
		StudentDto student = new StudentDto();
		Scanner scan = new Scanner(System.in);

		System.out.println("학생 정보를 입력해 봅시다.");

		String stNum = "";
		String stName = "";
		String stDept = "";
		String stGrade = "";
		String stTel = "";
		int intGrade = 0;
		
		System.out.print("학번 >> ");
		stNum = scan.nextLine();

		System.out.print("이름 >> ");
		stName = scan.nextLine();

		System.out.print("학과 >> ");
		stDept = scan.nextLine();

		while (true) {
			System.out.print("학년 >> ");
			stGrade = scan.nextLine();

			try {
				intGrade = Integer.valueOf(stGrade);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("학년은 정수값만 입력해야 됩니다.");
				continue;
			}
			if(intGrade < 1 || intGrade > 4) {
				System.err.println("1 ~ 4 학년만 있어요.");
				continue;
			}
			break;
		}

		System.out.print("전화 >> ");
		stTel = scan.nextLine();
		
		student.setStNum(stNum);
		student.setStName(stName);
		student.setStDept(stDept);
		student.setStGrade(intGrade);
		student.setStTel(stTel);
		
		System.err.println("test 입력결과 확인 : " + student.toString());
		
		scan.close();

	}
}
