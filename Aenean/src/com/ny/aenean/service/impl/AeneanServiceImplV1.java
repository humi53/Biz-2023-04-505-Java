package com.ny.aenean.service.impl;

import com.ny.aenean.cardconfig.InputConfig.GameState;
import com.ny.aenean.cardconfig.InputConfig.HitStay;
import com.ny.aenean.cardconfig.InputConfig.IsBust;
import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.models.DealerDto;
import com.ny.aenean.models.DeckDto;
import com.ny.aenean.models.ISuperDto;
import com.ny.aenean.models.PlayerDto;
import com.ny.aenean.service.AeneanInputService;
import com.ny.aenean.service.AeneanService;
import com.ny.aenean.view.AeneanView;
import com.ny.aenean.view.impl.AeneanViewImplV1;

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
		
//		dealCard();
		while(true) {
			setGame();
			ViewPaint();
			if(bjDto.getGameState() == GameState.MAIN) {			// 메인화면
				bjDto.setGameState(input.scanMainScreen());
			}else if(bjDto.getGameState() == GameState.GAMEREADY) {		// 카드 나눠주기 전
				bjDto.setGameState(input.scanPassMessage(bjDto.getGameState()));
			}else if(bjDto.getGameState() == GameState.GAMEDEALING) {	// 카드 2장씩 나눠주기
				loadDealing();
				bjDto.setGameState(GameState.PLAYERPROMPT);
			}else if(bjDto.getGameState() == GameState.PLAYERPROMPT) {	// 플레이어 hit stay 선택 대기
				bjDto.setGameState(playGameDealing(bjDto.getPlayer()));
			}else if(bjDto.getGameState() == GameState.PLAYERSTAY) {	// 플레이어 stay 선택 시.
				bjDto.setGameState(GameState.DEALERREADY);
			}else if(bjDto.getGameState() == GameState.PLAYERISBUST) {	// 플레이어 bust 상태 시.
				bustViewPaint();
				dealerOpenCard();
				ViewPaint();
				bjDto.setGameState(GameState.WINNERDEALER);
			}else if(bjDto.getGameState() == GameState.DEALERREADY) {	// 딜러 ready 상태. 
				dealerOpenCard();
				bjDto.setGameState(dealerGameDealing(bjDto.getDealer()));
			}else if(bjDto.getGameState() == GameState.DEALER17OVER) {	// 딜러 딜링 끝난 상태.
				bjDto.setGameState(calcResult());
			}else if(bjDto.getGameState() == GameState.DEALERISBUST) {	// 딜러 bust 난 상태.
				bustViewPaint();
				bjDto.setGameState(GameState.WINNERPLAERY);
			}else if(bjDto.getGameState() == GameState.WINNERDEALER ||
					bjDto.getGameState() == GameState.WINNERPLAERY ||
					bjDto.getGameState() == GameState.GAMEPUSH) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bjDto.setGameState(input.scanPassMessage(bjDto.getGameState()));
			}else if(bjDto.getGameState() == GameState.GAMESTAND) {	// 다음게임 대기상태. 넘어가면 초기화하고 대기함
				bjDto.getDealer().cardClr();
				bjDto.getPlayer().cardClr();
				bjDto.getDealer().closeCard();
				bjDto.setGameState(GameState.GAMEREADY);
			}
		}
		
//		playGame();
	}

	@Override
	public void setBlackJackDto(BlackJackDto bjDto) {
		this.bjDto = bjDto;
	}
	
	private void bustViewPaint() {
		ViewPaint();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void dealerOpenCard() {
		try {
			Thread.sleep(1000);
			bjDto.getDealer().openCard();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int calcResult() {
		int dealerScore = bjDto.getDealer().getSumScore();
		int playerScore = bjDto.getPlayer().getSumScore();
		if(playerScore == 21) {
//			return GameState.PLAYERBLACKJACK;
			return GameState.WINNERPLAERY;
		}else if(playerScore > dealerScore) {
			return GameState.WINNERPLAERY;
		}else if(playerScore < dealerScore) {
			return GameState.WINNERDEALER;
		}else if(playerScore == dealerScore) {
			return GameState.GAMEPUSH;
		}
		
		return 0;
	}
	
	private int dealerGameDealing(DealerDto dealer) {
		do {
			ViewPaint();
			if(dealer.getScore17IsOver()) {
				return GameState.DEALER17OVER;
			}else {
				userDealCard(dealer);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ViewPaint();
			}
			if(dealer.getBustState() == IsBust.BUST) {
				return GameState.DEALERISBUST;
			}
		}while (true);
	}
	
	private int playGameDealing(PlayerDto player) {
		do {
			int hitStay = input.scanHitStay();
			if(hitStay == HitStay.HIT) {
				// 받는다.
				userDealCard(player);
			}else if(hitStay == HitStay.STAY) {
				return GameState.PLAYERSTAY;
			}
			if(player.getBustState() == IsBust.BUST) {
				// 버스트 된정보를 표시.
				ViewPaint();		
				return GameState.PLAYERISBUST;
			}else {
				ViewPaint();
			}
		}while (true);
	}

	
	private void userDealCard(ISuperDto user) {
		DeckDto deck = bjDto.getDeck();
		user.deal(deck.getCard());	// 카드객체 dto에 밀어넣기.
		deck.getCardConfirm();	// deck에 있는 카드객체 제거.
	}

	private void loadDealing() {
		for(int i = 0; i < 4; i++) {
			if(i < 2) {
				userDealCard(bjDto.getDealer());
			}else {
				userDealCard(bjDto.getPlayer());
			}
			ViewPaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void setGame() {
		if(bjDto.getDeck().getDeckListCount() < 10 && bjDto.getGameState() == GameState.GAMESTAND) {
			try {
				Thread.sleep(2000);
				System.out.println("새로운 덱을 준비하고 있습니다.");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bjDto.getDeck().setDeck();
		}
		// 덱을준비한다
//		bjDto.getDeck().setDeck();
		
	}
}
