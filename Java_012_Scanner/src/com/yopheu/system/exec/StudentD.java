package com.yopheu.system.exec;

import com.yopheu.scanner.service.StudentServiceV2;

public class StudentD {
	public static void main(String[] args) {
		StudentServiceV2 stServiceV2 = new StudentServiceV2();
		stServiceV2.inputStudents();
		stServiceV2.printStudents();
	}
}
