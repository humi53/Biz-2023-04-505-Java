package com.yopheu.classes.practiceA;

public class ClassB extends ClassA {
	static int n = 2200022;
	int m = 222222;
	@Override
	void print() {
		System.out.println("B 클래스.");
	}
	
	static void sPrint() {
		System.out.println("B 정적메서드");
	}
}
