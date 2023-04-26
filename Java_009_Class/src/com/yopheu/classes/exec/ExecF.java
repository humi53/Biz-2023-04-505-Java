package com.yopheu.classes.exec;

public class ExecF {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		// 배열의 요소에 저장된 값 중에서 최초로 5의 배수가 저장된
		// 위치 찾기
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 5 == 0) {
				System.out.printf("index : [%d] 안의 값 %d (은 첫번째 5의 배수)", i, nums[i]);
				break;
			}
		}
			
	}
}
