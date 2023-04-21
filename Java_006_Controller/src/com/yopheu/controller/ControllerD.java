package com.yopheu.controller;

public class ControllerD {
	public static int prime() {
		int rndNum = (int)(Math.random() * 50) + 51;
		for(int i = 2; i < rndNum; i++) {
			if(rndNum % i == 0) {
				return 0;
			}
		}
		return rndNum;
	}
	public static void main(String[] args) {
		int sumPrimes = 0;
		int cntPrime = 0;
		for(int i = 0; i < 100; i++) {
			int result = prime();
			if(result != 0) {
				sumPrimes += result;
				cntPrime ++;
			}			
		} // end for
		System.out.println("100개의 숫자 생성 후 소수에 대하여.");
		System.out.println("Count : " + cntPrime + "\tSum : " + sumPrimes);
	}
}
