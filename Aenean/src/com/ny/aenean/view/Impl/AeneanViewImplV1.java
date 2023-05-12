package com.ny.aenean.view.Impl;

import java.util.List;

import com.ny.aenean.cardconfig.CardConfig;
import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.models.Card;
import com.ny.aenean.models.DealerDto;
import com.ny.aenean.models.DeckDto;
import com.ny.aenean.models.PlayerDto;
import com.ny.aenean.view.AeneanView;

public class AeneanViewImplV1 implements AeneanView{
	BlackJackDto bjDto;
	
	@Override
	public void setGameDeck(BlackJackDto bjDto) {
		this.bjDto = bjDto;
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub
		printGamePlaying();
		
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		
	}
	
	// 진행중인 게임화면 출력.
	private void printGamePlaying() {
		String[] firImg = {"","",""};
		String[] secImg = {"","",""};
		
		//출력 데이터 셋팅 및 로딩
		// 카드 첫줄...
		setMoreImg(firImg,makeNameImg("Dealer")); // 딜러라는 표시와 공백
		setMoreImg(firImg, getDealerImg());	// 딜러카드 이미지
		setMoreImg(firImg, makeOneTab(6));
		setMoreImg(firImg, getDeckImg());
		// 카드 두번째줄...
		setMoreImg(secImg, makeNameImg("Player")); // 플레이어라는 표시와 공백
		setMoreImg(secImg, getPlayerImg());	// 플레이어 카드 이미지
		// 게임 타이틀 
		
		
		
		
		// 카드 출력
		printArrayImg(firImg);
		
		printArrayImg(secImg);
		
		
		//테이블 끝 표현
		System.out.println("─".repeat(90));
		//-------------------
		
	}
	
	// 원하는 viewImg 에 추가 Img 붙이기
	private void setMoreImg(String[] sViewImg, String[] moreImg) {
		for(int i = 0 ; i < sViewImg.length; i++) {
			sViewImg[i] += moreImg[i];
		}
	}
	
	// 이름 이미지 만들기 return
	private String[] makeNameImg(String name) {
		String[] sVeiwImg = {"","",""};
		sVeiwImg[0] += "\t\t ";
		sVeiwImg[1] += "\t" + name + " : ";
		sVeiwImg[2] += "\t\t ";
		return sVeiwImg;
	}
	
	// Tab 이미지 만들기 return
	private String[] makeOneTab(int num) {
		String[] sVeiwImg = {"","",""};
		for(int i = 0; i < num; i++) {
			sVeiwImg[0] += "\t";
			sVeiwImg[1] += "\t";
			sVeiwImg[2] += "\t";
		}
		return sVeiwImg;
	}
	
	
	// 카드 여러장 출력. // 무엇이든지 넣으세요. 출력해드립니다.
	private void printArrayImg(String[] array) {
		for(String str : array) {
			System.out.println(str);
		}
	}
	
	
	private String[] getDeckImg() {
		DeckDto deck = bjDto.getDeck();
		String[] arrCardImg;
		int deckCount = deck.getDeckListCount();
		String strDeckCount = "00";
		if(deckCount > 99) {
			strDeckCount = "++";
		}else {
			strDeckCount = String.format("%02d", deckCount);
		}
		arrCardImg = getGoldCardImg(strDeckCount);
		
		return arrCardImg;
	}
	
	// 딜러의 카드 이미지 return;
	private String[] getDealerImg() {
		DealerDto dealerDto = bjDto.getDealer();
		if(dealerDto.getIsOpen()) {
			return getArrCardImg(dealerDto.getCardList());
		}else {
			return getDealerReadyImg(dealerDto.getCardList());	// 2장, 준비중일때
		}
	}
	
	// 플레이어 카드 이미지 return;
	private String[] getPlayerImg() {
		PlayerDto playerDto = bjDto.getPlayer();
		return getArrCardImg(playerDto.getCardList());
	}
	
