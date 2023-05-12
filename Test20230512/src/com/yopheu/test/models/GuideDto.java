package com.yopheu.test.models;

public class GuideDto {
	private String guId;
	private String guName;
	private String guNum;
	private String guGuide;
	
	public GuideDto(String guId, String guName, String guNum, String guGuide) {
		super();
		this.guId = guId;
		this.guName = guName;
		this.guNum = guNum;
		this.guGuide = guGuide;
	}
	public GuideDto() {
		
	}
	public String getGuId() {
		return guId;
	}
	public void setGuId(String guId) {
		this.guId = guId;
	}
	public String getGuName() {
		return guName;
	}
	public void setGuName(String guName) {
		this.guName = guName;
	}
	public String getGuNum() {
		return guNum;
	}
	public void setGuNum(String guNum) {
		this.guNum = guNum;
	}
	public String getGuGuide() {
		return guGuide;
	}
	public void setGuGuide(String guGuide) {
		this.guGuide = guGuide;
	}
	@Override
	public String toString() {
		return "GuideDto [guId=" + guId + ", guName=" + guName + ", guNum=" + guNum + ", guGuide=" + guGuide + "]";
	}
	
	
}
