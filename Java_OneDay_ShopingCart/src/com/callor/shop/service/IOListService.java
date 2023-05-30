package com.callor.shop.service;

public interface IOListService {
	// 장바구니 상품담기
	public void insert();
	// 구매자별 장바구니 리스트 보기
	public void printFindBuId();
	// 장바구니 전체 리스트 보기
	public void printIOListAll();
	// 기간별 거래리스트
	public void printFindDate();
	// 상품별 거래리스트
	public void printFindProduct();
	// 고객+거래기간별
	public void printFindDateProduct();
}
