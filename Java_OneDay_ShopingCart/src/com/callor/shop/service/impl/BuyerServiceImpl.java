package com.callor.shop.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.service.BuyerService;

public class BuyerServiceImpl implements BuyerService{
	protected BuyerDao buyerDao;
	protected Scanner scan;
	
	public BuyerServiceImpl() {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		buyerDao = sqlSession.getMapper(BuyerDao.class);
		scan = new Scanner(System.in);
	}
	
	@Override
	public void printBuyerList() {
		List<BuyerDto> buyerDtoList = buyerDao.selectAll();
		printBuyerTitle();
		for(BuyerDto buyerDto : buyerDtoList) {
			printBuyer(buyerDto);
		}
		System.out.println("=".repeat(120));
	}
	
	private void printBuyerTitle() {
		System.out.println("=".repeat(120));
		System.out.println(" \t 고객정보");
		System.out.println("-".repeat(60));
		System.out.println("고객ID\t\t고객이름\t전화번호\t주소\t");
	}
	private void printBuyer(BuyerDto buyerDto) {
		// buId, buName, buTel, buAddr
		System.out.printf("%s\t", buyerDto.buId);
		System.out.printf("%s\t", buyerDto.buName);
		System.out.printf("%s\t", buyerDto.buTel);
		System.out.printf("%s\t", buyerDto.buAddr);
		System.out.println();
	}

	@Override
	public void insertBuyer() {
		BuyerDto buyerDto = new BuyerDto();
		String buId = "";
		String buName = "";
		String buTel = "";
		String buAddr = "";
		
		String maxId = buyerDao.getMaxBuId();
		try {
			if(maxId == null) maxId = "0";
			int intBuId = Integer.valueOf(maxId) + 1;
			buId = String.format("%010d", intBuId);
		} catch (Exception e) { System.out.println("숫자가 아닌 ID 값이 있습니다."); return;}
		System.out.printf("고객ID(자동) >> (%s) \n", buId);
		System.out.printf("고객이름 >> ");
		buName = scan.nextLine();
		System.out.printf("전화번호 >> ");
		buTel = scan.nextLine();
		System.out.printf("주소 >> ");
		buAddr = scan.nextLine();
		
		buyerDto.buId = buId;
		buyerDto.buName = buName;
		buyerDto.buTel = buTel;
		buyerDto.buAddr = buAddr;
		
		int result = buyerDao.insert(buyerDto);
		if(result < 0) {
			System.out.println(" err : 고객등록이 실패 하였습니다.");
		}else {
			System.out.printf("고객 [%s]%s 등록이 성공하였습니다.\n", buId, buName);
		}
	}
	
}
