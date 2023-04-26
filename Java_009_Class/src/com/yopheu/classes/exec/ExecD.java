package com.yopheu.classes.exec;

public class ExecD {
	public static void main(String[] args) {
		int[] nums = new int[10];
		
		for(int i = 0; i < 10; i++) {
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		for(int i = 0; i < 10; i++) {
			if(nums[i] % 5 == 0) {
				System.out.println(nums[i] + "\tis multiple of 5");
			}
		}
	}
}
