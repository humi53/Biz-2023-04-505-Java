package com.yopheu.balckjack.models;

import java.util.Arrays;

public class FinalTestService {
	public static final String[] arrMy;
	static {
		String[] arrMyd = {"1","2","3"};
		arrMy = Arrays.copyOf(arrMyd, arrMyd.length);
	}
}
