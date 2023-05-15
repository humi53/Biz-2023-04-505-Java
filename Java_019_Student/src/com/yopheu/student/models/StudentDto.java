package com.yopheu.student.models;

public class StudentDto {
	
	public String stNum;
	public String stName;
	public String stDept;
	public int stGrade;
	public String stTel;
	
	
	/**
	 * 
	 * @param stNum
	 * @param stName
	 * @param stDept
	 * @param stGrade
	 * @param stTel
	 */
	public StudentDto(String stNum, String stName, String stDept, int stGrade, String stTel) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stDept = stDept;
		this.stGrade = stGrade;
		this.stTel = stTel;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentDto [stNum=" + stNum + ", stName=" + stName + ", stDept=" + stDept + ", stGrade=" + stGrade
				+ ", stTel=" + stTel + "]";
	}
	
	
}
