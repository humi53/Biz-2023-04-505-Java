package com.ny.aenean.models;

public class BlackJackDto {
	private DealerDto dealer;
	private PlayerDto player;
	private DeckDto deck;
	
	public BlackJackDto() {
		setDealer();
		setPlayer();
		setDeck();
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
	
	
}
