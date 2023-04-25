package com.yopheu.classes.arrays;

public class ArrayE {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i = 0; i < 10; i++) {
			nums[i] = i + 1;
		}
		for(int i = 0; i < 10; i++) {
			if(nums[i] % 2 == 0) {
				System.out.print(nums[i] + "\t");
			}
		}
		System.out.println();
		
		
		for(int i = 0; i < 10; i++) {
			boolean yesPrime = true;
			if(nums[i] == 1 || nums[i] == 0) {
				yesPrime = false;
			}
			for(int j = 2; j < nums[i]; j++) {
				if(nums[i] % j == 0) {
					yesPrime = false;
					break;
				}
			}
			if(yesPrime) {
				System.out.println(nums[i] + " 소수");
			} else {
				System.out.println(nums[i] + " 소수 아님");
			}
			
//			int j = 0;
//			for(j = 2; j < nums[i]; j++) {
//				if(nums[i] % j == 0) {
//					break;
//				}
//			}
//			if(nums[i] == j) {
//				System.out.print(nums[i] + "\t");
//			}
		}
	}
}
