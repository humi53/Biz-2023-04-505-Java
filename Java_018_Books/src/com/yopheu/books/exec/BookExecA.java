package com.yopheu.books.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BookExecA {
	
	
	// ﻿ISBN	도서명	출판사	저자	발행일	페이지	가격
	// 0	1		2		3		4			5	6	
	
	
	/*
	 * 도서정보.csv 파일을 열어서
	 * 각 line 을 열어 들인 후
	 * index 0 부터 index 8번까지 데이터를 console 에 출력해 보기
	 */
	
	public static void main(String[] args) {
		String bookFile = "src/com/yopheu/books/data/도서정보(2023-05-11).txt";
		Scanner scan = null;
		InputStream is = null;
		
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(bookFile + " 파일이 없습니다.");
			return;
		}
		
		/*
		 * InputStream(FileInputStream)를 사용하여
		 * 직접 파일 내용을 읽을 수 있다.
		 * 하지만 그 절차가 상당히 많은 코딩을 해야 한다.
		 * 좀 더 쉽게 text 파일을 읽어서 메모리로 가져오기 위해
		 * Scanner 도구를 연결하여 사용하는 것이다
		 */
		scan = new Scanner(is);
//		for(int i = 0; i < 9; i++) {
//			System.out.println(scan.nextLine());
//		}
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] book = line.split(",");
			
			for(String str : book) {
				System.out.print(str + "\t");
			}
			System.out.println();
		}
		scan.close();
		
	}
	
	
}
