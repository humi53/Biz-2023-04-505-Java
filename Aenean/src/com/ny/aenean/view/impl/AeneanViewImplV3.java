package com.ny.aenean.view.impl;

import java.util.Arrays;
import java.util.List;

import com.ny.aenean.cardconfig.CardConfig.CardSuit;
import com.ny.aenean.cardconfig.CardConfig.ViewColor;
import com.ny.aenean.cardconfig.CardConfig.ViewSuit;
import com.ny.aenean.cardconfig.InputConfig.GameState;
import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.models.Card;
import com.ny.aenean.models.DealerDto;
import com.ny.aenean.models.DeckDto;
import com.ny.aenean.models.ISuperDto;
import com.ny.aenean.models.PlayerDto;
import com.ny.aenean.models.ScoreDto;
import com.ny.aenean.view.AeneanView;

public class AeneanViewImplV3 implements AeneanView {
	BlackJackDto bjDto;

	@Override
	public void setGameDeck(BlackJackDto bjDto) {
		this.bjDto = bjDto;
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub
		// GameState의 상황은 InputConfig.GameState의 주석을 참고.
		if (bjDto.getGameState() == GameState.MAIN) {
			printGameMain();
		} else if (bjDto.getGameState() == GameState.GAMEREADY) {
			printGamePlaying();
		} else if (bjDto.getGameState() == GameState.BETTING) {
			printGamePlaying();
		} else if (bjDto.getGameState() == GameState.DISTRIBUTE) { // GameDealing == Distribute
			printGamePlaying();
		} else if (bjDto.getGameState() == GameState.PLAYERPROMPT) {
			printGamePlaying();
		} else if (bjDto.getGameState() == GameState.DEALERREADY) {
			printGamePlaying();
		} else if (bjDto.getGameState() == GameState.DEALERISBUST || bjDto.getGameState() == GameState.PLAYERISBUST) {
			printGamePlaying();
		} else if (bjDto.getGameState() == GameState.WINNERDEALER || bjDto.getGameState() == GameState.WINNERPLAERY
				|| bjDto.getGameState() == GameState.PLAYERBLACKJACK 
				|| bjDto.getGameState() == GameState.GAMEPUSH) {
			printGamePlaying();
		}
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub

	}

	public static void clearScreen() {
		for (int i = 0; i < 80; i++) {
			System.out.println("");
		}
	}

