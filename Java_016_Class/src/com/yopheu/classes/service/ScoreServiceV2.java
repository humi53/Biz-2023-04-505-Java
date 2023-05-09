package com.yopheu.classes.service;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.classes.models.ScoreDto;

public class ScoreServiceV2 {
	private int makeRanScore() {
		return (int)(Math.random() * 50) + 51;
	}
	
	public void makeScore(List<ScoreDto> scdList) {
		for(int i = 0; i < 10; i++) {
			ScoreDto dto = new ScoreDto();
			dto.setStNum(String.format("%04d", i+1));
			dto.setScKor(makeRanScore());
			dto.setScEng(makeRanScore());
			dto.setScMath(makeRanScore());
			scdList.add(dto);
		}
	}
	List<ScoreDto> scdList;
	public List<ScoreDto> makeScore() {
		this.scdList = new ArrayList<>();
		makeScore(this.scdList);
		return this.scdList;
	}
	
	public void printList(List<ScoreDto> scdList) {
		for(int i = 0; i < scdList.size(); i++) {
//			System.out.println(scdList.toString());
		}
	}
}
