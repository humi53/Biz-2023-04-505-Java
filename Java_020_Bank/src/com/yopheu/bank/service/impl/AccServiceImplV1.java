package com.yopheu.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.bank.models.AccDto;
import com.yopheu.bank.service.AccService;

public class AccServiceImplV1 implements AccService{

	List<AccDto> accList;
	
	public AccServiceImplV1() {
		accList = new ArrayList<>();
	}
	
	protected int getTotal(String acNum) {
		int total = 0;
		for(AccDto dto : accList) {
			if(dto.acNum.equals(acNum)) {
				total += dto.acInput;
				total -= dto.acOutput;
			}
		}
		return total;
	}
	
	protected void setIn(int in) {
		
	}
	
	
	@Override
	public void accInit() {
		String acNum = "0001";
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			String inOut = "";
			inOut = scan.nextLine();
			System.out.println("계좌번호 : " + acNum);
			System.out.println("잔금은 : " + getTotal(acNum));
			System.out.print("1. 입금, 2. 출금, 3. 종료 >> ");
			while(true) {
				if(inOut.equals("1")) {
					AccDto accDto = new AccDto();
					int in = 0;
					while(true) {
						System.out.print("입금금액 >> ");
						String sin = scan.nextLine();
						try {
							in = Integer.valueOf(sin);
							break;
						} catch (Exception e) {
							System.out.println("숫자만 입력하세요.");
						}
					}
					
					accDto.acNum = acNum;
					accDto.acDiv = "입금";
					accDto.acInput = in;
					accDto.acOutput = 0;
					
					
					break;
				}else if(inOut.equals("2")){
					break;
				}else if(inOut.equals("3")) {
					break;
				}else {
					System.out.println("1, 2, 3 중에 입력하세요.");
				}
			}
			if(inOut.equals("3")) {
				System.out.println("종료합니다.");
				break;
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
