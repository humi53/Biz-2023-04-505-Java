package com.ny.aenean.models;

import java.util.ArrayList;
import java.util.List;

public class DealerDto {
	private List<Card> dCards;	
	private boolean cardOpen;	// 2번째 카드 오픈 여부
	
	public DealerDto() {
		dCards = new ArrayList<>();
		cardOpen = false;
	}

	// 카드 (딜) 받기
	public void deal(Card card) {
		dCards.add(card);
	}
	
	public List<Card> getCardList(){
		return dCards;
	}

	// 카드 전부 버리기
	public void cardClr() {
		dCards.clear();
	}
	
	public void openCard() {
		cardOpen = true;
	}
	
	public void closeCard() {
		cardOpen = false;
	}
	
	public boolean getIsOpen() {
		return cardOpen;
	}

	@Override
	public String toString() {
		return "DealerDto [dCards=" + dCards + ", cardOpen=" + cardOpen + "]";
	}
	
	
}
