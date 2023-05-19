package com.ny.aenean.models;

import com.ny.aenean.cardconfig.InputConfig.GameState;

public class BlackJackDto {
	private DealerDto dealer;
	private PlayerDto player;
	private DeckDto deck;
	private ScoreDto scDto;
	
	private int gameState;
	private boolean bustPlayer;
	private boolean bustDealer;
	
	public BlackJackDto() {
		setDealer();
		setPlayer();
		setDeck();
		scDto = new ScoreDto();
		bustPlayer = false;
		bustDealer = false;
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

	public boolean isBustPlayer() {
		return bustPlayer;
	}

	public void setBustPlayer(boolean bustPlayer) {
		this.bustPlayer = bustPlayer;
	}

	public boolean isBustDealer() {
		return bustDealer;
	}

	public void setBustDealer(boolean bustDealer) {
		this.bustDealer = bustDealer;
	}
	
	public ScoreDto getScoreDto() {
		return scDto;
	}
	
}