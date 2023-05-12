package com.yopheu.test.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.test.config.Config;
import com.yopheu.test.models.GuideDto;
import com.yopheu.test.service.GuideService;

public class GuideServiceImplV1 implements GuideService{
	
	List<GuideDto> list;
	public GuideServiceImplV1() {
		list = new ArrayList<>();
	}
	
	@Override
	public void loadGuide() {
		String guFile = "src/com/yopheu/test/data/guide.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(guFile);
		} catch (FileNotFoundException e) {
			System.out.println("fail");
		}
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String[] cont = scan.nextLine().split(",");
			//id,종목명,순번,가이드
			GuideDto dto = new GuideDto();
			dto.setGuId(cont[Config.Guide.ID]);
			dto.setGuName(cont[Config.Guide.NAME]);
			dto.setGuNum(cont[Config.Guide.NUM]);
			dto.setGuGuide(cont[Config.Guide.GUIDE]);
			list.add(dto);
		}
		
		scan.close();
	}

	@Override
	public void printGuideList() {
		System.out.println("=".repeat(100));
		System.out.println("id\t종목명\t\t순번\t가이드");
		String idCheck = "";
		for(GuideDto dto : list) {
			if(!(idCheck.equals(dto.getGuId()))) {
				System.out.println("-".repeat(100));
				idCheck = dto.getGuId();
			}
			System.out.print(dto.getGuId() + "\t");
			System.out.print(dto.getGuName() + "\t");
			System.out.print(dto.getGuNum() + "\t");
			System.out.print(dto.getGuGuide() + "\n");
		}
		System.out.println("=".repeat(100));
	}

}
