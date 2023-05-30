package com.callor.shop.models;

public class IOListDto {
	public long ioSEQ;//	NUMBER
	public String ioDate;//	VARCHAR2(10)
	public String ioTime;//	VARCHAR2(10)
	public String ioBuid;//	VARCHAR2(10)
	public String ioPCode;//	VARCHAR2(13)
	public int ioQuan;//	NUMBER
	public int ioPrice;//	NUMBER
	public IOListDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IOListDto(long ioSEQ, String ioDate, String ioTime, String ioBuid, String ioPCode, int ioQuan, int ioPrice) {
		super();
		this.ioSEQ = ioSEQ;
		this.ioDate = ioDate;
		this.ioTime = ioTime;
		this.ioBuid = ioBuid;
		this.ioPCode = ioPCode;
		this.ioQuan = ioQuan;
		this.ioPrice = ioPrice;
	}
	@Override
	public String toString() {
		return "IOListDto [ioSEQ=" + ioSEQ + ", ioDate=" + ioDate + ", ioTime=" + ioTime + ", ioBuid=" + ioBuid
				+ ", ioPCode=" + ioPCode + ", ioQuan=" + ioQuan + ", ioPrice=" + ioPrice + "]";
	}
	
}
