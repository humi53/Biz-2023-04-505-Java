package com.yopheu.classes.exec;

import com.yopheu.classes.module.MyClassC;

public class ExecI {
	public static void main(String[] args) {
		MyClassC myC = new MyClassC();
		
		int primeCnt = 0;
		for(int i = 0; i < 100; i++) {
			int rndNum = (int)(Math.random() * 50) + 51;
			if(myC.prime(rndNum) > 0) {
				primeCnt++;
			}
		}
		System.out.println("100개의 랜덤 숫자중에 \nprimeCnt : " + primeCnt);
	}
}
