package com.yopheu.bank.service.impl;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.bank.models.AccDto;
import com.yopheu.bank.models.BuyerDto;
import com.yopheu.bank.service.AccService;
import com.yopheu.bank.service.BuyerService;

public class AccServiceImplV1 implements AccService{

	/* 
	 * 신규계좌 등록하기
	 * 1. 고객번호를 입력받고,
	 * 2. 고객번호가 고객정보 있는가 확인
	 * 		BuyerServiceImplV1.getBuyer() method 를 사용하여
	 * 		고객정보 찾기
	 * 		없으면 : 고객정보를 등록하세요 라고 메시지 표현
	 * 3. 고객번호가 있으면 신규 계좌를 생성 : List<AccDto> type accList 에 추가
	 * 
	 */
	
	protected List<AccDto> accList;
	BuyerService buService;
	public AccServiceImplV1() {
		accList = new ArrayList<>();
		buService = new BuyerServiceImplV1();
		buService.loadBuyer();
	}
	
	@Override
	public void accInit() {
		InputStream is = null;
		Scanner scan = null;
		
		is = System.in;
		scan = new Scanner(is);
		while(true) {
			String buId = "";
			while(true) {
				try {
					System.out.println("신규계좌등록.");
					System.out.println("나가기 : QUIT");
					System.out.println("-".repeat(50));
					System.out.printf("고객번호 >> ");
					buId = scan.nextLine();
					if(buId.equalsIgnoreCase("QUIT")) break;
					int intBuId = Integer.valueOf(buId);
					buId = String.format("%04d", intBuId);
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력하세요.");
				}
			}
			if(buId.equalsIgnoreCase("QUIT")) break;
			
			BuyerDto buDto = buService.getBuyer(buId);
			if (buDto == null) {
				System.out.println("고객정보를 등록하세요.");
			}else {
				AccDto acDto = new AccDto();
				acDto.buId = buDto.buId;
				acDto.acNum = "1111-1111-1111";
				acDto.acDiv = "A";
				acDto.acBalance = 0;
				accList.add(acDto);
				System.out.println("--------------신규계좌를 생성완료 하였습니다.");
			}
		}
		System.out.println(accList.toString());
		
		
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
