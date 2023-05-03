package com.yopheu.classes.practiceA;

/*
 * 인스턴스 메서드만 오버라이딩 기능이 이용된다.
 * 
 * 인스턴스 메서드와 다른것들은 각각 다른 역할과 책임을 가지고 있기 때문이다.
 * 인스턴스 메서드는 객체의 다형성의 기능을 작동해야되기 때문이다.
 * 그러므로써 코드의 유연성과 재사용성을 높일수가 있다.
 * 
 * 인스턴트 필드	x
 * 인스턴스 메서드	o
 * 정적 필드		x
 * 정적 메서드		x
 * 
 * 그래서 필드의 getter/setter 메서드를 통해 필드를 접근하는것이
 * 안정적이고, 가독성도 높일수 있다.
 */
public class MethodOverriding_1 {
	public static void main(String[] args) {	
		ClassA aa = new ClassA();
		aa.print();
		aa.sPrint();
		System.out.println(aa.m);
		System.out.println(aa.n);
		
		ClassB bb = new ClassB();
		bb.print();
		bb.sPrint();
		System.out.println(bb.m);
		System.out.println(bb.n);
		
		ClassA ab = new ClassB();
		ab.print();
		ab.sPrint();
		System.out.println(ab.m);
		System.out.println(ab.n);
	}
}
