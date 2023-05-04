package com.yopheu.scanner.exec;

import java.util.Scanner;

public class ScannerFA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[6];
		int numsCount = 0;

		int rndNum = 0;
		int input = 0;
		String sInput = "";

		System.out.println("1 ~ 45 사이의 정수를 6번 맞춰야 합니다");
		while (true) {
			// 배열이 꽉차면 종료.
			if (numsCount + 1 > nums.length) {
				break;
			}
			rndNum = (int) (Math.random() * 45) + 1;
			while (true) {
				try {
					System.out.print("정수(입력된수: " + numsCount + " 개) >> ");
					sInput = scan.nextLine();

					input = Integer.parseInt(sInput);
					// 1 ~ 45 확인
					if (input < 0 || input > 45) {
						System.err.println("system: 1 ~ 45까지 범위의 정수만 입력하세요");
					} else if (input == rndNum) {
						System.out.println("game: ** 맞췄네요. 정답은 [" + rndNum + "] 입니다. **");
						nums[numsCount++] = rndNum;
						break;
					} else if (input > rndNum) {
						System.err.println("game: 작은 수 입력");
					} else if (input < rndNum) {
						System.err.println("game: 큰 수 입력");
					}
				} catch (Exception e) {
					System.out.println("system: (정수) 숫자만 입력해보아요.");
				}
			}
		}
		scan.close();

		System.out.print("모은 숫자 : ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print("[" + nums[i] + "] ");
		}

	}
}
