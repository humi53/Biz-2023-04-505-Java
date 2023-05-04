package com.yopheu.scanner.exec;

import com.yopheu.scanner.service.PrimeServiceV1;

public class ScannerC {
	public static void main(String[] args) {
		PrimeServiceV1 serviceV1 = new PrimeServiceV1();
		int num1 = -1;
		while(true) {
			num1 = serviceV1.getNum();
			if(num1 < 0) {
				System.out.println("GAME OVER");
				return;	// 프로젝트 코드 전체를 중단하라
			}
			
			// result print
			if(serviceV1.primeYesNo(num1)) {
				System.out.println(num1 + " is Yes! Prime");
			}else {
				System.err.println(num1 + " is not... prime");
			}
		}
		
		
	}
}
