package com.ny.aenean.service.impl;

import com.ny.aenean.models.BlackJackDto;
import com.ny.aenean.service.AeneanInputService;
import com.ny.aenean.service.AeneanService;
import com.ny.aenean.view.AeneanView;
import com.ny.aenean.view.Impl.AeneanViewImplV1;

public class AeneanServiceImplV1 implements AeneanService{
	
	AeneanView view;
	BlackJackDto bjDto;
	
	public AeneanServiceImplV1() {
		setView(new AeneanViewImplV1());
		setBlackJackDto(new BlackJackDto());
		view.setGameDeck(bjDto);
	}

	private void ViewPaint() {
		view.paint();
	}
	
	@Override
	public void setView(AeneanView view) {
		this.view = view;
	}

	@Override
	public void setInputService(AeneanInputService ipService) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		ViewPaint();
	}

	@Override
	public void setBlackJackDto(BlackJackDto bjDto) {
		this.bjDto = bjDto;
	}

}
