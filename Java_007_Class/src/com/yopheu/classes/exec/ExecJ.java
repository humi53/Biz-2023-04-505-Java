package com.yopheu.classes.exec;

import com.yopheu.classes.module.ServiceA;

public class ExecJ {
	public static void main(String[] args) {
		int num1 = (int)(Math.random() * 50) + 51;
		int num2 = (int)(Math.random() * 50) + 51;
		
		ServiceA serviceA = new ServiceA();
		int result = serviceA.add(num1, num2);
		System.out.println(num1 + " + " + num2);
		System.out.println(result);
	}
	
}
