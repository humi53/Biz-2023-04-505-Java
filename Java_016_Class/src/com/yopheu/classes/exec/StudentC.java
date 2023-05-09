package com.yopheu.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.yopheu.classes.models.StdData;
import com.yopheu.classes.models.StudentDto;

public class StudentC {
	public static void main(String[] args) {
		List<StudentDto> stdList = new ArrayList<>();

		for (int index = 0; index < StdData.STUDENT.length; index++) {
			StudentDto dto = new StudentDto();
			String[] student = StdData.STUDENT[index].split(",");
			dto.stNum = student[StdData.ST_NUM];
			dto.stName = student[StdData.ST_NAME];
			dto.stDept = student[StdData.ST_DEPT];
			dto.stGrade = Integer.valueOf(student[StdData.ST_GRADE]);
			dto.stTel = student[StdData.ST_TEL];
			dto.stAddress = student[StdData.ST_ADDRESS];
			stdList.add(dto);
		}

		System.out.println(stdList.toString());
	}
}
