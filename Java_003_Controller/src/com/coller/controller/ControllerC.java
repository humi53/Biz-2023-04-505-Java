package com.coller.controller;

public class ControllerC {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) { }
		
		for(int i = 0; i < 20; i+=2) { }
		
		System.out.print("화면조작 : ");
		for(int i = 0; i < 20; i+=2) {
			System.out.print(i + 1 + " ");
		}		
		System.out.println();

		System.out.print("홀수비교 : ");
		for(int i = 0; i < 20; i++) {
			if(i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		System.out.print("0일때만 i증가 : ");
		for(int i = 0; i < 20; i+=2) {
			// i++; for {} 내에서 index 값 변경하기
			// 가급적 사용하지 않는 것이 좋다
			if(i == 0){
				i++;
			}
			System.out.print(i + " ");
			
		}
	}
}
