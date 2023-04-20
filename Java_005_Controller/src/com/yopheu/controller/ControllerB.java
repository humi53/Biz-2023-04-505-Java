package com.yopheu.controller;

public class ControllerB {
	public static void main(String[] args) {
		int rndNum = (int)(Math.random() * 50) + 51;
		int primeCount = 0;
		
		// i 을 2 ~ 자신 - 1 까지 연소고딘 정수를
		// 만들어 내는 코드
		for(int i = 2; i < rndNum; i++) {
			if(rndNum % i == 0) {
				primeCount++;
				break;
			}
		}
		
		if(primeCount > 0) {
			System.out.printf("%d는 소수가 아닙니다.\n", rndNum);
		}else {
			System.out.printf("%d는 소수입니다.\n", rndNum);
		}
		
		if(primeCount == 0) {
			System.out.printf("%d는 소수입니다.\n", rndNum);
		}else {
			System.out.printf("%d는 소수가 아닙니다.\n", rndNum);
		}
		
	}
}
