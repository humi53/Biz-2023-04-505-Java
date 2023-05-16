package com.yopheu.student.exec;

import com.yopheu.student.service.StudentService;
import com.yopheu.student.service.impl.StudentServiceImplV2;

public class StudentExecF {
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV2();
		stService.insertStudent();
		stService.loadStudent();
		stService.printStudent();
	}
}
