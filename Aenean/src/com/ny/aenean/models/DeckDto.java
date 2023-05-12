package com.ny.aenean.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ny.aenean.cardconfig.CardConfig;

public class DeckDto {
	// 52
	Card[] arrCard;
	List<Card> listCard;

	public DeckDto() {
		this.arrCard = makeDeck();
		this.listCard = mixCard(arrCard);
	}
	
	public void setDeck() {
		this.listCard = mixCard(arrCard);
	}
	
	public Card getCard() {
		return listCard.get(0);
	}
	public void getCardConfirm() {
		listCard.remove(0);
	}
	
	private List<Card> mixCard(Card[] arrCard){
		int rndNum1 = 0;
		int rndNum2 = 0;
		List<Card> listCard = new ArrayList<>();
		
		for(int i = 0; i < 10000; i++) {
			rndNum1 = (int)(Math.random() * arrCard.length);
			rndNum2 = (int)(Math.random() * arrCard.length);
			
			Card swap = arrCard[rndNum1];
			arrCard[rndNum1] = arrCard[rndNum2];
			arrCard[rndNum2] = swap;
		}
//		listCard = Arrays.asList(arrCard);
		for(int i = 0; i < arrCard.length; i++) {
			listCard.add(arrCard[i]);
		}
		
		return listCard;
	}
	public int getDeckListCount() {
		return listCard.size();
	}
	
	private Card[] makeDeck() {
		Card[] arrCard = new Card[52];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card card = null;
				String suit = "";
				String num = "";
				switch (i) {
				case 0:
					suit = CardConfig.CardSuit.SPADE;
					break;
				case 1:
					suit = CardConfig.CardSuit.DIAMOND;
					break;
				case 2:
					suit = CardConfig.CardSuit.HART;
					break;
				case 3:
					suit = CardConfig.CardSuit.CLOVER;
					break;
				}
				
				if(j == 0) {
					num = "A";
				}else if(j == 9) {
					num = "T";							
				}else if(j == 10) {
					num = "J";
				}else if(j == 11) {
					num = "Q";
				}else if(j == 12) {
					num = "K";
				}else {
					num = "" + (j+1);
				}
				
				card = new Card(suit, num);
				arrCard[(i*13)+j] = card;
			}
		}
		return arrCard;
	}

	@Override
	public String toString() {
		return "DeckDto [arrCard(" + arrCard.length + ")=" + Arrays.toString(arrCard) + ",\n listCard(" + listCard.size() + ")=" + listCard + "]";
	}
	
	
}
