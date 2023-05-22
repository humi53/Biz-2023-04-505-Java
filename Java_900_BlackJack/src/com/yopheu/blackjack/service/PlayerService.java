package com.yopheu.blackjack.service;

import com.yopheu.blackjack.models.CardDto;

/*
 * hit() : 카드 받기
 * showDeck() : 보유한 카드 보이기
 * showScore() : 보유한 카드의 점수 보이기
 */
public interface PlayerService {
	
	public void hit(CardDto card);
	public void showDeck();
	public int getScore() ;
	public String getPlayerName();
	
}
