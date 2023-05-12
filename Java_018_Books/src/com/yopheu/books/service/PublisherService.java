package com.yopheu.books.service;

import java.util.List;

import com.yopheu.books.models.PublisherDto;

public interface PublisherService {
	public void loadPubliser();
	public void printPubliserList();
	public PublisherDto getPubliser(String code);
	public List<PublisherDto> getPubliserList();
	public List<PublisherDto> getPubliserListByName(String name);

}
