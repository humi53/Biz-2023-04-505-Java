package com.yopheu.classes.exec;

public class ExecG {

	// 매개변수 num 변수에 전달받은 값이
	// prime 이면 num 을 아니면 0을 return 하는 method 선언
	public static int prime(int num) {
		for (int i = 2; i < num; i++) {
			if(num % i == 0) {
				return 0;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[50];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		for(int i = 0; i < nums.length; i++) {
			// prime method 가 nums 배열의 index 번째 요소(값)을
			// 너에게 보내니(전달하니) 그 값이 prime 수 인지 알려줘
			if(prime(nums[i]) != 0) {
				System.out.println(nums[i] + " is prime.");
			} else {
				System.err.println(nums[i] + " is not prime.");
			}
		}
	}
}
