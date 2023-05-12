package com.yopheu.books.exec;

import com.yopheu.books.service.PublisherService;
import com.yopheu.books.service.impl.PublisherServiceImplV1;

public class PubliserExecA {
	public static void main(String[] args) {
		PublisherService publisherService = new PublisherServiceImplV1();
		publisherService.loadPubliser();
		publisherService.printPubliserList();
		System.out.println(publisherService.getPubliserListByName("라").toString());
		
	}
}
