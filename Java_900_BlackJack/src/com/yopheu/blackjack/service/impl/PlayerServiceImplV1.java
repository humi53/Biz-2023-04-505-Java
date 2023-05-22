package com.yopheu.blackjack.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.blackjack.models.CardDto;
import com.yopheu.blackjack.service.PlayerService;
import com.yopheu.blackjack.utils.AnsiColor;
import com.yopheu.blackjack.utils.Line;

/*
 * hit() : 카드 받기
 * showDeck() : 보유한 카드 보이기
 * showScore() : 보유한 카드의 점수 보이기
 */
public class PlayerServiceImplV1 implements PlayerService{
	
	/*
	 * new PlayerServce() 으로 생성자를 호출하면
	 * 		playerName 을 "딜러" 로 설정
	 * new PlayerService("타짜") 으로 생성자를 호출하면
	 * 		playerName 을 "타짜" 로 설정
	 */
	
	public PlayerServiceImplV1() {
		this("딜러");
	}
	
	// player 가 get(취득한, hit한) 카드를 저장할 list
	protected final List<CardDto> deckList;
//	protected final DeckServiceV1 deckService;
	protected final String playerName;
	
	public PlayerServiceImplV1(String playerName) {
		deckList = new ArrayList<>();
//		deckService = new DeckServiceV1();
		this.playerName = playerName;
	}
	
	public void hit(CardDto card) {
		deckList.add(card);
	}
	
	public void showDeck() {
		System.out.println(Line.dLine(100));
		System.out.printf("%s, 받은카드 : %d매 점수 : %d\n", playerName, deckList.size(), deckList.size());
		System.out.println(Line.sLine(100));
		
		String[] patterns = deckList.get(0).getPattern();
		
		for(int rows = 0; rows < patterns.length; rows ++) {
			for(CardDto cardDto : deckList) {
				if("◆,♥".contains(cardDto.suit)) {
					System.out.print(AnsiColor.RED(cardDto.getPattern()[rows]));
				}else {
					System.out.print(AnsiColor.CYAN(cardDto.getPattern()[rows]));
				}
			}
			System.out.println();
		}
		
		
		System.out.println(Line.dLine(100));
	}
	
	public int getScore() {
		int score = 0;
		for(CardDto card : deckList) {
			score += card.value;
		}
		return score;
	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}
	
	
	
}
