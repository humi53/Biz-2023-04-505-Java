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

public class BookServiceImplV2 implements BookService{

	protected List<BookDto> bookList;
	public BookServiceImplV2() {
		bookList = new ArrayList<>();
	}
	
	// 도서정보.txt 파일을 읽어와서
	// List<BookDto> type 리스트 데이터로 변환하는 method
	@Override
	public void loadBook() {
		String bookFile = "src/com/yopheu/books/data/도서정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] book = line.split(",");
			
			BookDto bDto = new BookDto();
			bDto.setbIsbn(book[DataIndex.Book.ISBN]);
			bDto.setbTitle(book[DataIndex.Book.TITLE]);
			bDto.setbPublisher(book[DataIndex.Book.PUBLISHER]);
			bDto.setbAuthor(book[DataIndex.Book.AUTHOR]);
			bDto.setbPublishDate(book[DataIndex.Book.PUBLISHDATE]);
			bDto.setbPages(Integer.valueOf(book[DataIndex.Book.PAGES]));
			bDto.setbPrice(Integer.valueOf(book[DataIndex.Book.PRICE].trim()));
			bookList.add(bDto);
		}
		scan.close();
	}

	@Override
	public void printBookList() {
		System.out.println("=".repeat(100));
		System.out.println("ISBN\t\t도서명\t\t\t\t\t\t\t출판사\t저자\t발행일\t\t페이지\t가격\t");
		System.out.println("-".repeat(100));
		
		for(BookDto bDto : bookList) {
			System.out.printf("%s\t", bDto.getbIsbn());
			System.out.printf("%-40s\t", bDto.getbTitle());
			int titleSize = bDto.getbTitle().length();
			if(titleSize < 10) {
				System.out.print("\t");
			} 
			System.out.printf("%s\t", bDto.getbPublisher());
			System.out.printf("%s\t", bDto.getbAuthor());
			System.out.printf("%s\t", bDto.getbPublishDate());
			System.out.printf("%d\t", bDto.getbPages());
			System.out.printf("%d\t", bDto.getbPrice());
			System.out.println();
		}
		
		System.out.println("=".repeat(100));
		
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
