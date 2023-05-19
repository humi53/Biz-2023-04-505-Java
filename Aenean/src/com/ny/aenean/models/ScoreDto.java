package com.ny.aenean.models;

public class ScoreDto {

	private int playerCash; // 플레이어의 가진 돈
	private int nowBet; // 기본 배팅 금액
	private int accWin; // 플레이어의 누적 금액
	private int mulBet; // 베팅 배수 ( 1~5 )

	public ScoreDto() {

		playerCash = 0;
		nowBet = 100;
		accWin = 0;
	}

	public int getPlayerCash() {
		return playerCash;
	}

	public void setPlayerCash(int playerCash) {
		this.playerCash = playerCash;
	}
	
	public void addPlayerCash(int playerCash) {
		this.playerCash += playerCash;
	}

	public int getNowBet() {
		return nowBet * mulBet;
	}

	public int getMul() {
		return mulBet;
	}

	public void setMul(int nowBet) {
		if (nowBet >= 1 && nowBet <= 5) {
			this.mulBet = nowBet;
		} else {
			mulBet = 1;
		}
	}

	public int getAccWin() {
		return accWin;
	}

	public void addAccWin(int accWin) {
		this.accWin += accWin;
	}

	@Override
	public String toString() {
		return "ScoreDto [playerCash=" + playerCash + ", nowBet=" + nowBet + ", accWin=" + accWin + "]";
	}

}