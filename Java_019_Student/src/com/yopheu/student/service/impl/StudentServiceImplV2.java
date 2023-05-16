package com.yopheu.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.yopheu.student.models.StudentDto;
import com.yopheu.student.utils.Line;

/*
 * insertStudent, printStudent, loadStudent 모두 상속받는다.
 * 
 */
public class StudentServiceImplV2 extends StudentServiceImplV1 {
	String studentFile = "src/com/yopheu/student/service/student.txt";
	
	protected StudentDto seachStDto(String stNum) {
		StudentDto stdDto = null;
		for(StudentDto dto : stdList) {
			if(dto.stNum.equals(stNum)) {
				stdDto = dto;
				break;
			}
		}
		return stdDto;
	}
	protected void printStDto(StudentDto dto) {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t학년\t전화번호");
		System.out.println(Line.sLine(100));
		System.out.printf("%s\t", dto.stNum);
		System.out.printf("%s\t", dto.stName);
		System.out.printf("%s\t", dto.stDept);
		System.out.printf("%d\t", dto.stGrade);
		System.out.printf("%s\n", dto.stTel);
		System.out.println(Line.sLine(100));
	}
	
	protected StudentDto inputStudent() {
		System.out.println(Line.dLine(60));
		System.out.println("학생정보 입력 종료하려면 QUIT 입력");
		System.out.println(Line.sLine(60));

		StudentDto stDto = null;
		String stNum = "";
		while(true) {
			System.out.print("학번 >> ");
			stNum = scan.nextLine();
			if (stNum.equalsIgnoreCase("QUIT")) break;
			
			try {
				int intNum = Integer.valueOf(stNum);
				stNum = String.format("%04d", intNum);
				stDto = seachStDto(stNum);
				if(stDto != null) {
					printStDto(stDto);
					System.out.println(stDto.stNum + " 학번의 학생 데이터가 이미 존재하여 수정하겠습니다.");
					System.out.println("=".repeat(60));
					break;
				}
			} catch (Exception e) {
				System.out.println("학번은 정수로 입력하세요");
				continue;
			}
			break;
		}
		if (stNum.equalsIgnoreCase("QUIT")) return null;

//		System.out.printf("이름(%s) >> ", stDto.stName == null ? "신규" : stDto.stName);
//		String stName = scan.nextLine();
//		if(stName.equals("")) stName = stDto.stName;
		String stName;
		if(stDto != null) {
			System.out.print("이름(" + stDto.stName + ") >> ");
			stName = scan.nextLine();
			if(stName.equals("")) stName = stDto.stName;
		}else {
			System.out.print("이름(신규) >> ");
			stName = scan.nextLine();
		}
		if (stName.equalsIgnoreCase("QUIT")) return null;

		String stDept;
		if(stDto != null) {
			System.out.print("학과(" + stDto.stDept + ") >> ");
			stDept = scan.nextLine();
			if(stDept.equals("")) stDept = stDto.stDept;
		}else {
			System.out.print("학과(신규) >> ");
			stDept = scan.nextLine();
		}
		if (stDept.equalsIgnoreCase("QUIT")) return null;

		int intGrade = 0;
		while (true) {
			String strGrade;
			if(stDto != null) {
				System.out.print("학년(" + stDto.stGrade + ") >> ");
				strGrade = scan.nextLine();
				if(strGrade.equals("")) strGrade = "" + stDto.stGrade;
			}else {
				System.out.print("학년(0) >> ");
				strGrade = scan.nextLine();
			}
			if (strGrade.equalsIgnoreCase("QUIT")) break;
			try {
				intGrade = Integer.valueOf(strGrade);
			} catch (Exception e) {
				// TODO: handle exception'
				System.out.println("학년은 정수로 입력하세요");
				continue;
			}
			if (intGrade < 1 || intGrade > 4) {
				System.out.println("학년은 정수 1 ~ 4까지만 입력하세요");
				continue;
			}
			break;
		}
		if(intGrade == 0) return null;
		
		String stTel;
		if(stDto != null) {
			System.out.print("전화번호(" + stDto.stTel + ") >> ");
			stTel = scan.nextLine();
			if(stTel.equals("")) stTel = stDto.stTel;
		}else {
			System.out.print("전화번호(신규) >> ");
			stTel = scan.nextLine();
		}
		if (stTel.equalsIgnoreCase("QUIT")) return null;

		if(stDto == null) {
			stDto = new StudentDto();
			stDto.stNum = stNum;
			stDto.stName = stName;
			stDto.stDept = stDept;
			stDto.stGrade = intGrade;
			stDto.stTel = stTel;
			return stDto;
		}else {
			stDto.stNum = stNum;
			stDto.stName = stName;
			stDto.stDept = stDept;
			stDto.stGrade = intGrade;
			stDto.stTel = stTel;
			return inputStudent();
		}
	}
	
	@Override
	public void insertStudent() {
		while(true) {
			StudentDto stDto = this.inputStudent();
			if(stDto == null) break;
			stdList.add(stDto);
		}
		
		OutputStream os = null;
		PrintWriter out = null;
		try {
			os = new FileOutputStream(studentFile);
			out = new PrintWriter(os);

			for(StudentDto dto : stdList) {
				out.print(dto.stNum + ",");
				out.print(dto.stName + ",");
				out.print(dto.stDept + ",");
				out.print(dto.stGrade + ",");
				out.println(dto.stTel);
			} // end while
			
			out.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadStudent() {
		InputStream is = null;
		Scanner scan = null;
		stdList.clear();
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String[] st = scan.nextLine().split(",");
			
			StudentDto stDto = new StudentDto();
			stDto.stNum = st[0];
			stDto.stName = st[1];
			stDto.stDept = st[2];
			stDto.stGrade = Integer.valueOf(st[3]);
			stDto.stTel = st[4];
			stdList.add(stDto);
		}
	}
	
	public void deleteStudent() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String strNum;
			System.out.print("삭제할 학번 >> ");
			strNum = scan.nextLine();
			
			try {
				int intNum = Integer.valueOf(strNum);
				strNum = String.format("%04d", intNum);
				int rows = 0;
				for(StudentDto dto : stdList) {
					if(dto.stNum.equals(strNum)) {
						System.out.println(dto.toString());
						break;
					}
					rows++;
				}
				if(rows < stdList.size()) {
					System.out.print("정말 삭제할까요?(Y/N) >> ");
					String strDel = scan.nextLine();
					if(strDel.equals("Y")) {
						stdList.remove(rows);
					}
					break;
				}else {
					System.err.println("학번을 확인하세요.");
				}
			} catch (Exception e) {
				System.out.println("학번을 확인하세요.");
			}
			
			
		}
		
		OutputStream os = null;
		PrintWriter out = null;
		try {
			os = new FileOutputStream(studentFile);
			out = new PrintWriter(os);

			for(StudentDto dto : stdList) {
				out.print(dto.stNum + ",");
				out.print(dto.stName + ",");
				out.print(dto.stDept + ",");
				out.print(dto.stGrade + ",");
				out.println(dto.stTel);
			} // end while
			
			out.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
