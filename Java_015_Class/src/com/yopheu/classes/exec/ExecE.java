package com.yopheu.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.classes.models.AnimalDto;

public class ExecE {
	public static void main(String[] args) {
		List<AnimalDto> animalList = new ArrayList<>();
		animalList.add(new AnimalDto("럭키", "허스키", 5));
		animalList.add(new AnimalDto("나비", "버밀라", 3));
		animalList.add(new AnimalDto("몽", "스피츠", 7));
		
		System.out.println(animalList.toString());
	}
}
