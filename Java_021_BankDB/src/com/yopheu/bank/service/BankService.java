package com.yopheu.bank.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yopheu.bank.config.DBContract;
import com.yopheu.bank.models.AccDto;
import com.yopheu.bank.models.AccListDto;
import com.yopheu.bank.models.BuyerDto;
import com.yopheu.bank.service.impl.AccListServiceImplV1;
import com.yopheu.bank.service.impl.AccServiceImplV1;
import com.yopheu.bank.service.impl.BuyerServiceImplV1;
import com.yopheu.bank.utils.Line;

public class BankService {
	protected final Scanner scan;
	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	protected final AccService accService;
	protected final AccListService accListService;
	
	public BankService() {
		buyerService = new BuyerServiceImplV1();
		accService = new AccServiceImplV1();
		accListService = new AccListServiceImplV1();
		scan = new Scanner(System.in);
	}
	
	public void printBuyerList() {
		buyerList = buyerService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t생년월일\t직업\t");
		System.out.println("-".repeat(100));
		for(BuyerDto buyerDto : buyerList) {
			System.out.printf("%s\t", buyerDto.buId);
			System.out.printf("%s\t", buyerDto.buName);
			System.out.printf("%s\t", buyerDto.buTel);
			System.out.printf("%s\t", buyerDto.buAddr);
			System.out.printf("%s\t", buyerDto.buBirth);
			System.out.printf("%s\t", buyerDto.buJob);
			System.out.println();
		}
		System.out.println("=".repeat(100));
		
		
	}
	
	public void findByBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("조회하고자 하는 고객ID 를 입력하세요");
		System.out.print("ID >> ");
		String strId = scan.nextLine();
		
