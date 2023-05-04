package com.yopheu.classes.practiceC.anonymousclass.anonymousclass2;

interface C{
	public abstract void bcd();
}

class A{
	C c = new C() {
		public void bcd() {
			System.out.println("익명 이너 클래스");
		}
	};
	void abc() {
		c.bcd();
	}
}


public class AnonymousClass2 {
	public static void main(String[] args) {
		A a = new A();
		a.abc();
	}
}
