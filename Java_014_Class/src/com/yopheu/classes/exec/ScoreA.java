package com.yopheu.classes.exec;

import com.yopheu.classes.models.ScoreDto;

public class ScoreA {
	public static void main(String[] args) {
		ScoreDto scoreDto = new ScoreDto();
		scoreDto.setStNum("0001");
		scoreDto.setScKor(80);
		scoreDto.setScMath(77);
		scoreDto.setScMusic(92);
		scoreDto.setScArt(80);
		System.out.println(scoreDto.toString());
	}
}
