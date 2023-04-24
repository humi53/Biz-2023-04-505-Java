package com.yopheu.classes.exec;

import com.yopheu.classes.module.ServiceD;

public class ExecM {
	public static void main(String[] args) {
		int num1 = (int)(Math.random() * 50) + 51;
		int num2 = (int)(Math.random() * 50) + 51;
		ServiceD serviceD = new ServiceD();
		serviceD.add(num1, num2);
		
	}
}
