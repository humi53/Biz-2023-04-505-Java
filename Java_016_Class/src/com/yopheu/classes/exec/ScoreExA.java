package com.yopheu.classes.exec;

import com.yopheu.classes.service.impl.ScoreServiceImplv3;

public class ScoreExA {
	public static void main(String[] args) {
		ScoreServiceImplv3 scoreService = new ScoreServiceImplv3();
		scoreService.makeScore();
		scoreService.printScore();
	}
}
