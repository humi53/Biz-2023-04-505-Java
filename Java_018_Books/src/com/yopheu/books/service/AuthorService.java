package com.yopheu.books.service;

import java.util.List;

import com.yopheu.books.models.AuthorDto;

public interface AuthorService {
	public void loadAuthor();
	public void printAuthorList();
	
	public AuthorDto getAuthor(String code);
	public List<AuthorDto> getAuthorList();
	
}
