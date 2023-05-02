package com.yopheu.classes;

import java.util.Scanner;

public class ClassH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		String str1 = "";
		String str2 = "";
		
		int sum = 0;
		int sub = 0;
		int dev = 0;
		int mul = 0;
		int rem = 0;
		
		
		System.out.println("두 개의 정수를 입력하세요.");
		System.out.println("e를 입력하면 종료합니다.");
		while(true) {
			
			
			System.out.print("정수 1 >> ");
			str1 = scan.nextLine();
			if(str1.equals("e")) {
				break;
			}
			num1 = Integer.parseInt(str1);
			
			System.out.print("정수 2 >> ");
			str2 = scan.nextLine();
			if(str2.equals("e")) {
				break;
			}
			num2 = Integer.parseInt(str2);
			
			sum = num1 + num2;
			sub = num1 - num2;
			dev = num1 / num2;
			mul = num1 * num2;
			rem = num1 % num2;
			
			System.out.printf("%d + %d = %d\n", num1, num2, sum);
			System.out.printf("%d - %d = %d\n", num1, num2, sub);
			System.out.printf("%d / %d = %d\n", num1, num2, dev);
			System.out.printf("%d * %d = %d\n", num1, num2, mul);
			System.out.printf("%d %% %d = %d\n", num1, num2, rem);
		}
		System.out.println("GAME OVER");
	}
}
