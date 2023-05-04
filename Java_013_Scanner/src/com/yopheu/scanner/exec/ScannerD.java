package com.yopheu.scanner.exec;

import java.util.Scanner;

public class ScannerD {
	public static int getTenInNum() {
		return  (int)(Math.random() * 10) + 1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int rndNum = getTenInNum();
		int input = 0;
		String sInput = "";
		
		System.out.println("1 ~ 10 사이의 랜덤수가 준비되어 있어요. 맞춰보세요.");
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
					continue;
				}
				
				// 게임 내용 진행.
				if(input == rndNum) {
					System.out.println("game: 맞췄네요. 정답은 [" + rndNum + "] 입니다.");
					System.out.println(" *** 새로운 숫자가 준비됬어요. *** ");
					rndNum = getTenInNum();	// 새로운 숫자 준비
				}else {
					System.err.println("game: 아쉽게 틀렸네요 힘내세요.");
				}
			} catch (Exception e) {
				System.out.println("system: (정수) 숫자만 입력해보아요.");
			}
		}
		
	}
}
