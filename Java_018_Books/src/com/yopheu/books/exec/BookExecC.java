package com.yopheu.books.exec;

import com.yopheu.books.service.BookService;
import com.yopheu.books.service.impl.BookServiceImplV1;

public class BookExecC {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImplV1();
		bookService.loadBook();
		bookService.printBookList();
	}
}
