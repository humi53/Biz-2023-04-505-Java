package com.coller.controller;

public class ControllerE {
	public static void main(String[] args) {
		
		/*
		 * 51 ~ 100 랜덤수 1개를 만들고
		 * 이 수가 소수(Prime)수 가 아닌지 찾기
		 * Prime : 1과 자신 이외의 약수를 갖지 않는 수
		 * 		2 ~ (자신-1) 범위의 정수로 각가 나누었을때
		 * 		나머지가 한번도 0이 아닌수
		 * 
		 * 		나머지가 한번이라도 0이 되면 prime 이 아니다
		 */
		int intRan = 0;
		intRan = (int)(Math.random() * 50) + 51;
		// 이 for() 명령에 의해
		// index 값은 2 부터 rndNum - 1까지 연속된
		// 정수로 만들어저 for() {} 에서 사용가능하다
		for(int i = 2; i < intRan; i++) {
			if(intRan % i == 0) {
				System.out.print(intRan + " : ");
				System.out.print(i + "로 나누면 나머지가");
				System.out.print(intRan % i);
				System.out.println(" 이 수는 소수가 아님");
				// 반복문을 수행하며 연산을 실행하는 과정에서
				// 소수가 아님을 판별하면 더이상 반복문을
				// 진행할 필요가 없으므로 여기 중단
				// break : for() 반복문을 중단할때
				//		for() 반복문 밖에서는 사용할수 없음
				break;				
			}
		}
	}
}
