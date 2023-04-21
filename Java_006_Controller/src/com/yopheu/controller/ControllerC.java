package com.yopheu.controller;

public class ControllerC {
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
		for(int i = 0; i < 100; i++) {
			int rndNum = prime();
			if(rndNum > 0) {
				System.out.println(rndNum + " 는 소수");
			} else {
				System.err.println("소수아님");
			}
			
		}
	}
}
