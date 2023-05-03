package com.yopheu.scanner.service;

import java.util.Scanner;

import com.yopheu.scanner.models.StudentDto;

public class StudentServiceV2 {
	private StudentDto[] stList;
	int reNum = 70;
	public void inputStudents() {
		stList = new StudentDto[5];
		for(int i = 0; i < stList.length; i++) {
			stList[i] = new StudentDto();
		}
		
		Scanner scan = new Scanner(System.in);

		String stNum = "";
		String stName = "";
		String stDept = "";
		String stGrade = "";
		String stTel = "";
		int intGrade = 0;

		for(int i = 0; i < stList.length; i++) {
			System.out.println("학생 정보를 입력해 봅시다.");
			System.out.print("학번 >> ");
			stNum = String.format("23%03d", i+1);
			System.out.println("(자동입력) " + stNum);
			
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
			
			stList[i].setStNum(stNum);
			stList[i].setStName(stName);
			stList[i].setStDept(stDept);
			stList[i].setStGrade(intGrade);
			stList[i].setStTel(stTel);
			System.err.println("test 입력결과 확인 : " + stList[i].toString());
		}
		
		for(int i = 0; i < stList.length; i++) {
			System.out.println("test 입력결과 확인 : " + stList[i].toString());
		}
		scan.close();

	}
	
	public void printStudents() {
		System.out.println("=".repeat(reNum));
		System.out.println(" 학번\t이름\t     학과\t학년\t전화번호");
		System.out.println("-".repeat(reNum));
		for (StudentDto stDto : stList) {
			System.out.print(stDto.getStNum() + "\t");
			System.out.print(stDto.getStName() + "\t");
			System.out.printf(stDto.getStDept() + "\t");
			System.out.printf("%4d\t", stDto.getStGrade());
			System.out.println(stDto.getStTel() + "\t");
		}
		System.out.println("=".repeat(reNum));
	}
}
