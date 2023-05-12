package com.yopheu.test;

import java.util.ArrayList;
import java.util.List;

public class ForPrime {
	
	public static boolean checkPrime(int num) {
		boolean isPrime = true;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for(int i = 0; i < 30; i++) {
			int rndNum = (int)(Math.random() * 50) + 51;
			numList.add(rndNum);
		}
		
		int primeCnt = 0;
		int primeSum = 0;
		for(int num : numList) {
			if(checkPrime(num)) {
				primeCnt++;
				primeSum += num;
			}
		}
		
		System.out.println("소수 개수 : " + primeCnt);
		System.out.println("소수의 합 : " + primeSum);
	}
}
