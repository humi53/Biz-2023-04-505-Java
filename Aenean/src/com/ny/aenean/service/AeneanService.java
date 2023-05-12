package com.ny.aenean.service;

import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.view.AeneanView;

public interface AeneanService {
	public void setView(AeneanView view);
	public void setBlackJackDto(BlackJackDto bjDto);
	public void setInputService(AeneanInputService ipService);
	public void start();
}