	// 진입시 메인화면.
	private void printGameMain() {
		String[] firImg = { "", "", "" };
		String[] secImg = { "", "", "" };
		String[][] cardText = { { "Bl", "ac", "k ", "Ja", "ck" }, { "♠T", "ac", "k ", "Ja", "ck" },
				{ "♠T", "♠J", "k ", "Ja", "ck" }, { "♠T", "♠J", "♠Q", "Ja", "ck" }, { "♠T", "♠J", "♠Q", "♠K", "ck" },
				{ "♠T", "♠J", "♠Q", "♠K", "♠A" } };
		String[][] cardText2 = { { "Ae", "ne", "an" }, { "♠K", "ne", "an" }, { "♠K", "♠Q", "an" },
				{ "♠K", "♠Q", "♠A" }, };
		int cardTextSize = cardText.length;
		int cardText2Size = cardText2.length;
		for (int i = 0; i < cardTextSize + cardText2Size; i++) {
			// 출력화면 세팅
			Arrays.fill(firImg, "");
			Arrays.fill(secImg, "");
			setMoreImg(firImg, makeOneTab(2));
			setMoreImg(secImg, makeOneTab(2));
			if (i < cardTextSize) {
				// 첫번째 줄
				for (int j = 0; j < cardText[i].length; j++) {
					if (cardText[i][j].contains("♠")) {
						setMoreImg(firImg, getGoldCardImg(cardText[i][j], 1));
					} else {
						setMoreImg(firImg, getGoldCardImg(cardText[i][j]));
					}
				}
				// 두번째 줄
				for (int j = 0; j < cardText2[0].length; j++) {
					setMoreImg(secImg, getGoldCardImg(cardText2[0][j]));
				}
			} else {
				// 첫번째 줄
				for (int j = 0; j < cardText[cardText.length - 1].length; j++) {
					setMoreImg(firImg, getGoldCardImg(cardText[cardText.length - 1][j], 1));
				}
				// 두번째 줄
				for (int j = 0; j < cardText2[i - cardTextSize].length; j++) {
					if (cardText2[i - cardTextSize][j].contains("♠")) {
						setMoreImg(secImg, getGoldCardImg(cardText2[i - cardTextSize][j], 1));
					} else {
						setMoreImg(secImg, getGoldCardImg(cardText2[i - cardTextSize][j]));
					}
				}
			}

			// 이미지 출력.
			// 화면 클리어
			clearScreen();
			System.out.println("=".repeat(90));
			System.out.println("\t\t\t 텍사스 홀덤 아니죠. BlackJack 맞습니다.");
			System.out.println("=".repeat(90));
			// 카드 출력
			printArrayImg(firImg);
			printArrayImg(secImg);
			// 테이블 끝 표현
			System.out.println("─".repeat(90));

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 진행중인 게임화면 출력.
	private void printGamePlaying() {
		String[] topImg = { "", "", "" };
		String[] firImg = { "", "", "" };
		String[] secImg = { "", "", "" };

		// ================================================================
		// 출력 데이터 셋팅 및 로딩
		// 위에
		setMoreImg(topImg, makeOneTab(6));
		setMoreImg(topImg, getDeckImg());

		// 카드 첫줄...
		setMoreImg(firImg, makeNameImg("Dealer")); // 딜러라는 표시와 공백
		setMoreImg(firImg, getDealerImg()); // 딜러카드 이미지
		if (bjDto.isBustDealer())
			setMoreImg(firImg, getBustImg(bjDto.getDealer()));

		// 카드 두번째줄...
		setMoreImg(secImg, makeNameImg("Player")); // 플레이어라는 표시와 공백
		setMoreImg(secImg, getPlayerImg()); // 플레이어 카드 이미지
		if (bjDto.isBustPlayer())
			setMoreImg(secImg, getBustImg(bjDto.getPlayer()));
		// 게임 타이틀

		// =================================================================
		// 화면 클리어
		clearScreen();
		// 카드 출력
		printArrayImg(topImg);
		printArrayImg(firImg);
		printArrayImg(secImg);

		// 테이블 끝 표현
		System.out.println("─".repeat(90));
		// -------------------
		
		// 베팅값 출력
		printBetState();
		System.out.println("─".repeat(90));
		// 게임결과 표현
		if (bjDto.getGameState() == GameState.WINNERDEALER || bjDto.getGameState() == GameState.WINNERPLAERY
				|| bjDto.getGameState() == GameState.PLAYERBLACKJACK 
				|| bjDto.getGameState() == GameState.GAMEPUSH) {

			printWinMessage();
		}

	}
	private void printBetState() {
		ScoreDto scDto = bjDto.getScoreDto();
		int cash = scDto.getPlayerCash();
		int bet = scDto.getNowBet();
		int mul = scDto.getMul();
		int accWin = scDto.getAccWin();
		// System.out.printf("%d\t" ,"(%d)%d\t" , "%d\t",cash,mul,bet,accWin);
		System.out.printf("현재금액 : %d\t 배팅금액(x%d) : %d\t 누적금액 : %d\n",cash,mul,bet,accWin);
	}

	private String[] getBustImg(ISuperDto user) {
		if (user.getBustState()) {
			return makeBustImg();
		} else {
			String[] non = { "", "", "" };
			return non;
		}
	}

	private void printWinMessage() {
		int gameState = bjDto.getGameState();
		String str = "";
		if (gameState == GameState.WINNERDEALER) {
			str += ViewColor.RED;
			str += "-Dealer-";
			str += " 가 이겼습니다.";
			str += ViewColor.END;
		} else if (gameState == GameState.WINNERPLAERY) {
			str += ViewColor.YELLOW;
			str += "[Player]";
			str += " 가 이겼습니다.";
			str += ViewColor.END;
		} else if (gameState == GameState.GAMEPUSH) {
			str += ViewColor.GREEN;
			str += "게임이 Push 되었습니다.";
			str += ViewColor.END;
		} else if (gameState == GameState.PLAYERBLACKJACK) {
			str += ViewColor.YELLOW;
			str += "[Player] 가 ";
			str += ViewColor.RED;
			str += "BlakJeck";
			str += ViewColor.END;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\t\t" + str);

	}

	// 원하는 viewImg 에 추가 Img 붙이기
	private void setMoreImg(String[] sViewImg, String[] moreImg) {
		for (int i = 0; i < sViewImg.length; i++) {
			sViewImg[i] += moreImg[i];
		}
	}

	// 이름 이미지 만들기 return
	private String[] makeNameImg(String name) {
		String[] sVeiwImg = { "", "", "" };
		sVeiwImg[0] += "\t\t ";
		sVeiwImg[1] += "\t" + name + " : ";
		sVeiwImg[2] += "\t\t ";
		return sVeiwImg;
	}

	private String[] makeBustImg() {
		String[] cardImg = { "", "", "" };

		String tempHead = "";
		String tempBody = "";
		String tempFoot = "";
		String tempSide = "";

		tempHead = ViewColor.RED;
		tempHead += "┌──────┐";
		tempHead += ViewColor.END;
		cardImg[0] = tempHead;

		tempSide = ViewColor.RED;
		tempSide += "│";
		tempSide += ViewColor.END;

		tempBody = tempSide;
		tempBody += ViewColor.RED;
		tempBody += ":Bust!";
		tempBody += ViewColor.END;
		tempBody += tempSide;
		cardImg[1] = tempBody;

		tempFoot = ViewColor.RED;
		tempFoot += "└──────┘";
		tempFoot += ViewColor.END;
		cardImg[2] = tempFoot;

		return cardImg;
	}

	// Tab 이미지 만들기 return
	private String[] makeOneTab(int num) {
		String[] sVeiwImg = { "", "", "" };
		for (int i = 0; i < num; i++) {
			sVeiwImg[0] += "\t";
			sVeiwImg[1] += "\t";
			sVeiwImg[2] += "\t";
		}
		return sVeiwImg;
	}

	// 카드 여러장 출력. // 무엇이든지 넣으세요. 출력해드립니다.
	private void printArrayImg(String[] array) {
		for (String str : array) {
			System.out.println(str);
		}
	}

	private String[] getDeckImg() {
		DeckDto deck = bjDto.getDeck();
		String[] arrCardImg;
		int deckCount = deck.getDeckListCount();
		String strDeckCount = "00";
		if (deckCount > 99) {
			strDeckCount = "++";
		} else {
			strDeckCount = String.format("%02d", deckCount);
		}
		arrCardImg = getGoldCardImg(strDeckCount);

		return arrCardImg;
	}

	// 딜러의 카드 이미지 return;
	private String[] getDealerImg() {
		DealerDto dealerDto = bjDto.getDealer();
		if (dealerDto.getIsOpen()) {
			return getArrCardImg(dealerDto.getCardList());
		} else if (dealerDto.getCardList().size() == 2 && // 2장일때만
				!dealerDto.getIsOpen()) { // open이 아닐때
			return getDealerReadyImg(dealerDto.getCardList());
		} else {
			return getArrCardImg(dealerDto.getCardList());
		}
	}

	// 플레이어 카드 이미지 return;
	private String[] getPlayerImg() {
		PlayerDto playerDto = bjDto.getPlayer();
		return getArrCardImg(playerDto.getCardList());
	}

	// 딜러 2장 준비중인 이미지 만들기.
	private String[] getDealerReadyImg(List<Card> cardList) {
		String[] arrCardImg = { "", "", "" };
		// 첫번째 카드 이미지 가져오기
		if (cardList.size() != 0) {
			String[] cardImg = getCardImg(cardList.get(0));
			for (int i = 0; i < cardImg.length; i++) {
				arrCardImg[i] += cardImg[i];
			}
			// 두번째 카드 닫힌 이미지 가져오기
			String[] closeImg = getCloseCardImg();
			for (int i = 0; i < closeImg.length; i++) {
				arrCardImg[i] += closeImg[i];
			}
		}

		return arrCardImg;
	}

	private String[] getGoldCardImg(String str) {
		return getGoldCardImg(str, 0);
	}

	// 골드카드 만들기
	private String[] getGoldCardImg(String str, int color) {
		String[] cardImg = new String[3];
		String tempHead = "";
		String tempBody = "";
		String tempFoot = "";
		String tempSide = "";

		tempHead = ViewColor.YELLOW;
		tempHead += "┌──┐";
		tempHead += ViewColor.END;
		cardImg[0] = tempHead;

		tempSide = ViewColor.YELLOW;
		tempSide += "│";
		tempSide += ViewColor.END;

		tempBody = tempSide;
		if (color == 1) {
			tempBody += ViewColor.YELLOW;
		} else if (color == 2) {
			tempBody += ViewColor.RED;
		} else {
			tempBody += ViewColor.GREEN;
		}
		tempBody += str;
		tempBody += ViewColor.END;
		tempBody += tempSide;
		cardImg[1] = tempBody;

		tempFoot = ViewColor.YELLOW;
		tempFoot += "└──┘";
		tempFoot += ViewColor.END;
		cardImg[2] = tempFoot;

		return cardImg;
	}

	// 이니셜 밖힌 뒷면(골드카드)
	private String[] getCloseCardImg() {
		return getGoldCardImg("NY");
	}

	// 일반 카드 이미지. + 색보정
	private String[] getCardImg(Card card) {
		String suit = card.getSuit();
		String cardNum = card.getNum();
		String[] cardImg = new String[3];
		cardImg[0] = "┌──┐";
		cardImg[2] = "└──┘";

		String tempCardImg = "";
		if (suit.equalsIgnoreCase(CardSuit.SPADE)) {
			tempCardImg = ViewSuit.SPADE + cardNum;
		} else if (suit.equalsIgnoreCase(CardSuit.DIAMOND)) {
			tempCardImg = ViewColor.RED;
			tempCardImg += ViewSuit.DIAMOND + cardNum;
			tempCardImg += ViewColor.END;
		} else if (suit.equalsIgnoreCase(CardSuit.HART)) {
			tempCardImg = ViewColor.RED;
			tempCardImg += ViewSuit.HART + cardNum;
			tempCardImg += ViewColor.END;
		} else if (suit.equalsIgnoreCase(CardSuit.CLOVER)) {
			tempCardImg = ViewSuit.CLOVER + cardNum;
		}
		cardImg[1] = "│" + tempCardImg + "│";

		return cardImg;
	}

	// 일반적인 카드 여러장의 이미지
	// (딜러의 일반적인 카드)
	// (플레이어의 일반적인 카드)
	private String[] getArrCardImg(List<Card> cardList) {
		String[] arrCardImg = { "", "", "" };
		for (Card card : cardList) {
			String[] cardImg = getCardImg(card);
			cardImgInArrCardImg(arrCardImg, cardImg);
		}
		return arrCardImg;
	}

	// 카드 여러장 이미지에, 카드 이미지 집어넣기
	private void cardImgInArrCardImg(String[] arrCardImg, String[] cardImg) {
		for (int i = 0; i < cardImg.length; i++) {
			arrCardImg[i] += cardImg[i];
		}
	}

}