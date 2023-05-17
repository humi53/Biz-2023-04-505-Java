package com.yopheu.bank.exec;

import java.io.PrintWriter;

import com.yopheu.bank.service.BuyerService;
import com.yopheu.bank.service.impl.BuyerServiceImplV1;
import com.yopheu.bank.service.impl.BuyerServiceImplV1A;

public class BankExecA {
	public static void main(String[] args) {
//		BuyerService buService = new BuyerServiceImplV1A();
		BuyerService buService = new BuyerServiceImplV1();
//		buService.inputBuyer();
		
		/*
		 * printBuyerList() 에 전달할 출력방향을 화면으로 지정하여 전달
		 * PrintWriter out = new PrintWriter(System.out);
		 * 
		 * "내파일"에 저장하기
		 * OutputStream os = new FileOutputStream("내파일");
		 * PrintWriter out = new PrintWriter(os);
		 * 
		 * 파사드 패턴
		 */
//		PrintWriter out = new PrintWriter(System.out);
//		buService.printBuyerList(out);
//		out.close();
		buService.loadBuyer();
		buService.printBuyerList();
	}
}
