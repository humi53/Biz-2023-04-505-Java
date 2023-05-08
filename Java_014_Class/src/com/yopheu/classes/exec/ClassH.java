package com.yopheu.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassH {
	public static void main(String[] args) {
		// java 1.7 이후 버전에서는 생성자에는 Generic 을 생략해도 된다.
		List<Integer> numList = new ArrayList<Integer>();
//		List<Integer> numList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			numList.add((int)(Math.random() * 50) + 51);
		}
		
		for(int i = 0; i < numList.size(); i++) {
			System.out.print(numList.get(i) + "\t");
		}
		System.out.println();
		
		for(int o = 0; o < numList.size() - 1; o++) {
			for(int i = o+1; i < numList.size(); i++) {
				if(numList.get(o) > numList.get(i)) {
					System.out.print(o);
					int swap = numList.get(i);
//					numList.remove(i);
//					numList.add(i, numList.get(o));
//					numList.remove(o);
//					numList.add(o, swap);
					numList.set(i, numList.get(o));
					numList.set(o, swap);
					
				}
			}
			System.out.println();
		}
		
		// List type 의 객체변수에는 toString() method 가 포함되고
		// 단순히 List 의 값들을 출력해 볼 수 있다.
		System.out.println(numList.toString());
		for(int i = 0; i < numList.size(); i++) {
			System.out.print(numList.get(i) + "\t");
		}
	}
}
