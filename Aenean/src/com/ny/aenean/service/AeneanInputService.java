package com.ny.aenean.service;

import com.ny.aenean.models.BlackJackDto;

public interface AeneanInputService {
	public int scanHitStay();
	public int scanPassMessage(int gameState);
	public int scanMainScreen();
	public int scanNumber(BlackJackDto bjDt);
}