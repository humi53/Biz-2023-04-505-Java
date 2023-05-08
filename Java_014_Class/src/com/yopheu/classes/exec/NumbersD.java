package com.yopheu.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class NumbersD {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		
		for(int i = 0; i < 45; i++) {
			numList.add(i+1);
		}
		
		for(int i = 0; i < 1000; i++) {
			int ranIndex1 = (int)(Math.random() * numList.size());
			int ranIndex2 = (int)(Math.random() * numList.size());
			int swap = numList.get(ranIndex1);
			numList.set(ranIndex1, numList.get(ranIndex2));
			numList.set(ranIndex2, swap);
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.print(numList.get(i) + "\t");
		}
	}
}
