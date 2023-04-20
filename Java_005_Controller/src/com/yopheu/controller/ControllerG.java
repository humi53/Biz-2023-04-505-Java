package com.yopheu.controller;

public class ControllerG {
	
	/*
	 * prime() method 의 코드를 수정하여
	 * 생성된 랜덤수가 소수인지 아닌지 판별하는 코드로 변경
	 * 
	 * void type 의 prime() method 를
	 * boolean type 의 prime() method 로 변경
	 * 
	 * method 를 선언할때 void type 이외의 type 으로 선언하면
	 * method {} 내에서 반드시 return 명령문이 있어야 한다.
	 * 
	 * prime() method {} 내에서 선언했던 rndNum 변수를
	 * 매개변수(parameter) 로 변경하기
	 * 매개변수는 스스로 초기화할수 없다
	 * 누군가 prime() method 를 호출하면서
	 * 값을 전달해 주어야만 그 값으로 초기화 할 수 있다
	 * prime(int rndNum = 0) 과 같은 코드 사용불가.
	 * 
	 * main() 에서 prime(55) 와 같은 코드가 실행될때
	 * 매개변수 값이 초기화 된다.
	 * 
	 */
	public static boolean prime(int rndNum) {		
		int i=0;
		for(i = 2; i < rndNum; i++) {
			if(rndNum % i == 0) {
				break;
			}
		}
		
		boolean yesPrime = rndNum <= i;
		return yesPrime;
	}
	
	public static void main(String[] args) {
		
		for(int j = 0; j < 100; j++) {
			// main 에서 랜덤수를 만들고
			int mainRndNum = (int) (Math.random() * 50) + 51;
			
			// prime() method 에게 "전달해 주기"
			if(prime(mainRndNum)) {
				System.out.println(mainRndNum + " 소수");
			}else {
				System.err.println(mainRndNum + " 소수아님");
			}
		}
	}
}
