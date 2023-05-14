package com.ny.aenean.cardconfig;

public class CardConfig {
	public class ViewColor{
		public static final String YELLOW = "\u001B[33m";
		public static final String GREEN = "\u001B[32m";
		public static final String RED = "\u001B[31m";
		public static final String END = "\u001B[0m";
	}
	public class ViewSuit{
		public static final String SPADE = "♠";
		public static final String DIAMOND = "♦";
		public static final String HART = "♥";
		public static final String CLOVER = "♣";
	}
	
	public class CardSuit{
		public static final String SPADE = "S";
		public static final String DIAMOND = "D";
		public static final String HART = "H";
		public static final String CLOVER = "C";
	}
	
	public class CardNum{
		public static final String A = "A";
		public static final String T = "T";
		public static final String J = "J";
		public static final String Q = "Q";
		public static final String K = "K";
	}
	public class CardScore{
		public static final int A = 10;
		public static final int T = 10;
		public static final int J = 10;
		public static final int Q = 10;
		public static final int K = 10;
	}
}
