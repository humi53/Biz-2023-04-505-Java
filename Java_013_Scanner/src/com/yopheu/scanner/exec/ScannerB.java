package com.yopheu.scanner.exec;

import java.util.Scanner;

public class ScannerB {
	
	private static int getNum() {
		Scanner scan = new Scanner(System.in);
		
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
				
//				if(num1 < 3) {
//					continue;
//				}
				
				if(num1 >= 3) {
					break;
				}
			} catch (Exception e) {
				System.out.println("system: (정수) 숫자만 입력해보아요.");
			}
		}
		
		scan.close();
		return num1;
	}
	
	public static boolean prime(int num1) {
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
	
	public static void main(String[] args) {
		int num1 = 0;
		
		num1 = getNum();
		if(num1 < 0) {
			System.out.println("GAME OVER");
			return;	// 프로젝트 코드 전체를 중단하라
		}
		
		// result print
		if(prime(num1)) {
			System.out.println(num1 + " is Yes! Prime");
		}else {
			System.err.println(num1 + " is not... prime");
		}
		
		
	}
}
