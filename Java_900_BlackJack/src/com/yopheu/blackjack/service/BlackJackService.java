package com.yopheu.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.blackjack.service.impl.DeckServiceImplV1;
import com.yopheu.blackjack.service.impl.PlayerServiceImplV1;

public class BlackJackService {
	
	protected final List<PlayerService> playerList;
	protected final DeckService deckService;
	
	public BlackJackService() {
		playerList = new ArrayList<>();
		deckService = new DeckServiceImplV1();
	}
	
	public void gameStart() {
		playerList.add(new PlayerServiceImplV1());
		playerList.add(new PlayerServiceImplV1("타짜"));
		playerList.add(new PlayerServiceImplV1("영수"));
		
		for(int i = 0; i < 2; i ++) {
			for(PlayerService player : playerList) {
				player.hit(deckService.getDeck());
			}
			
			
			
		}
		
//		if(playerList.get(0).getScore() < 17) {
//			playerList.get(0).hit(deckService.getDeck());
//		}
		for(PlayerService player : playerList) {
			player.showDeck();;
		}
//		winCheck();
		int maxScore = 0;
		String maxScorePlayer = "";
		for(PlayerService player : playerList) {
			int score = player.getScore();
			String playerName = player.getPlayerName();
			if(score > maxScore) {
				maxScore = score;
				maxScorePlayer = playerName;
			}
		}
		
		System.out.printf("%s 승리, 점수 : %d\n", maxScorePlayer, maxScore);
		
		battle();
		// 딜러(0 번 player)와 각 게이머간의 점수를 비교하여
		// 딜러 : 타짜 = 타짜승, 딜러 : 영수 = 영수승 을 출력
		// 단 각 player 의 점수가 21점 초과하면 무조건 패
		// 동점이면 무승부
	}
	public void battle() {
		PlayerService dealer = playerList.get(0);
		for(PlayerService player : playerList) {
			if(dealer != player) {
				if(player.getScore() > 21) {
					System.out.printf("%s 패배 bust, 점수 : %d\n", player.getPlayerName(), player.getScore());
				}else if(player.getScore() > dealer.getScore()) {
					System.out.printf("%s 승리, 점수 : %d\n", player.getPlayerName(), player.getScore());
				}else if(player.getScore() < dealer.getScore()) {
					System.out.printf("%s 패배, 점수 : %d\n", player.getPlayerName(), player.getScore());
				}else if(player.getScore() == dealer.getScore()) {
					System.out.printf("%s 무승부, 점수 : %d\n", player.getPlayerName(), player.getScore());
				}
				
			}
		}
	}
	
	public void winCheck() {
		PlayerService winner = null;
		for(PlayerService player : playerList) {
			try {
				if(player.getScore() > winner.getScore()) {
					winner = player;
				}
			} catch (Exception e) {
				winner = player;
			}
		}
		System.out.printf("%s 승리", winner.getPlayerName());
	}
	
}
