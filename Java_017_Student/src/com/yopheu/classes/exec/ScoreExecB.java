package com.yopheu.classes.exec;

import com.yopheu.classes.service.ScoreService;
import com.yopheu.classes.service.impl.ScoreServiceImplV2;

public class ScoreExecB {
	public static void main(String[] args) {
		ScoreService scService = new ScoreServiceImplV2();
		scService.loadScore();
		scService.printScore();
	}
}
