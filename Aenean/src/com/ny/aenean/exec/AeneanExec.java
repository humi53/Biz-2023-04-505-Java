package com.ny.aenean.exec;

import java.util.ArrayList;
import java.util.List;

import com.ny.aenean.models.Card;
import com.ny.aenean.view.AeneanView;
import com.ny.aenean.view.Impl.AeneanViewImplV1;

public class AeneanExec {
	public static void main(String[] args) {
		// 시작지점
		AeneanViewImplV1 view = new AeneanViewImplV1();
		
		view.setGameDeck(null);
		
		String[] temp = view.getCardImg(new Card("S","1"));
		temp = view.getCloseCardImg();
		
		for(String str : temp) {
			System.out.println(str);
		}
		
		List<Card> cardList = new ArrayList<>();
		cardList.add(new Card("S","1"));
		cardList.add(new Card("D","1"));
		cardList.add(new Card("H","1"));
		cardList.add(new Card("C","1"));
		
		temp = view.getArrCardImg(cardList);
		for(String str : temp) {
			System.out.println(str);
		}
	}
}
