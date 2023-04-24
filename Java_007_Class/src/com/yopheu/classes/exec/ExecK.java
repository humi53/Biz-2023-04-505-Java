package com.yopheu.classes.exec;

import com.yopheu.classes.module.ServiceB;

public class ExecK {
	public static void main(String[] args) {
		ServiceB serviceB = new ServiceB();
		String name = "홍길동";
		int kor = (int)(Math.random() * 50) + 51;
		int eng = (int)(Math.random() * 50) + 51;
		int math = (int)(Math.random() * 50) + 51;
		serviceB.scorePrint(name, kor, eng, math);
	}
}
