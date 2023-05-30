package com.callor.shop.exec;

import java.util.Scanner;

import com.callor.shop.service.BuyerService;
import com.callor.shop.service.IOListService;
import com.callor.shop.service.ProductService;
import com.callor.shop.service.impl.BuyerServiceImpl;
import com.callor.shop.service.impl.IOListServiceImpl;
import com.callor.shop.service.impl.ProductSerivceImpl;

public class ShopingCartExec {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		BuyerService buyerService = new BuyerServiceImpl();
		ProductService productService = new ProductSerivceImpl();
		IOListService ioListService = new IOListServiceImpl();
		
		while(true) {
			printMenu();
			int intChoose = -1;
			System.out.print("선택 >> ");
			String choose = scan.nextLine();
			if(choose.equalsIgnoreCase("QUIT")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			try {
				intChoose = Integer.valueOf(choose);
				if(intChoose < 1 || intChoose > 10) {
					System.out.println("업무 선택은 1 ~ 10 까지 중에 선택하세요.");
					continue;
				}
			} catch (Exception e) {
				System.out.printf("업무 선택은 QUIT(끝내기), 1 ~ 10 정수만 입력할 수 있습니다( %s )\n", choose);
				continue;
			}
			
			if(intChoose == 1) {
				// 1. 상품리스트
				productService.printProductList();
			}else if(intChoose == 2) {
				// 2. 상품등록 및 수정
				productService.insertProduct();
			}else if(intChoose == 3) {
				// 3. 고객리스트
				buyerService.printBuyerList();
			}else if(intChoose == 4) {
				// 4. 고객등록 및 수정
				buyerService.insertBuyer();
			}else if(intChoose == 5) {
				// 5. 장바구니 상품 담기
				ioListService.insert();
			}else if(intChoose == 6) {
				// 6. 구매자별 장바구니 리스트 보기
				ioListService.printFindBuId();
			}else if(intChoose == 7) {
				// 7. 장바구니 전체 리스트 보기
				ioListService.printIOListAll();
			}else if(intChoose == 8) {
				// 8. 기간별 거래리스트
				ioListService.printFindDate();
			}else if(intChoose == 9) {
				// 9. 상품별 거래리스트
				ioListService.printFindProduct();
			}else if(intChoose == 10) {
				// 10. 고객+거래기간별 거래 리스트
				ioListService.printFindDateProduct();
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("=".repeat(120));
		System.out.println(" \t\t빛나라 쇼핑몰 2023 ");
		System.out.println("=".repeat(120));
		System.out.println(" 상품관리");
		System.out.println("-".repeat(60));
		System.out.println("\t1. 상품리스트");
		System.out.println("\t2. 상품등록 및 수정");
		System.out.println("-".repeat(60));
		System.out.println(" 고객관리");
		System.out.println("\t3. 고객리스트");
		System.out.println("\t4. 고객등록 및 수정");
		System.out.println("-".repeat(60));
		System.out.println(" 상품판매");
		System.out.println("\t5. 장바구니 상품 담기");
		System.out.println("\t6. 구매자별 장바구니 리스트 보기");
		System.out.println("\t7. 장바구니 전체 리스트 보기");
		System.out.println("\t8. 기간별 거래리스트 보기");
		System.out.println("\t9. 상품별 거래리스트 보기");
		System.out.println("\t10. 고객+거래기간별 거래리스트 보기");
		System.out.println("-".repeat(60));
		System.out.println(" QUIT. 끝내기");
		System.out.println("=".repeat(120));
	}
}
