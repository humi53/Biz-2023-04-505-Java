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
	
	// Dealer 와 Player 모두 카드를 버림.
	// Bust 정보를 false로 초기화
	// 게임상태 >> GameReady로 변경.
	private void processGameStand() {
		bjDto.setBustDealer(false);
		bjDto.setBustPlayer(false);
		bjDto.getDealer().cardClr();
		bjDto.getPlayer().cardClr();
		bjDto.getDealer().closeCard();
		bjDto.setGameState(GameState.GAMEREADY);
	}
	
	// Main화면 출력.
	// 게임상태 >> GameReady로 변경.
	private void processMain() {
		ViewPaint();
		bjDto.setGameState(ipService.scanMainScreen());
	}
	
	// 게임결과를 화면출력.
	// 게임상태 >> GameStand로 변경.
	private void processGameResult() {
		ViewPaint();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bjDto.setGameState(ipService.scanPassMessage(bjDto.getGameState()));
	}
	
	// 비어있는 테이블 출력.
	// 게임상태 >> DISTRIBUTE로 변경.
	private void processGameReady() {
		ViewPaint();
		bjDto.setGameState(ipService.scanPassMessage(bjDto.getGameState()));
	}
	
	// 플레이어가 hit, stay를 선택 대기. 그리고 입력받은후
	// 과정 처리.
	// 게임상태 >> PLAYERSTAY
	// 			>> PLAYERISBUST
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
	
	// 플레이어 stay 선택.
	// 딜러 턴 되기전 처리. (뒤집어진 카드 오픈)
	// 게임상태 >> DEALERREADY
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
	
	// 플레이어가 Bust 됬을때 처리. (21over)
	// 게임상태 >> WINNERDEALER
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
	
	// 딜러가 Bust 됬을때 처리. (21over)
	// 게임상태 >> WINNERPLAERY
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
	
	// 딜러 카드 17이 넘었을때 처리
	//		승리자 계산.
	// 게임상태 >> WINNERPLAERY
	// 			>> WINNERDEALER
	//			>> GAMEPUSH
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
	
	// 딜러 딜(카드받는) 처리
	// 게임상태 >> DEALER17OVER
	//			>> DEALERISBUST
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
	
	// 딜러or 플레이어 카드 딜.
	private void userDealCard(ISuperDto user) {
		DeckDto deck = bjDto.getDeck();
		user.deal(deck.getCard());	// 카드객체 dto에 밀어넣기.
		deck.getCardConfirm();	// deck에 있는 카드객체 제거.
	}

	// 딜러와 플레이어에게 2장씩 카드 딜.
	// 게임상태 >> PLAYERPROMPT
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

	// 덱이 10장 이하면 새로운 덱을 준비한다.
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
	}
}
