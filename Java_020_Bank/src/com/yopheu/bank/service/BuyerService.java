package com.yopheu.bank.service;

import java.io.PrintWriter;

import com.yopheu.bank.models.BuyerDto;

public interface BuyerService {
	public void loadBuyer();
	public void printBuyerList();
	public void printBuyerList(PrintWriter out);
	public BuyerDto getBuyer(String buId);
	
	public void inputBuyer();
}
