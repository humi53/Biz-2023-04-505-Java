package com.yopheu.classes.module;

public class MyClassA {

	/*
	 * MyClassA 클래스의 생성자 method
	 * 		public 키워드만을 가진 method
	 * 		클래스와 이름이 같은 method
	 * 
	 */
	public MyClassA() {
		
	}
	
	// static 키워드가 없는 method()
	/*
	 * 정수형 매개변수2개를 이용하여 값을 전달받아
	 * 값을 더하여서 int형 값을 리턴하는 메서드
	 * 
	 * 2개의 매개변수를 통하여 정수 2개를 전달받고
	 * 전달받은 정수를 덧셈하여 return 하는 add() method
	 */
	public int add(int num1, int num2) {
		return num1 + num2;
	}
}
