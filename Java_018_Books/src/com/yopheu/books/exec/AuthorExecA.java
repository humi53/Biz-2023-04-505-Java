package com.yopheu.books.exec;

import com.yopheu.books.service.AuthorService;
import com.yopheu.books.service.impl.AuthorServiceImplV1;

public class AuthorExecA {
	public static void main(String[] args) {
		AuthorService auService = new AuthorServiceImplV1();
		auService.loadAuthor();
		auService.printAuthorList();
//		System.out.println(auService.getAuthor("A0025").toString());
		
	}
}