	// 딜러 2장 준비중인 이미지 만들기.
	private String[] getDealerReadyImg(List<Card> cardList) {
		String[] arrCardImg = {"","",""};
		// 첫번째 카드 이미지 가져오기
		if(cardList.size() != 0) {
			String[] cardImg = getCardImg(cardList.get(0));
			for(int i = 0; i < cardImg.length; i++) {
				arrCardImg[i] += cardImg[i];
			}
			// 두번째 카드 닫힌 이미지 가져오기
			String[] closeImg = getCloseCardImg();
			for(int i = 0; i < closeImg.length; i++) {
				arrCardImg[i] += closeImg[i];
			}
		}
		
		return arrCardImg;
	}
	
	// 골드카드 만들기
	private String[] getGoldCardImg(String str) {
		String[] cardImg = new String[3];
		String tempHead = "";
		String tempBody = "";
		String tempFoot = "";
		String tempSide = "";
		
		tempHead = CardConfig.ViewColor.YELLOW;
		tempHead += "┌──┐";
		tempHead += CardConfig.ViewColor.END;
		cardImg[0] = tempHead;
		
		tempSide = CardConfig.ViewColor.YELLOW;
		tempSide += "│";
		tempSide += CardConfig.ViewColor.END;
		
		tempBody = tempSide;
		tempBody += CardConfig.ViewColor.GREEN;
		tempBody += str;
		tempBody += CardConfig.ViewColor.END;
		tempBody += tempSide;
		cardImg[1] = tempBody;
		
		tempFoot = CardConfig.ViewColor.YELLOW;
		tempFoot += "└──┘";
		tempFoot += CardConfig.ViewColor.END;
		cardImg[2] = tempFoot;
		
		return cardImg;
	}
	
	// 이니셜 밖힌 뒷면(골드카드)
	private String[] getCloseCardImg() {
		return getGoldCardImg("NY");
	}
	
	// 일반 카드 이미지. + 색보정
	private String[] getCardImg(Card card){
		String suit = card.getSuit();
		String cardNum = card.getNum();
		String[] cardImg = new String[3];
		cardImg[0] = "┌──┐";
		cardImg[2] = "└──┘";
		
		String tempCardImg = "";
		if( suit.equalsIgnoreCase(CardConfig.CardSuit.SPADE) ) {
			tempCardImg = CardConfig.ViewSuit.SPADE + cardNum;
		}else if( suit.equalsIgnoreCase(CardConfig.CardSuit.DIAMOND) ) {
			tempCardImg = CardConfig.ViewColor.RED;
			tempCardImg += CardConfig.ViewSuit.DIAMOND + cardNum;
			tempCardImg += CardConfig.ViewColor.END;
		}else if( suit.equalsIgnoreCase(CardConfig.CardSuit.HART) ) {
			tempCardImg = CardConfig.ViewColor.RED;
			tempCardImg += CardConfig.ViewSuit.HART + cardNum;
			tempCardImg += CardConfig.ViewColor.END;
		}else if( suit.equalsIgnoreCase(CardConfig.CardSuit.CLOVER) ) {
			tempCardImg = CardConfig.ViewSuit.CLOVER + cardNum;
		}
		cardImg[1] = "│" + tempCardImg +"│";
		
		return cardImg;
	}
	
	// 일반적인 카드 여러장의 이미지 
	// (딜러의 일반적인 카드)
	// (플레이어의 일반적인 카드)
	private String[] getArrCardImg(List<Card> cardList) {
		String[] arrCardImg = {"","",""};
		for(Card card : cardList) {
			String[] cardImg = getCardImg(card);
			cardImgInArrCardImg(arrCardImg, cardImg);
		}
		return arrCardImg;
	}
	
	// 카드 여러장 이미지에, 카드 이미지 집어넣기
	private void cardImgInArrCardImg(String[] arrCardImg, String[] cardImg) {
		for(int i = 0; i < cardImg.length; i++) {
			arrCardImg[i] += cardImg[i];
		}
	}
	
}
