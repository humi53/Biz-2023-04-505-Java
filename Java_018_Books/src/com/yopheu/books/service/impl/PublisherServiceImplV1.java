package com.yopheu.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.books.config.DataIndex;
import com.yopheu.books.models.PublisherDto;
import com.yopheu.books.service.PublisherService;

public class PublisherServiceImplV1 implements PublisherService{

	List<PublisherDto> puList;
	
	public PublisherServiceImplV1() {
		puList = new ArrayList<>();
	}
	
	// PubliserDto List 셋팅
	@Override
	public void loadPubliser() {
		String puFile = "src/com/yopheu/books/data/출판사정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(puFile);
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로 설정이 잘못되었습니다.");
//			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String[] puArrData = scan.nextLine().split(",");
			PublisherDto puDto = new PublisherDto();
			// 출판사코드,출판사명,대표,전화번호,주소
			puDto.setPubCode(puArrData[DataIndex.Publiser.CODE]);
			puDto.setPubName(puArrData[DataIndex.Publiser.NAME]);
			puDto.setPubCeo(puArrData[DataIndex.Publiser.CEO]);
			puDto.setPubTel(puArrData[DataIndex.Publiser.TEL]);
			puDto.setPubAddress(puArrData[DataIndex.Publiser.ADDRESS]);
			puList.add(puDto);			
		}
		
		scan.close();
	}

	// PubliserDto List 출력
	@Override
	public void printPubliserList() {
		// 출판사코드,출판사명,대표,전화번호,주소
		
		System.out.println("=".repeat(100));
		System.out.println("출판사코드\t출판사명\t대표\t전화번호\t주소\t");
		System.out.println("-".repeat(100));
		for(PublisherDto dto : puList) {
			System.out.printf("%s\t", dto.getPubCode());
			System.out.printf("%s\t", dto.getPubName());
			System.out.printf("%s\t", dto.getPubCeo());
			System.out.printf("%s\t", dto.getPubTel());
			System.out.printf("%s\t", dto.getPubAddress());
			System.out.println();
		}
		System.out.println("=".repeat(100));
	}

	// Code로 PubliserDto return
	@Override
	public PublisherDto getPubliser(String code) {
		for(PublisherDto dto : puList) {
			if(dto.getPubCode().equalsIgnoreCase(code)) {
				return dto;
			}
		}
		return null;
	}

	// PubliserDto List 전체를 return
	@Override
	public List<PublisherDto> getPubliserList() {
		return puList;
	}

	// name 으로 PubliserDto return
	@Override
	public List<PublisherDto> getPubliserListByName(String name) {
		List<PublisherDto> resultList = new ArrayList<>();
		for(PublisherDto dto : puList) {
			if(dto.getPubName().contains(name)) {
				resultList.add(dto);
			}
		}
		return resultList;
	}

}
