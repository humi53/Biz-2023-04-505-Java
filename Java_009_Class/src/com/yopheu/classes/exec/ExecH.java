package com.yopheu.classes.exec;

public class ExecH {
	public static void main(String[] args) {
		int[] nums = new int[50];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		int count = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 3 == 0) {
				count ++;
				sum += nums[i];
			}
		}
		System.out.println("count of 3 : " + count);
		System.out.println("sum of 3 : " + sum);
	}
}
