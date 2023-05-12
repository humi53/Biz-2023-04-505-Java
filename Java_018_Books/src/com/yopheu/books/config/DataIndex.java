package com.yopheu.books.config;

public class DataIndex {
	
	//﻿ISBN	도서명	출판사	저자	발행일	페이지	가격
	public static class Book{
		public static final int ISBN = 0;
		public static final int TITLE = 1;
		public static final int PUBLISHER = 2;
		public static final int AUTHOR = 3;
		public static final int PUBLISHDATE = 4;
		public static final int PAGES = 5;
		public static final int PRICE = 6;
	}
	
	// 저자코드,저자명,전화번호,주소	
	public static class Author{
		public static final int CODE = 0;
		public static final int NAME = 1;
		public static final int TEL = 2;
		public static final int ADDRESS = 3;
	}
	
	// 출판사코드,출판사명,대표,전화번호,주소
	public static class Publiser{
		public static final int CODE = 0;
		public static final int NAME = 1;
		public static final int CEO = 2;
		public static final int TEL = 3;
		public static final int ADDRESS = 4;
	}
}
