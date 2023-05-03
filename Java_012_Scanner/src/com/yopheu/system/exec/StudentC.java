package com.yopheu.system.exec;

import com.yopheu.scanner.service.StudentServiceV1;
import com.yopheu.scanner.service.StudentServiceV2;

public class StudentC {
	public static void main(String[] args) {
		StudentServiceV1 stService = new StudentServiceV1();
		stService.inputStudent();
		
	}
}
