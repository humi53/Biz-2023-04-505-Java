package com.yopheu.classes.practiceC.staticinnerclass.createobjectandaccessmember;

class A {
	int a = 3;
	static int b = 4;
	void method1() {
		System.out.println("instance method");
	}
	static void method2() {
		System.out.println("static method");
	}
	
	// 정적 이너 클래스
	static class B{
		void bcd() {
			// 필드 사용
			// System.out.println(a);
			// method1();
			
			//정적 이너 클래스는 아우터 클래스의 정적 맴버만 사용 가능
			System.out.println(b);
			method2();
		}
		static void ef() {
			System.out.println("정적 이너클래스의 정적 메소드 실행");
		}
	}
}

public class CreateObjectAndAccessMember {
	public static void main(String[] args) {
		// 정적 이너 클래스의 객체 생성
		// A는 정적 클래스가 아님.
		A.B b = new A.B();
		b.bcd();	// 일반메소드 호출
		
		A.B.ef();	// 정적메소드 호출
	}
}
