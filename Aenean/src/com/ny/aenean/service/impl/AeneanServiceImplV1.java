package com.ny.aenean.service.impl;

import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.models.DealerDto;
import com.ny.aenean.models.DeckDto;
import com.ny.aenean.models.ISuperDto;
import com.ny.aenean.models.PlayerDto;
import com.ny.aenean.service.AeneanInputService;
import com.ny.aenean.service.AeneanService;
import com.ny.aenean.view.AeneanView;
import com.ny.aenean.view.Impl.AeneanViewImplV1;

public class AeneanServiceImplV1 implements AeneanService{
	
	AeneanView view;
	BlackJackDto bjDto;
	AeneanInputService input;
	
	public AeneanServiceImplV1() {
		setView(new AeneanViewImplV1());
		setBlackJackDto(new BlackJackDto());
		view.setGameDeck(bjDto);
		setInputService(new AeneanInputServiceImplV1());
	}

	private void ViewPaint() {
		view.paint();
	}
	
	@Override
	public void setView(AeneanView view) {
		this.view = view;
	}

	@Override
	public void setInputService(AeneanInputService ipService) {
		this.input = ipService;
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
		dealCard();
		ViewPaint();
		playGame();
	}

	@Override
	public void setBlackJackDto(BlackJackDto bjDto) {
		this.bjDto = bjDto;
	}
	private void hitStay(int hitStay) {
		if(hitStay == 0) {
			// 받는다
		}else if(hitStay == 1) {
			// 멈춘다
		}
	}
	private void playGame() {
		int hitStay = input.scanHitStay();
		hitStay(hitStay);
		// 점수계산 - 넘어서 죽었는지 체크확인.
		
	}
	
	private void userDealCard(ISuperDto user) {
		DeckDto deck = bjDto.getDeck();
		user.deal(deck.getCard());
		deck.getCardConfirm();
	}

	private void dealCard() {
		DealerDto dealer = bjDto.getDealer();
		PlayerDto player = bjDto.getPlayer();
		
		userDealCard(dealer);
		userDealCard(dealer);
		
		userDealCard(player);
		userDealCard(player);
	}
	private void setGame() {
		// 덱을준비한다
		bjDto.getDeck().setDeck();
		
	}
}
