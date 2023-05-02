package com.yopheu.classes;

import java.util.Scanner;

public class ClassE {
	public static void main(String[] args) {
		/*
		 * leak(메모리, 자원 누수)
		 */
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;

		int sum = 0;
		int sub = 0;
		int dev = 0;
		int mul = 0;
		int rem = 0;
		
		for(int i = 0; i < 3; i++) {
			System.out.print("num1 >> ");
			num1 = scan.nextInt();
			System.out.print("num2 >> ");
			num2 = scan.nextInt();
			
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
		
		/*
		 * scan 객체는 하드웨어인 키보드와 연결된 상태의 여러 정보를 
		 * 가지고 있는 상태이다
		 * 하드웨어 키보드는 운영체제나 여러곳에서 여러 정보를 필요로 하고
		 * 그 정보를 기억장소 어딘가에 보관하고 있는 상태이다
		 * 이 상태로 프로젝트가 종료되면, 기억장소에 저장된 정보가
		 * 소멸되는데 상당한 시간이 소요될 것이다
		 * 그래서 사용이 끝난 키보드는 메모리에서 제거하는 절차를
		 * 강제로 실행한다
		 * 
		 * 이것이 자원의 누수(leak)을 방지하는 목적이 있다.
		 * 
		 * 
		 */
		scan.close();
		
		
	}
}
