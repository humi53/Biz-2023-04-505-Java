package com.yopheu.classes.exec;

import com.yopheu.classes.module.MyClassC;

public class ExecH {
	/*
	 * 51 ~ 100까지 중의 임의의 랜덤수를 생성하여
	 * MyClassC 의 prime() method 에게 전달하고
	 * 소수인지 아닌지 결과를 Console 에 출력
	 */
	public static void main(String[] args) {
		// MyClassC type 의 myC 객체 생성(선언과 초기화)
		// myC 는 MyClassC 의 대리자 역할을 수행 할 것이다.
		MyClassC myC = new MyClassC();
		int rndNum = (int)(Math.random() * 50) + 51;
		
		// myC 대리자를 통하여 prime(int) method 를 호출하고
		// return 된 값이 0보다 크면 "소수", 아니면 "소수" 아님
		if(myC.prime(rndNum) > 0) {
			System.out.println(rndNum + " 소수 입니다.");
		} else {
			System.err.println(rndNum + " 소수 아닙니다.");
		}
		
	}
}
