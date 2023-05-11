package com.ny.aenean.models;

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
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", num=" + num + "]";
	}
}
