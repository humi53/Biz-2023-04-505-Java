package com.yopheu.classes.exec;

import java.util.List;

import com.yopheu.classes.models.ScoreDto;
import com.yopheu.classes.service.ScoreServiceV2;

public class ExecD {
	public static void main(String[] args) {
		ScoreServiceV2 scService = new ScoreServiceV2();
		List<ScoreDto> scdList = scService.makeScore();
		
		System.out.println(scdList.toString());
	}
}
