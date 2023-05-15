package com.yopheu.exam;

public class ExamA {
	public static void main(String[] args) {
		
		// 랜덤수를 생성하고, 생성한 랜덤수가 범위에 맞는지 100번 테스트 수행
		int index = 0;
		for(index = 0; index < 100; index++) {
			int rndNum = (int)(Math.random() * 200) +1;
			if(rndNum < 1 || rndNum > 100) {
				break;
			}
		}
		// 테스트 수행한 결과가 어떤지 표현
		if(index >= 100) {
			System.out.println("100 번 수행결과 1~ 100번까지의 랜덤수를 만들고 있음");
		}else {
			System.out.println("테스트 횟수 : " + index);
			System.out.println("100 번 수행결과 " + index + "번째에서 실패함");
		}
	}
}
