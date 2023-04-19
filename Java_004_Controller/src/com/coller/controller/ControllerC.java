package com.coller.controller;

public class ControllerC {
	public static void main(String[] args) {
		
		/*
		 * 100 개의 랜덤수를 생성하기
		 * 생성된 랜덤수가 3의 배수인가 판별
		 * 아니면 2의 배수인가 판별
		 */
		int intRan = 0;
		for(int i = 0; i < 100; i++) {
			intRan = ((int)(Math.random() * 50)) + 51;
			if(intRan % 3 == 0) {
				System.out.print(intRan);
				System.out.println(" *3");
			}else if(intRan % 2 == 0) {
				System.out.print(intRan);
				System.out.println("\t *2");
			}
		}
	}
	
}
