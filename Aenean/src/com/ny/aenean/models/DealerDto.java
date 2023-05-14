package com.ny.aenean.models;

import java.util.ArrayList;
import java.util.List;

import com.ny.aenean.cardconfig.InputConfig.IsBust;
import com.ny.aenean.cardconfig.InputConfig.Score17IsOver;

public class DealerDto implements ISuperDto{
	private List<Card> dCards;	
	private boolean cardOpen;	// 2번째 카드 오픈 여부
	
	public DealerDto() {
		dCards = new ArrayList<>();
		cardOpen = false;
	}

	// 카드 (딜) 받기
	@Override
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

	@Override
	public int getSumScore() {
		int sumScore = 0;
		for(Card card : dCards) {
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
	
	public boolean getScore17IsOver() {
		boolean isOver = false;
		if(getSumScore() >= 17) {
			isOver = Score17IsOver.OVER;
		}else {
			isOver = Score17IsOver.NOTOVER;
		}
		return isOver;
	}
	
}
