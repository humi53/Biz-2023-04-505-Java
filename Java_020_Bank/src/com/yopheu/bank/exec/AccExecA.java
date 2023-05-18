package com.yopheu.bank.exec;

import com.yopheu.bank.service.AccService;
import com.yopheu.bank.service.impl.AccServiceImplV1;
import com.yopheu.bank.service.impl.AccServiceImplV1A;

public class AccExecA {
	public static void main(String[] args) {
//		AccService accService = new AccServiceImplV1();
//		accService.accInit();
		
		AccService accService = new AccServiceImplV1A();
		accService.accInit();
	}
}