		BuyerDto buyerDto = buyerService.findById(strId);
		if(buyerDto == null) {
			System.out.println("조회한 고객ID 는 없는 데이터 입니다.");
		}else {
			System.out.println(buyerDto.toString());
		}
	}
	
	public void insertBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("고객정보 등록");
		System.out.println("=".repeat(100));
		
		System.out.print("고객 ID >> ");
		String strBuId = scan.nextLine();

		System.out.print("고객명 >> ");
		String strBuName = scan.nextLine();
		
		System.out.print("전화번호 >> ");
		String strBuTel = scan.nextLine();
		
		BuyerDto buyerDto = new BuyerDto();
		buyerDto.buId = strBuId;
		buyerDto.buName = strBuName;
		buyerDto.buTel = strBuTel;
		
		buyerService.insert(buyerDto);
		
	}
	
	public void delete() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객ID 를 입력하세요");
		System.out.print("고객ID >> ");
		String strBuId = scan.nextLine();
		
		BuyerDto buyerDto = buyerService.findById(strBuId);
		if(buyerDto == null) {
			System.out.printf("%s 고객ID 는 없는 정보입니다.", strBuId);
		} else {
			System.out.println(buyerDto.toString());
			System.out.println("고객정보를 정말 삭제할까요??? YES/NO");
			String yesNo = scan.nextLine();
			if(yesNo.equalsIgnoreCase("YES")) {
				int result = buyerService.delete(strBuId);
				if(result > 0) {
					System.out.println("고객정보 삭제 완료~~");
				}else {
					System.out.println("고객정보 삭제 실패!!!");
				}
			} else {
				System.out.println("삭제 취소!!");
			}
		}
	}
	
	public void update() {
		while(true) {
			System.out.println("수정할 고객 id 를 입력하세요");
			String strBuId = scan.nextLine();
			
			BuyerDto buyerDto = buyerService.findById(strBuId);
			if(buyerDto == null) {
				System.out.printf("%s, 고객 정보가 없습니다", strBuId);
				continue;
			}
			System.out.println(buyerDto.toString());
			System.out.printf("고객ID : %s", buyerDto.buId);
			
			System.out.printf("고객이름(%s)", buyerDto.buName);
			String strBuName = scan.nextLine();
			if(!strBuName.equals("")) buyerDto.buName = strBuName;
			
			System.out.printf("전화번호(%s)", buyerDto.buTel);
			String strBuTel = scan.nextLine();
			if(!strBuName.equals("")) buyerDto.buTel = strBuTel;
			
			int result = buyerService.update(buyerDto);
			if(result > 0) System.out.println("변경 성공");
			System.out.println("변경 실패");
			
			break;
		}
	}
	
	public void findUserInfo() {
		
		// 고객 List 출력.
		this.printBuyerList();
		// 고객ID 입력
		System.out.println(Line.dLine(100));
		System.out.println("조회할 고객ID를 입력하세요");
		System.out.print("ID >> ");
		String strBuId = scan.nextLine();
		
		BuyerDto buyerDto = buyerService.findById(strBuId);
		
		
		if(buyerDto == null) {
			System.out.println("조회한 고객ID 는 없는 데이터 입니다.");
			return;
		}else {
			System.out.println(Line.sLine(100));
			System.out.printf("고객ID : %s\n", buyerDto.buId);
			System.out.printf("이름 : %s\n", buyerDto.buName);
			System.out.printf("전화번호 : %s\n", buyerDto.buTel);
			System.out.printf("주소 : %s\n", buyerDto.buAddr);
			System.out.println(Line.sLine(100));

			
			List<AccDto> accDtoList = accService.findByBuId(strBuId);
			if(accDtoList.isEmpty()) {
				System.out.println("고객의 계좌정보가 없습니다.");
				return;
			}else {
				// 고객정보와 계좌 리스트를 출력
				System.out.println("=".repeat(100));
				System.out.println("계좌번호\t구분\t잔액\t");
				System.out.println("-".repeat(100));
				for(AccDto dto : accDtoList) {
					System.out.printf("%s\t", dto.acNum);
					int intDiv = 0;
					try {
						intDiv = Integer.valueOf(dto.acDiv);
						System.out.printf("%s\t", DBContract.ACC_DIV[intDiv-1]);
					}catch (Exception e) {
						System.out.printf("%s\t", "종류불명");
					}
					System.out.printf("%d\t", dto.acBalance);
					System.out.println();
				}
				System.out.println("=".repeat(100));
				System.out.println("넘어가려면 엔터키를 누르세요.");
				scan.nextLine();
			}
		}
	}
	
	protected int printBuyerDto(BuyerDto buyerDto) {
		if(buyerDto == null) {
			System.out.println("입력한 고객ID 는 없는 데이터 입니다.");
			return -1;
		}else {
			System.out.println(Line.sLine(100));
			System.out.printf("고객ID : %s\n", buyerDto.buId);
			System.out.printf("이름 : %s\n", buyerDto.buName);
			System.out.printf("전화번호 : %s\n", buyerDto.buTel);
			System.out.printf("주소 : %s\n", buyerDto.buAddr);
			System.out.println(Line.sLine(100));
			return 1;
		}
	}
	
	protected void printAccList(List<AccDto> accDtoList) {
		if(accDtoList.isEmpty()) {
			System.out.println("고객의 계좌정보가 없습니다.");
			return;
		}else {
			// 고객정보와 계좌 리스트를 출력
			System.out.println("=".repeat(100));
			System.out.println("계좌번호\t구분\t잔액\t");
			System.out.println("-".repeat(100));
			for(AccDto dto : accDtoList) {
				System.out.printf("%s\t", dto.acNum);
				int intDiv = 0;
				try {
					intDiv = Integer.valueOf(dto.acDiv);
					System.out.printf("%s\t", DBContract.ACC_DIV[intDiv-1]);
				}catch (Exception e) {
					System.out.printf("%s\t", "종류불명");
				}
				System.out.printf("%d\t", dto.acBalance);
				System.out.println();
			}
			System.out.println("=".repeat(100));
		}
	}
	
	public void insertAccList2() {
		// 전체 고객 List 출력
		this.printBuyerList();
		// 고객 ID를 입력
		String strBuId;
		BuyerDto buyerDto;
		while(true) {
			System.out.println(Line.dLine(100));
			System.out.println("입출금할 고객ID를 입력하세요");
			System.out.print("ID >> ");
			strBuId = scan.nextLine();
			buyerDto = buyerService.findById(strBuId);
			;
			if(printBuyerDto(buyerDto) > -1) {
				break;
			}else {
				continue;
			}
			
		}
		
		
		// 고객이 보유한 계좌 List 출력
		List<AccDto> accDtoList = accService.findByBuId(strBuId);
		printAccList(accDtoList);
		
		// 현재 날짜와 시각을 시스템으로 부터 생성
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat today = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		
		// 날짜 type 의 데이터를 String.format type 의 문자열로 변환하기
		String todayString = today.format(date);
		String timeString = time.format(date);
		// 입력된 정보를 AccListDto 객체로 만들기
		System.out.println("계좌번호를 입력하세요.");
		String accNum = scan.nextLine();
		AccDto accDto = accService.findById(accNum);
		if(accDto == null) {
			System.out.println("없는 계좌번호입니다.");
			return;
		}else {
			String accListDiv;
			while(true) {
				System.out.printf("계좌번호 [%s] 이 확인되었습니다.\n", accDto.acNum);
				System.out.printf("잔액 : %d\n", accDto.acBalance);
				System.out.println("거래구분(1:입금, 2:출금)");
				System.out.print(" >> ");
				accListDiv = scan.nextLine();
				try {
					int intDiv = Integer.valueOf(accListDiv);
					if(!(intDiv == 1 || intDiv == 2)) {
						System.out.println("잘못입력하였습니다.");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println("잘못입력하였습니다.");
					continue;
				}
			}
			
			
			int input = 0;
			int output = 0;
			int intAccValue = 0;
			while(true) {
				if(accListDiv.equals("1")) {
					System.out.print("입금 >> ");
					
				}else if(accListDiv.equals("2")) {
					System.out.print("출금 >> ");
				}
				String accValue = scan.nextLine();
				try {
					intAccValue = Integer.valueOf(accValue);
					if(accListDiv.equals("2") && accDto.acBalance < intAccValue) {
						System.out.printf("계좌 잔액이 부족합니다. (잔액 : %d)\n", accDto.acBalance);
						continue;
					}else {
						break;
					}
				} catch (Exception e) {
					System.out.println("다시 입력해주세요.");
					continue;
				}
			}
			
			int accInBalance = 0; 
			if(accListDiv.equals("1")) {
				input = intAccValue;
				accInBalance = input;
			}else if(accListDiv.equals("2")) {
				output = intAccValue;
				accInBalance = -output;
			}
			
			accDto.acBalance += accInBalance;
			AccListDto accListDto = new AccListDto();
			accListDto.acNum = accNum;
			accListDto.aioDate = todayString;
			accListDto.aioTime = timeString;
			accListDto.aioDiv = accListDiv;
			accListDto.aioInput = input;
			accListDto.aioOutput = output;
			
			
			// tbl_acc의 balance 입출금액 합산
			// 출금 금액이 balance보다 클 경우 출금실패
			
			int acResult = accService.update(accDto);
			int acListResult = accListService.insert(accListDto);
			
			
			if(acResult < 1) {
				System.out.println("err : 계좌 잔액 계산이 실패하였습니다.");
			}else {
				System.out.println("계좌 잔액 계산이 입력이 성공하였습니다.");
			}
			if(acListResult < 1) {
				System.out.println("err : 입출금 기록이 실패하였습니다.");
			}else {
				System.out.println("입출금 기록이 성공하였습니다.");
			}
			
			List<AccListDto> accListDtoList = accListService.findByAcNum(accNum);
			
		}
		
		// AccListServiceImpl.insert() 를 사용하여 저장
	}
	
	public void makeAccount() {
		/*
		 * 계좌번호 만들기 : 날짜 + 일련번호
		 * 1. 오늘날짜의 문자열 만들기
		 * 2. 계좌리스트에 오늘날짜에 해당하는 값이 있는지 검사
		 * 		있으면 일련번호 추출하여 + 1 하고
		 * 		없으면 1로 설정
		 */
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat today = new SimpleDateFormat("YYYYMMdd");
		
		// 오늘날짜의 문자열을 만들기(20230524)
		String todayString = today.format(date);
		
//		List<AccDto> accList = accService.selectAll();
//		int maxNum = 0;
//		for(AccDto accDto : accList) {
//			String tempDate = accDto.acNum.substring(0,todayString.length());
//			// 날짜와 같은 데이터가 있으면 일련번호 추출
//			if(tempDate.equals(todayString)) {
//				String strNum = accDto.acNum.substring(todayString.length());
//				int intNum = Integer.valueOf(strNum);
//				if(intNum > maxNum) maxNum = intNum;
//			}
//		}
//		maxNum ++;
		
		int maxNum = Integer.valueOf(accService.maxAcNum(todayString)) + 1;
		String acNum = String.format("%s%02d", todayString, maxNum);
		
//		System.out.println("계좌번호 : " + acNum);
		
		// 고객 List 출력.
		this.printBuyerList();
		// 키보드를 통해 고객ID를 조회
		System.out.println(Line.dLine(100));
		System.out.println("계좌를 개설할 고객ID를 입력하세요");
		System.out.print("ID >> ");
		String strBuId = scan.nextLine();
		BuyerDto buyerDto = buyerService.findById(strBuId);
		if(buyerDto == null) {
			System.out.println("입력한 고객ID 는 없는 데이터 입니다.");
			return;
		}else {
			System.out.println(Line.sLine(100));
			System.out.printf("고객ID : %s\n", buyerDto.buId);
			System.out.printf("이름 : %s\n", buyerDto.buName);
			System.out.printf("전화번호 : %s\n", buyerDto.buTel);
			System.out.printf("주소 : %s\n", buyerDto.buAddr);
			System.out.println(Line.sLine(100));
		}
		
		AccDto accDto = new AccDto();
		
		System.out.printf("계좌번호(%s)\n", acNum);
		accDto.acNum = acNum;
		
		
		System.out.println("1. 입출금계좌 2. 적금계좌 3. 대출계좌");
		System.out.print("계좌구분 (1 ~ 3) >> ");
		String strAcDiv = scan.nextLine();
		try {
			int intAcDiv = Integer.valueOf(strAcDiv);
			if(intAcDiv < 1 || intAcDiv > 3) {
				System.out.println("구분1로 강제 지정됩니다.");
				accDto.acDiv = "1";
			}else {
				accDto.acDiv = intAcDiv + "";
			}
		} catch (Exception e) {
			accDto.acDiv = "1";
		}
		
		accDto.acBuid = buyerDto.buId;
		accDto.acBalance = 10000;

		int result = accService.insert(accDto);
		if(result >= 0) {
			System.out.println("계좌 등록 완료되었습니다.");
			List<AccDto> accDtoList = accService.findByBuId(strBuId);
			if(accDtoList.isEmpty()) {
				System.out.println("고객의 계좌정보가 없습니다.");
				return;
			}else {
				// 고객정보와 계좌 리스트를 출력
				System.out.println("=".repeat(100));
				System.out.println("계좌번호\t구분\t잔액\t");
				System.out.println("-".repeat(100));
				for(AccDto dto : accDtoList) {
					System.out.printf("%s\t", dto.acNum);
					int intDiv = 0;
					try {
						intDiv = Integer.valueOf(dto.acDiv);
						System.out.printf("%s\t", DBContract.ACC_DIV[intDiv-1]);
					}catch (Exception e) {
						System.out.printf("%s\t", "종류불명");
					}
					System.out.printf("%d\t", dto.acBalance);
					System.out.println();
				}
				System.out.println("=".repeat(100));
			}
		}
	}
	
	protected void printAccListDtoList(List<AccListDto> accListDtoList) {
		
	}
	
	public void insertAccList() {
		// 고객 정보 확인
		printBuyerList();
		findUserInfo();
		
		while(true) {
			System.out.println(Line.sLine(100));
			System.out.println("입출금 등록");
			System.out.println(Line.sLine(100));
			System.out.print("계좌번호 >> ");
			String acNum = scan.nextLine();
			
			// 계좌번호를 사용하여 tbl_acc 테이블에서 데이터 조회
			// accDto 에는 acNum 계좌번호에 해당하는 데이터가 모두 담긴 상태
			AccDto accDto = accService.findById(acNum);
			if(accDto == null) {
				System.out.printf("계좌번호를 확인하세요( %s )",acNum);
				continue;
			}
			
			System.out.print("거래구분(1:입금, 2:출금, -1:종료) >> ");
			String aioDiv = scan.nextLine();
			int intDiv = 0;
			try {
				intDiv = Integer.valueOf(aioDiv);
			} catch (Exception e) {
				System.out.printf("선택이 잘못되었습니다.( %s )", aioDiv);
				continue;
			}
			if(intDiv == -1) {
				System.out.println("입출금 업무 중단");
				break;
			}
			if(intDiv != 1 && intDiv != 2) {
				System.out.println("1:입금, 2:출금 중에서 선택하세요");
				continue;
			}

			String[] divs = {"입금", "출금"};
			int intAmt = 0;
			while(true) {
				String prompt = divs[intDiv - 1];
				System.out.printf("%s (QUIT:종료) >> ", prompt);
				String amount = scan.nextLine();
				if(amount.equals("QUIT")) {
					intAmt = -1;
					break;
				}
				try {
					intAmt = Integer.valueOf(amount);
				} catch (Exception e) {
					System.out.printf("%s 금액은 정수(숫자)로 입력해주세요.\n", prompt);
					continue;
				}
				if(aioDiv.equals("2")) {
					int balance = accDto.acBalance;
					if(balance < intAmt) {
						System.out.printf("잔액(%d) 가 부족하여 출금할수 없음\n", balance);
						continue;
					}
				}
				
				break;
			} // 입출금입력 while end
			if(intAmt < 0) break;
			
			AccListDto ioDto = new AccListDto();
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			
			ioDto.aioDate = dateFormat.format(date);
			ioDto.aioTime = timeFormat.format(date);
			
			ioDto.aioDiv = aioDiv;
			ioDto.acNum = acNum;
			
			if(aioDiv.equals("1")) {
				ioDto.aioInput = intAmt;
			}else if(aioDiv.equals("2")) {
				ioDto.aioOutput = intAmt;
				intAmt *= -1;
			}
			
			accListService.insert(ioDto);
			
			accDto.acBalance = accDto.acBalance + intAmt;
			accService.update(accDto);
		}
	}
	
	
}
