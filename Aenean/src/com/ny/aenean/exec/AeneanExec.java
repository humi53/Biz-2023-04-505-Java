package com.ny.aenean.exec;


import com.ny.aenean.service.AeneanService;
import com.ny.aenean.service.impl.AeneanServiceImplV1;
import com.ny.aenean.service.impl.AeneanServiceImplV2;

public class AeneanExec {
	public static void main(String[] args) {
		// 시작지점
//		AeneanViewImplV1 view = new AeneanViewImplV1();
		
//		BlackJackDto bjDto = new BlackJackDto();
//		bjDto.getDealer().deal(new Card("S","T"));
//		bjDto.getDealer().deal(new Card("D","A"));
//		bjDto.getPlayer().deal(new Card("S","A"));
//		bjDto.getPlayer().deal(new Card("D","K"));
//		view.setGameDeck(bjDto);
//		view.paint();
		
//		AeneanService anService = new AeneanServiceImplV1();
		AeneanService anService = new AeneanServiceImplV2();
		anService.start();
		
		

		
	}
}
