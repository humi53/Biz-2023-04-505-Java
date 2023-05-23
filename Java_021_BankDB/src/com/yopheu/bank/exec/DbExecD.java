package com.yopheu.bank.exec;

import com.yopheu.bank.service.BankService;

public class DbExecD {
	public static void main(String[] args) {
		BankService bankService = new BankService();
		bankService.printBuyerList();
		bankService.findByBuyer();
	}
}
