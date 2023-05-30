package com.callor.shop.models;

public class ProductDto {
	public String pCode;//	VARCHAR2(13)
	public String pName;//	nVARCHAR2(50)
	public String pItem;//	VARCHAR2(10)
	public int pIPrice;//	NUMBER
	public int pOPrice;//	NUMBER
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(String pCode, String pName, String pItem, int pIPrice, int pOPrice) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pItem = pItem;
		this.pIPrice = pIPrice;
		this.pOPrice = pOPrice;
	}
	@Override
	public String toString() {
		return "ProductDto [pCode=" + pCode + ", pName=" + pName + ", pItem=" + pItem + ", pIPrice=" + pIPrice
				+ ", pOPrice=" + pOPrice + "]";
	}

	
}
