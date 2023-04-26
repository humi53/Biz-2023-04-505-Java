package com.yopheu.classes.exec;

public class ExecI {
	public static void main(String[] args) {
		int[] nums = new int[50];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		/*
		 * lastindex 초기화를 0으로 실행할 경우
		 * 만약 배열에 담긴 값중에 3의 배수가 하나도 없을 경우
		 * lastIndex 는 그대로 0이 될것이고
		 * 결과 출력에서 0의 index 와 index 0의 요소값이 출력된다
		 * 이러한 논리적인 문제를 해결하기 위하여 
		 * lastindex 를 -1 로 초기화 하고
		 * 결과 출력부분에서 lastIndex의 값을 한번 더 검사할 필요가 있다.
		 */
		int index = -1;
		int value = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 3 == 0) {
				index = i;
				value = nums[i];
			}
		}
		if(index > -1) {
			System.out.println("last index of 3 : " + index);
			System.out.println("last value of 3 : " + value);
		} else {
			System.out.println("non");
		}
		
		
		for(int i = nums.length-1; i >= 0; i--) {
			if(nums[i] % 3 == 0) {
				System.out.println("last index of 3 : " + i);
				System.out.println("last value of 3 : " + nums[i]);
				break;
			}
		}
	}
}
