package com.yopheu.blackjack.service;

import java.util.List;

import com.yopheu.blackjack.models.CardDto;

public interface DeckService {
	
	public List<CardDto> newCardDeck();
	public CardDto getDeck();
	public void makeDeckList();
	
}
