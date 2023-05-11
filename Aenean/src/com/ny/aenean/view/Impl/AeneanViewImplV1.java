package com.ny.aenean.view.Impl;

import java.util.List;

import com.ny.aenean.cardconfig.CardConfig;
import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.models.Card;
import com.ny.aenean.models.DealerDto;
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
		
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		
	}
	
	// 카드 여러장 출력. // 무엇이든지 넣으세요. 출력해드립니다.
	private void printArrayImg(String[] array) {
		for(String str : array) {
			System.out.println(str);
		}
	}
	
	// 딜러의 카드 이미지 출력
	private void printDealer() {
		DealerDto dealerDto = bjDto.getDealer();
		if(dealerDto.getIsOpen()) {
			// 일반적일때
		}else {
			printDealerReady(dealerDto);	// 2장, 준비중일때
		}
	}
	
	// 딜러 2장일때 준비중인 이미지 출력.
	private void printDealerReady(DealerDto dealerDto) {
		printArrayImg(getDealerReadyImg(dealerDto.getCardList()));
	}
	
	// 딜러 2장 준비중인 이미지 만들기.
	private String[] getDealerReadyImg(List<Card> cardList) {
		String[] arrCardImg = {"","",""};
		// 첫번째 카드 이미지 가져오기
		String[] cardImg = getCardImg(cardList.get(0));
		for(int i = 0; i < cardImg.length; i++) {
			arrCardImg[i] += cardImg[i];
		}
		// 두번째 카드 닫힌 이미지 가져오기
		String[] closeImg = getCloseCardImg();
		for(int i = 0; i < closeImg.length; i++) {
			arrCardImg[i] += closeImg[i];
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
	public String[] getCloseCardImg() {
		return getGoldCardImg("NY");
	}
	
	// 일반 카드 이미지. + 색보정
	public String[] getCardImg(Card card){
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
	
	// 일반적인 카드 여러장의 이미지 (출력직전)
	public String[] getArrCardImg(List<Card> cardList) {
		String[] arrCardImg = {"","",""};
		for(Card card : cardList) {
			String[] cardImg = getCardImg(card);
			for(int i = 0; i < cardImg.length; i++) {
				arrCardImg[i] += cardImg[i];
			}
		}
		return arrCardImg;
	}


}
