package com.yopheu.classes.exec;

public class ExecJ {

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
		
		int firstIndex = -1;
		int lastIndex = -1;
		for(int i = 0; i < nums.length; i++) {
			if(prime(nums[i]) != 0) {
				lastIndex = i;
				if(firstIndex == -1) {
					firstIndex = i;
				}
			}
		}
		
		if(firstIndex > -1) {
			System.out.printf("First Index : %d, Value : %d\n", firstIndex, nums[firstIndex]);
			System.out.printf("Last Index : %d, Value : %d", lastIndex, nums[lastIndex]);
		} else {
			System.out.println("소수가 하나도 없습니다.");
		}
	}
}
