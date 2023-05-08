package com.yopheu.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassG {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			numList.add((int)(Math.random() * 50) + 51);
		}
		
		for(int i = 0; i < numList.size(); i++) {
			int exNum = numList.get(i);
			if(exNum % 2 == 0) {
				System.out.println("짝수인 " + i +"번째의 값 : " + exNum);
			}
		}
	}
}
