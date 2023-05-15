package com.yopheu.exam.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.exam.models.GuideDto;
import com.yopheu.exam.service.GuideService;
import com.yopheu.exam.utils.Index;

public class GuideServiceImplV1 implements GuideService{
	// 객체에 final 키워드를 부착하면 반드시 생성장에서 생성해주어야 한다.
	protected final List<GuideDto> guideList;
	
	public GuideServiceImplV1() {
		this.guideList = new ArrayList<>();
	}
	@Override
	public void loadGuide() {
		String guideFile = "src/com/yopheu/exam/guide.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(guideFile);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		scan = new Scanner(is);
		int rows = 0;
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] guide = line.split(",");
			GuideDto guDto = new GuideDto();
			try {
				guDto.id = guide[Index.GUIDE.GU_ID];
				guDto.item = guide[Index.GUIDE.GU_ITEM];
				guDto.seq = Integer.valueOf(guide[Index.GUIDE.GU_SEQ]);
				guDto.guide = guide[Index.GUIDE.GU_GUIDE];
				guideList.add(guDto);
			} catch (Exception e) {
				System.out.println(rows + " 번째 에서 Exception 발생");
			}
		}
		
		scan.close();
		System.out.println("로딩된 데이터 갯수 : " + guideList.size());
	}

	@Override
	public void printGuide() {
		System.out.println("=".repeat(150));
		System.out.println("ID\t종목명\t순서\t가이드");
		
		String id = "";
		for(GuideDto dto : guideList) {
			if(!id.equals(dto.id)) {
				System.out.println("-".repeat(150));
				id = dto.id;
			}
			System.out.printf("%s\t", dto.id);
			System.out.printf("%s\t", dto.item);
			System.out.printf("%d\t", dto.seq);
			System.out.printf("%s\t", dto.guide);
			System.out.println();
		}
		
		
		
		System.out.println("=".repeat(150));
		
	}

}
