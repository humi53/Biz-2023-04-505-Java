package com.yopheu.classes.exec;

import com.yopheu.classes.models.StudentDto;
import com.yopheu.classes.service.impl.StudentServiceImplV1;

public class StudentD {
	public static void main(String[] args) {
		StudentServiceImplV1 stdService = new StudentServiceImplV1();
		stdService.localStudent();
		stdService.printStudent();
		
	}
}
