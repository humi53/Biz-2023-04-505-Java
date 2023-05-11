package com.ny.aenean.view;

import com.ny.aenean.models.BlackJackDto;

public interface AeneanView {
	public void setGameDeck(BlackJackDto bjDto);
	public void paint();
	public void repaint();
}
