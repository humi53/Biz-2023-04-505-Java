package com.yopheu.classes.exec;

import com.yopheu.classes.module.ServiceA;

public class ExecA {
	public static void main(String[] args) {
		int kor = (int)(Math.random() * 50) + 51;
		int eng = (int)(Math.random() * 50) + 51;
		int math = (int)(Math.random() * 50) + 51;
		int his = (int)(Math.random() * 50) + 51;
		int mus = (int)(Math.random() * 50) + 51;
		int art = (int)(Math.random() * 50) + 51;
		int phy = (int)(Math.random() * 50) + 51;
		
		ServiceA serviceA = new ServiceA();
		serviceA.score(kor, eng, math, his, mus, art, phy);
		
	}
}
