package com.yopheu.student.service;

import java.util.List;

import com.yopheu.student.models.StudentDto;

public interface StudentService {
	
	public void insertStudent();
	
	public void loadStudent();
	public void printStudent();
	
	public StudentDto getStudent(String stNum);
	public List<StudentDto> getStudentList();
}
