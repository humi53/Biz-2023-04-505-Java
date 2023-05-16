package com.ny.aenean.cardconfig;

public class InputConfig {
	public class HitStay{
		public static final int HIT = 0;
		public static final int STAY = 1;
		
	}
	public class IsBust{
		public static final boolean BUST = true;
		public static final boolean NOTBUST = false; 
	}
	
	public class Score17IsOver{
		public static final boolean OVER = true;
		public static final boolean NOTOVER = false; 
	}
	
	public class GameState{
		public static final int MAIN = 0;	// 메인화면
		public static final int EXIT = 1;	// 종료화면
		
		
		public static final int GAMEREADY = 11;		// 카드를 받기전 대기 상태 (덱만있고 테이블이 비어있는 상태)
		public static final int WINNERCHECK = 12;	// 승자를 확인하는 상태
		public static final int BETTING = 13;		// 베팅을 하고 있는 상태 상태
		public static final int GAMESTAND = 14;		// 승자확인 후 다음게임 여부를 대기상태
		public static final int WINNERPLAERY = 15;	// 결과 : 플레이어 승리
		public static final int WINNERDEALER = 16;	// 결과 : 딜러 승리
		public static final int GAMEDEALING = 17;	// 초반 2장씩 나눠주고 있는 상태. (V1 : 구버전 명칭)
		public static final int GAMEPUSH = 18;		// 결과 : 무승부
		public static final int DISTRIBUTE = 19;	// 초반 2장씩 나눠주고 있는 상태. (새 명칭)
		
		public static final int PLAYERPROMPT = 51;		// 플레이어의 HitStay를 대기
		public static final int PLAYERHIT = 52;		// 플레이어어가 HIT를 고른 상태
		public static final int PLAYERDEAL = 53;	// 플레이어어가 카드를 받은 상태
		public static final int PLAYERSTAY = 54;	// 플레이어어가 Stay를 고른 상태
		public static final int PLAYERCALC = 55;	// 플레이어어 점수를 확인하는 상태
		public static final int PLAYERISBUST = 56;	// 플레이어가 BUST인지 확인하는 상태 
		public static final int PLAYERBLACKJACK = 57;	// 플레이어가 블랙잭
		
		public static final int DEALERREADY = 71;	// 딜러가 대기상태
		public static final int DEALEROPEN = 72;	// 딜러가 2번째 카드를 오픈한 상태
		public static final int DEALERDEAL = 73;	// 딜러가 카드를 받은 상태 
		public static final int DEALERCALC = 74;	// 딜러 점수를 확인하는 상태
		public static final int DEALER17OVER = 75;	// 딜러가 17점에 도달했는지 확인		
		public static final int DEALERISBUST = 76;	// 딜러가 BUST인지 확인하는 상태
	}
}
