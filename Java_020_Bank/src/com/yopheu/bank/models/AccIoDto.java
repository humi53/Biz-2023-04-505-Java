package com.yopheu.bank.models;

/*
 * 거래내역 데이터 클래스
 * 계좌번호 : acNum
 * 거래일자 : aiDate
 * 거래시각 : aiTime
 * 거래구분 : aiDive
 * 입금 : aiInput
 * 출금 : aiOutput
 */
public class AccIoDto {
	
	public String acNum;
	public String aiDate;
	public String aiTime;
	public String aiDive;
	public int aiInput;
	public int aiOutput;
	
	public AccIoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccIoDto(String acNum, String aiDate, String aiTime, String aiDive, int aiInput, int aiOutput) {
		super();
		this.acNum = acNum;
		this.aiDate = aiDate;
		this.aiTime = aiTime;
		this.aiDive = aiDive;
		this.aiInput = aiInput;
		this.aiOutput = aiOutput;
	}
	
	@Override
	public String toString() {
		return "AccIoDto [acNum=" + acNum + ", aiDate=" + aiDate + ", aiTime=" + aiTime + ", aiDive=" + aiDive
				+ ", aiInput=" + aiInput + ", aiOutput=" + aiOutput + "]";
	}
	
}
