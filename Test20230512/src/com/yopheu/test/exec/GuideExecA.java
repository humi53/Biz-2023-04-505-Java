package com.yopheu.test.exec;

import com.yopheu.test.service.GuideService;
import com.yopheu.test.service.impl.GuideServiceImplV1;

public class GuideExecA {
	public static void main(String[] args) {
		GuideService service = new GuideServiceImplV1();
		service.loadGuide();
		service.printGuideList();
	}
}
