package com.yopheu.scanner.service;

import java.util.Scanner;

public class PrimeServiceV1 {
	private Scanner scan = new Scanner(System.in);
	
	public int getNum() {
		
		String sNum1 = "";
		int num1 = 0;
				
		// insert number
		while (true) {
			try {
				System.out.println("3이상 양의 정수를 입력하세요");
				System.out.print("정수(QUIT : 종료) >> ");
				sNum1 = scan.nextLine();
				if(sNum1.equalsIgnoreCase("QUIT")) {
					return -1;
				}
				num1 = Integer.parseInt(sNum1);
				
				if(num1 >= 3) {
					break;
				}
			} catch (Exception e) {
				System.out.println("system: (정수) 숫자만 입력해보아요.");
			}
		}
		return num1;
	}
	
	public boolean primeYesNo(int num1) {
		// prime check
		boolean yesPrime = true;
		for (int i = 2; i < num1; i++) {
			if (num1 % i == 0) {
				yesPrime = false;
				break;
			}
		}
		return yesPrime;
	}
}
