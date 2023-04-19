package com.coller.controller;

public class ControllerA {
	public static void main(String[] args) {
		int intNum = 0;

		for(int i = 0; i < 100; i++) {
			intNum = ((int)(Math.random() * 50)) + 51;
			System.out.printf("%3d",intNum);
			if(intNum>=51 && intNum <= 100) {
				System.out.println(" ok");
			}else {
				System.out.println("\t over");
			}
		}
		
	}
}
