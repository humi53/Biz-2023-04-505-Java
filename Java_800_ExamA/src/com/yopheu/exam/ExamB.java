package com.yopheu.exam;

import com.yopheu.exam.service.GuideService;
import com.yopheu.exam.service.impl.GuideServiceImplV1;

public class ExamB {
	public static void main(String[] args) {
		GuideService guService = new GuideServiceImplV1();
		guService.loadGuide();
		guService.printGuide();
	}
}
