package com.ny.aenean.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerDto {
	private List<Card> pCards;
	
	public PlayerDto() {
		this.pCards = new ArrayList<>();
	}
	
	// 카드 (딜) 받기
	public void deal(Card card) {
		pCards.add(card);
	}
	
	public List<Card> getCardList(){
		return pCards;
	}
	
	// 카드 전부 버리기
	public void cardClr() {
		pCards.clear();
	}

	@Override
	public String toString() {
		return "PlayerDto [pCards=" + pCards + "]";
	}
	
	
}
