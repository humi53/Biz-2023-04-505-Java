package com.coller.controller;

public class ControllerE {
	public static void main(String[] args) {
		int intScore = 0;
		intScore = ((int)(Math.random() * 50)) + 51;
		
//		for(;intScore != 51;) {
//			intScore = ((int)(Math.random() * 50)) + 51;
//			System.out.println(intScore);
//		}
//		for(;intScore != 100;) {
//			intScore = ((int)(Math.random() * 50)) + 51;
//			System.out.println(intScore);
//		}
		
		for(int i = 0; i < 100; i++) {
			intScore = ((int)(Math.random() * 50)) + 51;
//			if(intScore < 51 || intScore > 100) {
			if(!(intScore >= 51 && intScore <= 100)) {	
				System.out.println(intScore);
			}
		}
		System.out.println("Test End");
		
		
		int num1 = 100;
		int num2 = 100;
		// 1. ++num1 가 먼저 처리 (선행연산자이므로) 
		// 1-1. > 비교 연산자 처리.
		// 2. || 앞부분이 맞았기 때문에 
		// 3. ++num2 부분은 무시.
		// 4. if 문이 참, 거짓인지 체크
		// 5. 참,거짓 결과에 따라 { } 내용을 실행
		// 6. if 문 빠져나가기.
		if(++num1 > 100 || ++num2 > 100) {
			System.out.println("OK");
		}
		System.out.printf("1 : %d 2 : %d\n", num1, num2);
		// 1. --num1 가 먼저 처리 (선행연산자이므로) 
		// 1-1. > 비교 연산자 처리.
		// 2. && 앞부분이 틀렸기 때문에
		// 3. --num2 부분은 무시.
		// 4. if 문이 참, 거짓인지 체크
		// 5. 참,거짓 결과에 따라 { } 내용을 실행
		// 6. if 문 빠져나가기.
		if(--num1 > 100 && --num2 > 100) {
			System.out.println("Hello");
		}
		System.out.printf("1 : %d 2 : %d\n", num1, num2);
		// num1은 증가 됬다 감소 했고,
		// 논리 연산자 특성으로 인하여 ||, && 로 인하여
		// num2는 무시되었기 때문에 증가와 감소가 되지 않고 그대로 있는다.
		
	}
}
