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
import com.ny.aenean.view.Impl.AeneanViewImplV2;

public class AeneanServiceImplV2 implements AeneanService{
	
	AeneanView view;
	BlackJackDto bjDto;
	AeneanInputService ipService;
	
	public AeneanServiceImplV2() {
		setView(new AeneanViewImplV2());
		setBlackJackDto(new BlackJackDto());
		view.setGameDeck(bjDto);
		setInputService(new AeneanInputServiceImplV2());
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
		this.ipService = ipService;
		
	}
	
	@Override
	public void setBlackJackDto(BlackJackDto bjDto) {
		this.bjDto = bjDto;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
//		bjDto.setGameState(GameState.MAIN);
		while(true) {
			setGame();
			if(bjDto.getGameState() == GameState.MAIN) {			// 메인화면
				processMain();
			}else 
			if(bjDto.getGameState() == GameState.GAMEREADY) {		// 카드 나눠주기 전
				processGameReady();
			}else if(bjDto.getGameState() == GameState.DISTRIBUTE) {	// 카드 2장씩 나눠주기
				processGameDistibute();
			}else if(bjDto.getGameState() == GameState.PLAYERPROMPT) {	// 플레이어 hit stay 선택 대기
				processPlayerPrompt();
			}else if(bjDto.getGameState() == GameState.PLAYERSTAY) {	// 플레이어 stay 선택 시.
				processPlayerStay();
			}else if(bjDto.getGameState() == GameState.PLAYERISBUST) {	// 플레이어 bust 상태 시.
				processPlayerIsBust();
			}else if(bjDto.getGameState() == GameState.DEALERREADY) {	// 딜러 ready 상태. 
				processDealerReady();
			}else if(bjDto.getGameState() == GameState.DEALER17OVER) {	// 딜러 딜링 끝난 상태.
				processDealer17Over();
			}else if(bjDto.getGameState() == GameState.DEALERISBUST) {	// 딜러 bust 난 상태.
				processDealerIsBust();
			}else if(bjDto.getGameState() == GameState.WINNERDEALER ||
					bjDto.getGameState() == GameState.WINNERPLAERY ||
					bjDto.getGameState() == GameState.GAMEPUSH) {
				processGameResult();
			}else if(bjDto.getGameState() == GameState.GAMESTAND) {	// 다음게임 대기상태. 넘어가면 초기화하고 대기함
				processGameStand();
			}
		}
	}
	private void processGameStand() {
		bjDto.getDealer().cardClr();
		bjDto.getPlayer().cardClr();
		bjDto.getDealer().closeCard();
		bjDto.setGameState(GameState.GAMEREADY);
	}
	
	private void processMain() {
		ViewPaint();
		bjDto.setGameState(ipService.scanMainScreen());
	}
	
	private void processGameResult() {
		ViewPaint();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bjDto.setGameState(ipService.scanPassMessage(bjDto.getGameState()));
	}
	
	private void processGameReady() {
		ViewPaint();
		bjDto.setGameState(ipService.scanPassMessage(bjDto.getGameState()));
	}
	
	private void processPlayerPrompt() {
		PlayerDto player = bjDto.getPlayer();
		int gameState = GameState.PLAYERPROMPT;
		do {
			int hitStay = ipService.scanHitStay();
			if(hitStay == HitStay.HIT) {
				// 받는다.
				userDealCard(player);
			}else if(hitStay == HitStay.STAY) {
				gameState = GameState.PLAYERSTAY;
				break;
			}
			ViewPaint();
			if(player.getBustState() == IsBust.BUST) {
				// 버스트 된정보를 표시.
				bjDto.setBustPlayer(player.getBustState());
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ViewPaint();	
				gameState = GameState.PLAYERISBUST;
				break;
			}
		}while (true);
		bjDto.setGameState(gameState);
	}
	
	private void processPlayerStay() {
		try {
			bjDto.getDealer().openCard();
			Thread.sleep(1000);
			ViewPaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bjDto.setGameState(GameState.DEALERREADY);
	}
	
	private void processPlayerIsBust() {
		try {
			bjDto.getDealer().openCard();
			Thread.sleep(1000);
			ViewPaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bjDto.setGameState(GameState.WINNERDEALER);
	}
	private void processDealerIsBust() {
		try {
			bjDto.getDealer().openCard();
			Thread.sleep(1000);
			ViewPaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bjDto.setGameState(GameState.WINNERPLAERY);
	}
	
	private void processDealer17Over() {
		int dealerScore = bjDto.getDealer().getSumScore();
		int playerScore = bjDto.getPlayer().getSumScore();
		int gameState = GameState.DEALER17OVER;
		if(playerScore == 21) {
//			return GameState.PLAYERBLACKJACK;
			gameState = GameState.WINNERPLAERY;
		}else if(playerScore > dealerScore) {
			gameState = GameState.WINNERPLAERY;
		}else if(playerScore < dealerScore) {
			gameState = GameState.WINNERDEALER;
		}else if(playerScore == dealerScore) {
			gameState = GameState.GAMEPUSH;
		}
		bjDto.setGameState(gameState);
	}
	
	private void processDealerReady() {
		DealerDto dealer = bjDto.getDealer();
		int gameState = GameState.DEALERREADY;
		do {
			ViewPaint();
			if(dealer.getScore17IsOver()) {
				gameState = GameState.DEALER17OVER;
				break;
			}else {
				userDealCard(dealer);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ViewPaint();
			}
			if(dealer.getBustState() == IsBust.BUST) {
				bjDto.setBustDealer(dealer.getBustState());
				gameState = GameState.DEALERISBUST;
				break;
			}
		}while (true);
		bjDto.setGameState(gameState);
	}
	
	private void userDealCard(ISuperDto user) {
		DeckDto deck = bjDto.getDeck();
		user.deal(deck.getCard());	// 카드객체 dto에 밀어넣기.
		deck.getCardConfirm();	// deck에 있는 카드객체 제거.
	}

	private void processGameDistibute() {
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
		bjDto.setGameState(GameState.PLAYERPROMPT);
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
