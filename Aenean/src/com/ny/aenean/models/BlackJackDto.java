package com.ny.aenean.models;

import com.ny.aenean.cardconfig.InputConfig.GameState;

public class BlackJackDto {
	private DealerDto dealer;
	private PlayerDto player;
	private DeckDto deck;
	private int gameState;
	
	public BlackJackDto() {
		setDealer();
		setPlayer();
		setDeck();
		this.gameState = GameState.MAIN;
	}
	
	public DealerDto getDealer() {
		return dealer;
//		return new DealerDto();
	}
	public void setDealer() {
		this.dealer = new DealerDto();
	}
	public PlayerDto getPlayer() {
		return player;
	}
	public void setPlayer() {
		this.player = new PlayerDto();
	}
	public DeckDto getDeck() {
		return deck;
	}
	public void setDeck() {
		this.deck = new DeckDto();
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}
	
	
}
