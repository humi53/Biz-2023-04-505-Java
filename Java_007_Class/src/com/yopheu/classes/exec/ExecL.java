package com.yopheu.classes.exec;

import com.yopheu.classes.module.ServiceC;

public class ExecL {
	public static void main(String[] args) {
		int ranNum = (int)(Math.random() * 10);
		ServiceC serviceC = new ServiceC();
		if(ranNum >= 2 && ranNum <= 9) {
			// num1 변수에 저장된 값을 전달하면서
			// 구구단을 출력해줘 라는 요청
			//  ==> guguDan() method 호출
			serviceC.guguDan(ranNum);
		}
	}
}
