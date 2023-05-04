package com.yopheu.scanner.exec;

import java.util.Scanner;

public class ScannerA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String sNum1 = "";
		int num1 = 0;
		boolean yesPrime = true;
		
		// insert number
		while (true) {
			try {
				System.out.print("숫자입력 >> ");
				sNum1 = scan.nextLine();
				num1 = Integer.parseInt(sNum1);
				break;
			} catch (Exception e) {
				System.out.println("system: (정수) 숫자만 입력해보아요.");
			}
		}
		
		// prime check
		for(int i = 2; i < num1; i++) {
			if(num1 % i == 0) {
				yesPrime = false;
				break;
			}
		}
		
		// result print
		if(yesPrime) {
			System.out.println(num1 + " is Yes! Prime");
		}else {
			System.err.println(num1 + " is not... prime");
		}
		
		scan.close();
	}
}
