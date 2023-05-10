package com.yopheu.classes.exec;

import com.yopheu.classes.service.ScoreService;
import com.yopheu.classes.service.impl.ScoreServiceImplV1;

public class ScoreExecA {
	public static void main(String[] args) {
		ScoreService scService = new ScoreServiceImplV1();
		scService.loadScore();
		scService.printScore();
	}
}
