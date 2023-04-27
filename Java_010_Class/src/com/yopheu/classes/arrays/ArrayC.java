package com.yopheu.classes.arrays;

public class ArrayC {
	public static void main(String[] args) {
		int[] nums = new int[45];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
		}
		
		for(int i = 0; i < 1000; i++) {
			int id1 = (int)(Math.random() * nums.length);
			int id2 = (int)(Math.random() * nums.length);
			
			int swap = nums[id1];
			nums[id1] = nums[id2];
			nums[id2] = swap;
			
//			nums[id1] = nums[id1] + nums[id2];
//			nums[id2] = nums[id1] - nums[id2];
//			nums[id1] = nums[id1] - nums[id2];
		}
		
		int[] lottos = new int[6];
		for(int i = 0; i < lottos.length; i++) {
			System.out.print(nums[i] + "\t");
			lottos[i] = nums[i];
		}
		System.out.println();
		
		for(int out = 0; out < lottos.length - 1; out++) {
			for(int in = out+1; in < lottos.length; in++) {
				if(lottos[out] > lottos[in]) {
					lottos[out] = lottos[out] + lottos[in];
					lottos[in] = lottos[out] - lottos[in];
					lottos[out] = lottos[out] - lottos[in];
				}
			}
		}
		for(int i = 0; i < lottos.length; i++) {
			System.out.printf("%d\t", lottos[i]);
		}
		System.out.println();
		
	}
}
