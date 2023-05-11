package com.yopheu.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.books.config.DataIndex;
import com.yopheu.books.models.BookDto;
import com.yopheu.books.service.BookService;

public class BookServiceImplV1 implements BookService{

	private List<BookDto> bookList;
	protected int titleRepeat = 160;
	
	public BookServiceImplV1() {
		this.bookList = new ArrayList<>();
	}

	protected BookDto strToBookDto(String[] bookInfo) throws Exception{
		BookDto bDto = new BookDto();
		//﻿ISBN	도서명	출판사	저자	발행일	페이지	가격
		try {
			bDto.setbIsbn(bookInfo[DataIndex.Book.ISBN]);
			bDto.setbTitle(bookInfo[DataIndex.Book.TITLE]);
			bDto.setbPublisher(bookInfo[DataIndex.Book.PUBLISHER]);
			bDto.setbAuthor(bookInfo[DataIndex.Book.AUTHOR]);
			bDto.setbPublishDate(bookInfo[DataIndex.Book.PUBLISHDATE]);
			bDto.setbPages(Integer.valueOf(bookInfo[DataIndex.Book.PAGES]));
			bDto.setbPrice(Integer.valueOf(bookInfo[DataIndex.Book.PRICE].trim()));
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		return bDto;		
	}
	@Override
	public void loadBook() {
		String bookFile = "src/com/yopheu/books/data/도서정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일의 경로가 잘못되었습니다.");
		}
		
		scan = new Scanner(is);
		
		int row = 0;
		while(scan.hasNext()) {
			String[] bookInfo = scan.nextLine().split(",");
			
			row++;
			try {
				bookList.add(strToBookDto(bookInfo));
			} catch (Exception e) {
				bookList = null;
				System.out.println(row + "번째 데이터에 이상이 있습니다.");
			}
		}
		scan.close();
	}

	protected void printHead() {
		System.out.println("=".repeat(titleRepeat));
		System.out.println("ISBN\t\t도서명\t\t\t\t\t\t\t출판사\t저자\t발행일\t\t페이지\t가격\t");
		System.out.println("-".repeat(titleRepeat));
	}
	
	protected void printTail() {
		System.out.println("=".repeat(titleRepeat));
	}
	
	protected void printBook(BookDto bDto) {
		System.out.printf("%s\t", bDto.getbIsbn());
		System.out.printf("%-40s\t", bDto.getbTitle());
		int titleSize = bDto.getbTitle().length();
		if(titleSize < 13) {
			System.out.print("\t");
		} 
		System.out.printf("%s\t", bDto.getbPublisher());
		System.out.printf("%s\t", bDto.getbAuthor());
		System.out.printf("%s\t", bDto.getbPublishDate());
		System.out.printf("%d\t", bDto.getbPages());
		System.out.printf("%d\t", bDto.getbPrice());
		System.out.println();
	}
	
	@Override
	public void printBookList() {
		printHead();
		for(BookDto bDto : bookList) {
			printBook(bDto);
		}
		printTail();
		
	}

	@Override
	public BookDto getBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> getBookList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String isbn) {
		// TODO Auto-generated method stub
		
	}

}
