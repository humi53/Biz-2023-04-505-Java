package com.yopheu.classes.arrays;

public class ArrayC {
	public static void main(String[] args) {
		int[] nums = new int[10];
		nums[0] = 33;
		nums[1] = 32;
		nums[2] = 335;
		nums[3] = 331;
		nums[4] = 332;
		nums[5] = 33;
		nums[6] = 323;
		nums[7] = 133;
		nums[8] = 323;
		nums[9] = 333;
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		System.out.println(nums[5]);
		System.out.println(nums[6]);
		System.out.println(nums[7]);
		System.out.println(nums[8]);
		System.out.println(nums[9]);
		
		for(int index = 0; index < 10; index++) {
			System.out.println(nums[index]);
		}
	}
}
