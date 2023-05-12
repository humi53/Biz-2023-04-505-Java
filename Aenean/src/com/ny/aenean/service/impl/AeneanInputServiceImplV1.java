package com.ny.aenean.service.impl;

import java.util.Scanner;

import com.ny.aenean.service.AeneanInputService;

public class AeneanInputServiceImplV1 implements AeneanInputService{
	
	Scanner scan;
	public AeneanInputServiceImplV1() {
		scan = new Scanner(System.in);
	}
	
	@Override
	public int scanHitStay() {
		System.out.println("\t\t다른키를 입력시 반응하지 않습니다.");
		System.out.println("-".repeat(90));
		System.out.print("입력 : 1.Hit(H,Y,1)  2.Stay(S,N,2) >> ");
		String str = scan.nextLine();
		int result = -1;
		try {
			result = Integer.valueOf(str);
		}catch (Exception e) { }
		
		return result;
	}

	@Override
	public int scanPassMessage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
