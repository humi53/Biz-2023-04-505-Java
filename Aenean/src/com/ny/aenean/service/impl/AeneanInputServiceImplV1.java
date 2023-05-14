package com.ny.aenean.service.impl;

import java.util.Scanner;

import com.ny.aenean.cardconfig.InputConfig.GameState;
import com.ny.aenean.cardconfig.InputConfig.HitStay;
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
			if(str.equalsIgnoreCase("H") ||
					str.equalsIgnoreCase("Y") ||
					str.equalsIgnoreCase("1") ) {
				result = HitStay.HIT;
			}else if(str.equalsIgnoreCase("S") ||
					str.equalsIgnoreCase("N") ||
					str.equalsIgnoreCase("2") ) {
				result = HitStay.STAY;
			}
		}catch (Exception e) { }
		
		return result;
	}
	
	@Override
	public int scanMainScreen() {
		System.out.print("\t\t\t Enter키를 입력하면 게임이 진행됩니다. ");
		scan.nextLine();
		return GameState.GAMEREADY;
	}
	
	@Override
	public int scanPassMessage(int gameState) {
		if(gameState == GameState.GAMEREADY) {
			System.out.print("\t 카드를 딜링하려면 Enter키를 누르세요. ");
			scan.nextLine();
			return GameState.GAMEDEALING;
		}else if(gameState == GameState.WINNERDEALER ||
				gameState == GameState.WINNERPLAERY ||
				gameState == GameState.GAMEPUSH) {
			System.out.print("\t 다음게임을 하려면 Enter키를 누르세요. ");
			scan.nextLine();
			return GameState.GAMESTAND;
		}
		return 0;
	}

}
