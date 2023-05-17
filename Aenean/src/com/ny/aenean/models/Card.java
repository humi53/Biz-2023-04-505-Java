package com.ny.aenean.models;

import com.ny.aenean.cardconfig.CardConfig.CardNum;

public class Card {
	private String suit;
	private String num;
	
	public Card(String suit, String num) {
		super();
		this.suit = suit;
		this.num = num;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public int getScore() {
		int cardScore = cardNum2Score(this.num);
		if(cardScore >= 1 && cardScore <= 10) {
			return cardScore;
		}else if(cardScore == -1) {
			// 익셉션 발생
			System.out.println("카드Num 정보가 잘못되었음.");
			return 0;
		}else {
			// 익셉션 발생
			System.out.println("카드Num 정보가 1~13사이의 카드가 아님.");
			return 0;
		}
	}

	private int cardNum2Score(String sNum) {
		int cardScore = -1;
		if(
				sNum.equalsIgnoreCase(CardNum.T) ||
				sNum.equalsIgnoreCase(CardNum.J) ||
				sNum.equalsIgnoreCase(CardNum.Q) ||
				sNum.equalsIgnoreCase(CardNum.K) ) {
			cardScore = 10;				
		}else if(sNum.equalsIgnoreCase(CardNum.A)) {
			cardScore = 1;
		}else {
			try {
				cardScore = Integer.valueOf(sNum);
			} catch (Exception e) {
				cardScore = -1;
			}
		}
		return cardScore;
	}
	
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", num=" + num + "]";
	}
}
