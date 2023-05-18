package com.yopheu.bank.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yopheu.bank.models.AccDto;
import com.yopheu.bank.models.BuyerDto;
import com.yopheu.bank.service.AccService;
import com.yopheu.bank.service.BuyerService;
import com.yopheu.bank.utils.AnsiConsol;
import com.yopheu.bank.utils.Config;
import com.yopheu.bank.utils.Line;

public class AccServiceImplV1A implements AccService{

	protected List<AccDto> accList;
	protected BuyerService buyerService;
	protected Scanner scan;
	
	public AccServiceImplV1A() {
		accList = new ArrayList<>();
		buyerService = new BuyerServiceImplV1A();
		scan = new Scanner(System.in);
	}
	
	/*
	 * 계좌번호 format
	 *   1000-2023-05-18-0001
	 * 
	 * "1000" : 은행 코드
	 * "2023-05-18" : 계좌를 신설한 날짜
	 * "0001" : 일련번호
	 * 
	 */
	
	protected String getNewAccNum() {
		
		// 컴퓨터의 현재 시각을 get 하는 클래스
		// System.currentTimeMillis() 
		// 		1920.1.1 00:00:00.000 부터 시작하여
		//		현재시점까지 카운트된 밀리세컨드 값
		// 이 값을 Date 클래스의 생성자에 전달하면
		// 현재 날짜, 시각 정보를 알수 있는 객체로 생성해 준다
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = todayFormat.format(date);
		
		int maxNum = 0;
		String numBank = "1000";
		for(AccDto accDto : accList) {
			// 1000-2023-05-18-0001
			String accNum = accDto.acNum;
			
			// 처음의 4글자를 잘라서 bank 코드 추출하기
			numBank = accNum.substring(0, 4);
			
			// 날짜 부분 추출하기
			String numDate = accNum.substring(5, todayString.length());
			
			if(numDate != null && numDate.equals(todayString)) {
				
				// 일련번호 부분만 추출하기
				String lastNum = accNum.substring(numBank.length() + todayString.length());
				int intNum = Integer.valueOf(lastNum);
				if(maxNum < intNum) maxNum = intNum;
			}
		} // end for
		
		// maxNum 는 0 또는 최대값
		String newNum = String.format("%s-%s-%04d", numBank,todayString, maxNum + 1);
		
		return newNum;
	}
	
	@Override
	public void accInit() {
		Config.bankTitel("계좌생성");
		
		while(true) {
			String accNum = getNewAccNum();
			System.out.println(Line.sLine(100));
			System.out.println("생성된 계좌번호 : " + accNum);
			System.out.println(Line.sLine(100));
			
			String strBuid = "";
			while(true) {
				System.out.println("고객번호를 입력해 주세요.");
				System.out.print("고객번호 >> ");
				strBuid = scan.nextLine();
				if(strBuid.equalsIgnoreCase("QUIT")) break;
				
				try {
					int intBuId = Integer.valueOf(strBuid);
					strBuid = String.format("%04d", intBuId);
					BuyerDto buyerDto = buyerService.getBuyer(strBuid);
					if(buyerDto == null) {
						System.out.println(AnsiConsol.message("blue","고객정보가 없습니다"));
						System.out.println("고객정보를 먼저 등록해 주세요");
					}else {
						System.out.println(Line.sLine(100));
						System.out.println(buyerDto.toString());
						System.out.println(Line.sLine(100));
					}
				} catch (Exception e) {
					System.out.println("고객번호는 정수로 입력");
				}
			}
		}
	}

	@Override
	public void inout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAccList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAccList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadAccList() {
		// TODO Auto-generated method stub
		
	}

}
