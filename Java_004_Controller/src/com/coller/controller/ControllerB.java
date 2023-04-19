package com.coller.controller;

public class ControllerB {
	public static void main(String[] args) {
		
		for(int i = 0; i < 100; i++) {
			int intNum = ((int)(Math.random() * 50)) + 51;
			
//			System.out.print(intNum);
//			if(intNum % 2 == 0) {
//				System.out.println(" Even");
//			}else {
////				System.out.println("\tOdd ");
//				System.out.println("\t Not Even");
//			}
			
			System.out.print(intNum);
			if(intNum % 2 == 0) {
				System.out.println(" Even");
			} else if(intNum % 2 == 1){
				System.out.println("\t Odd");
			}
		}
		
	}
}
