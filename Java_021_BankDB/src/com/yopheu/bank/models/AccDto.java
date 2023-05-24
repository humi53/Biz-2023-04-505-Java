package com.yopheu.bank.models;

/*
 * 데이터 클래스는
 * 각 method 간의 데이터를 묶음으로 담아 전달하기 위한 목적의 객체
 */
public class AccDto {
	public String acNum; //	VARCHAR2(10)
	public String acDiv; //	VARCHAR2(1)
	public String acBuid; //	VARCHAR2(5)
	public int acBalance; //	NUMBER

	// super, 기본생성자
	public AccDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// field 생성자, 임의 생성자
	public AccDto(String acNum, String acDiv, String acBuid, int acBalance) {
		super();
		this.acNum = acNum;
		this.acDiv = acDiv;
		this.acBuid = acBuid;
		this.acBalance = acBalance;
	}

	@Override
	public String toString() {
		return "AccDto [acNum=" + acNum + ", acDiv=" + acDiv + ", acBuid=" + acBuid + ", acBalance=" + acBalance + "]";
	}

}
