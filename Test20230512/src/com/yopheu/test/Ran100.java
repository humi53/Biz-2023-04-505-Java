package com.yopheu.test;

public class Ran100 {
	public static void main(String[] args) {
		int rndNum;
		
		int i;
		for(i = 0; i < 100; i++) {
			rndNum = (int)(Math.random() * 100) + 1;
//			rndNum = (int)(Math.random() * 150) + 1;
			if(rndNum < 1 || rndNum > 100) {
				System.out.println("테스트 횟수 : " + (i+1));
				System.out.println("100번 테스트를 수행하려고 하였으나 " + (i+1) + "번째에서 테스트에 실패함");
				break;
			}
		}		
		if(i >= 100) {
			System.out.println("테스트 횟수 : " + i);
			System.out.println(i +" 번 테스트 수행결과 1 ~ 100까지 범위의 랜덤수를 만들어 내고 있음");
		}
	}
}
