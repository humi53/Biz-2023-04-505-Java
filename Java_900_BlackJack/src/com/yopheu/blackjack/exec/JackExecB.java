package com.yopheu.blackjack.exec;

import com.yopheu.blackjack.service.BlackJackService;

public class JackExecB {
	public static void main(String[] args) {
		BlackJackService blackJack = new BlackJackService();
		blackJack.gameStart();
	}
}
