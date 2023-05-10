package com.yopheu.classes.exec;

import com.yopheu.classes.service.StudentService;
import com.yopheu.classes.service.impl.StudentServiceImplV2;
import com.yopheu.classes.service.impl.StudentServiceImplV3;

public class StudentExecD {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV2();
		stService.loadStudent();
		stService.printStudent();
		
	}
}
