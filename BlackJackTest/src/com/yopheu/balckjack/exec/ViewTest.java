package com.yopheu.balckjack.exec;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.balckjack.models.MyDto;

public class ViewTest {
	  public static void clearScreen() {
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	  }

	public static void clearScreen2() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void main(String[] args) {
		MyDto[] arrDto;
		arrDto = new MyDto[5];
		for(int i = 0; i < arrDto.length; i++) {
			arrDto[i] = new MyDto();
		}
		
		for(int i = 0; i < arrDto.length; i++) {
			System.out.println(arrDto[i]);
		}
		 
		List<MyDto> dtoList;
		dtoList = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			MyDto myDto = new MyDto();
			myDto.name = "S" + i;
			myDto.num1 = i+1;
			myDto.num2 = 100 + i + 1;
			dtoList.add(new MyDto());
		}
		
		
		String str1 = "0001000101";
		String str2 = "00010001";
		System.out.println(str1.substring(0,str2.length()));
		System.out.println();
		
		
	}
}
