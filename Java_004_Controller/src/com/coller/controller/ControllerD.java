package com.coller.controller;

public class ControllerD {
	/*
	 * 51 ~ 100까지 범위의 랜덤수 100개 생성
	 * 생성된 랜덤수 중에 짝수가 몇개인가 판별 
	 */
	public static void main(String[] args) {
		int intRan = 0;
		int intEvCnt = 0;
		int intEvSum = 0;
		int intEvAvg = 0;
		for(int i = 0; i < 100; i++) {
			intRan = ((int)(Math.random() * 50)) + 51;
			if(intRan % 2 == 0) {
				intEvCnt++;
				// 누적 : 숫자값을 계속 쌓아서 덧셈
				intEvSum += intRan;
			}
		}
		intEvAvg = intEvSum / intEvCnt;
		System.out.println("Even \t Count : " + intEvCnt);
		System.out.printf("\t Sum : %d\t Avg : %d\n", intEvSum, intEvAvg);
	}
}
