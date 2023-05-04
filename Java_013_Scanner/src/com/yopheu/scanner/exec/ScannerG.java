package com.yopheu.scanner.exec;

import java.util.Scanner;

public class ScannerG {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		String sInput = "";
		
		// 중복되지 않은 1 ~ 45 사이의 숫자 6개를 준비
		int[] nums = new int[6];
		boolean notSame = true;
		for(int i = 0; i < nums.length; i++) {
			int ranNum = (int)(Math.random() * 45) + 1;
			notSame = true;
			for(int j = 0; j < nums.length; j++) {
				if(ranNum == nums[j]) {
					notSame = false;
					break;
				}
			}
			if(notSame) {
				nums[i] = ranNum;
			}else {
				i--;
			}
		}
		
		// 입력받아 게임 진행
		System.out.println("1 ~ 45 사이의 정수 6개를 맞춰야 합니다");
		for(int i = 0; i < nums.length; i++) {
			while (true) {
				try {
					System.out.print("정수(맞춘수: " + i + " 개) >> ");
					sInput = scan.nextLine();
					
					input = Integer.parseInt(sInput);
					// 1 ~ 45 확인
					if (input < 0 || input > 45) {
						System.err.println("system: 1 ~ 45까지 범위의 정수만 입력하세요");
					} else if (input == nums[i]) {
						System.out.println("game: ** 맞췄네요. 정답은 [" + nums[i] + "] 입니다. **");
						break;
					} else if (input > nums[i]) {
						System.err.println("game: 작은 수 입력");
					} else if (input < nums[i]) {
						System.err.println("game: 큰 수 입력");
					}
				} catch (Exception e) {
					System.out.println("system: (정수) 숫자만 입력해보아요.");
				}
			}
		}
		scan.close();

		// 정렬
		int swap = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] > nums[j]) {
					swap = nums[i];
					nums[i] = nums[j];
					nums[j] = swap;
				}
			}
		}
		  
		System.out.print("맞춘 숫자들 : ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print("[" + nums[i] + "] ");
		}
	}
}
