package com.yopheu.student.exec;

import java.util.Scanner;

import com.yopheu.student.service.StudentService;
import com.yopheu.student.service.impl.StudentServiceImplV2;

public class StudentExecG {
	public static void main(String[] args) {
		StudentServiceImplV2 stService = new StudentServiceImplV2();
		Scanner scan = null;
		scan = new Scanner(System.in);
		while(true) {
			String inStr = "";
			System.out.println("=".repeat(70));
			System.out.println(" 대한고교 학사관리 2023");
			System.out.println("=".repeat(70));
			System.out.println(" 실행할 업무를 선택하세요.");
			System.out.println("-".repeat(70));
			System.out.println(" 1. 학생 리스트 확인");
			System.out.println(" 2. 학생정보 추가/수정");
			System.out.println(" 3. 학생정보 삭제");
			System.out.println(" 9. 업무종료.");
			System.out.println("-".repeat(70));
			System.out.print(" 업무선택 >> ");
			try {
				inStr = scan.nextLine();
				if(inStr.equals("1")) {
					stService.loadStudent();
					stService.printStudent();
					System.out.println("Enter를 누르세요.");
					scan.nextLine();
				}else if(inStr.equals("2")) {
					stService.loadStudent();
					stService.insertStudent();
				}else if(inStr.equals("3")) {
					stService.loadStudent();
					stService.deleteStudent();
				}else if(inStr.equals("9")) {
					break;
				}
			} catch (Exception e) {
				System.out.println("매뉴에 있는 숫자만 고르세요.");
			}
		}
		System.out.println("끝!");
	}
}
