package com.yopheu.controller;

public class ControllerD {
	public static void main(String[] args) {
		
		for(int j = 0; j < 100; j++) {
			int rndNum = (int)(Math.random() * 50) + 51;
			
			int i=0;
			for(i = 2; i < rndNum; i++) {
				if(rndNum % i == 0) {
					break;
				}
			}
			
			if(rndNum <= i) {
				System.out.println(rndNum + "는 소수입니다.");
			}
		}
	}
}
