package com.ny.aenean.models;

import java.util.ArrayList;
import java.util.List;

import com.ny.aenean.cardconfig.InputConfig.IsBust;

public class PlayerDto implements ISuperDto{
	private List<Card> pCards;
	
	public PlayerDto() {
		this.pCards = new ArrayList<>();
	}
	
	// 카드 (딜) 받기
	@Override
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

	@Override
	public int getSumScore() {
		int sumScore = 0;
		for(Card card : pCards) {
			// exception 만들어 try catch. 처리 필요.
			sumScore += card.getScore();
			
		}
		return sumScore;
	}

	@Override
	public boolean getBustState() {
		boolean isBust = IsBust.NOTBUST;
		if(getSumScore() > 21) {
			isBust = IsBust.BUST;
		}else {
			isBust = IsBust.NOTBUST;
		}
		return isBust;
	}
	
	
}
