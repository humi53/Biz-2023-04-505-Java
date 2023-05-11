package com.yopheu.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.books.config.DataIndex;
import com.yopheu.books.models.AuthorDto;
import com.yopheu.books.service.AuthorService;

public class AuthorServiceImplV1 implements AuthorService{
	List<AuthorDto> auList;
	
	public AuthorServiceImplV1() {
		auList = new ArrayList<>();
	}
	
	@Override
	public void loadAuthor() {
		String auFile = "src/com/yopheu/books/data/저자정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(auFile);
		} catch (FileNotFoundException e) {
			System.out.println("파일의 주소가 잘못되었습니다.");
			return;
		}
		scan = new Scanner(is);
		
		int row = 0;
		while(scan.hasNext()) {
			row++;
			String[] author = scan.nextLine().split(",");
			AuthorDto dto = new AuthorDto();
			int auSize = author.length;
			if(auSize < 4) {
				System.out.println(row + "번째 줄의 잘못된 데이터가 있습니다.");
				scan.close();
				break;
			} else {
				dto.setAuCode(author[DataIndex.Author.CODE]);
				dto.setAuName(author[DataIndex.Author.NAME]);
				dto.setAuTel(author[DataIndex.Author.TEL]);
				dto.setAuAddress(author[DataIndex.Author.ADDRESS]);
				auList.add(dto);
			}
		}
		scan.close();
	}

	@Override
	public void printAuthorList() {
		System.out.println("=".repeat(100));
		System.out.println("저자코드\t저자명\t전화번호\t주소\t");
		System.out.println("-".repeat(100));
		for(AuthorDto dto : auList) {
			System.out.print(dto.getAuCode() + "\t");
			System.out.print(dto.getAuName() + "\t");
			System.out.print(dto.getAuTel() + "\t");
			System.out.print(dto.getAuAddress() + "\t");
			System.out.println();
		}
		System.out.println("=".repeat(100));
		
	}
	
	@Override
	public AuthorDto getAuthor(String code) {
		if(auList.isEmpty()) {
			this.loadAuthor();
		}
		
		for(AuthorDto dto : auList) {
			if(dto.getAuCode().equalsIgnoreCase(code)) {
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<AuthorDto> getAuthorList() {
		if(auList.isEmpty()) {
			this.loadAuthor();
		}
		return auList;
	}

}
