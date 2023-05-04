package com.yopheu.scanner.exec;

import java.util.Scanner;

public class ScannerE {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int rndNum = 0;
		int input = 0;
		String sInput = "";
		
		System.out.println("1 ~ 10 사이의 랜덤수가 준비되어 있어요. 맞춰보세요.");
		while(true) {
			rndNum = (int)(Math.random() * 10) + 1;
			while(true) {
				try {
					System.out.print("정수(QUIT : 종료) >> ");
					sInput = scan.nextLine();
					// 종료 명령어 확인.
					if(sInput.equalsIgnoreCase("QUIT")) {
						System.out.println("GAME OVER");
						scan.close();
						return;
					}
					
					input = Integer.parseInt(sInput);
					// 1 ~ 10 확인
					if(input < 0 || input > 10) {
						System.err.println("system: 숫자가 범위를 벗어났습니다.");
						continue;
					}
					
					// 게임 내용 진행.
					if(input == rndNum) {
						System.out.println("game: ** 맞췄네요. 정답은 [" + rndNum + "] 입니다. **");
						System.out.println(" *** 새로운 숫자가 준비됬어요. *** ");
					}else if(input > rndNum){
						System.err.println("game: 작은 수 입력");
					}else if(input < rndNum) {
						System.err.println("game: 큰 수 입력");
					}
				} catch (Exception e) {
					System.out.println("system: (정수) 숫자만 입력해보아요.");
				}
			}
		}
		
	}
}
