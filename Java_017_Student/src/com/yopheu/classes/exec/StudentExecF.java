package com.yopheu.classes.exec;

import com.yopheu.classes.service.StudentService;
import com.yopheu.classes.service.impl.StudentServiceImplV4;

public class StudentExecF {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV4();
		stService.loadStudent();
		stService.printStudent();
		
		System.out.println(stService.getStudent("S0010"));
	}
}
