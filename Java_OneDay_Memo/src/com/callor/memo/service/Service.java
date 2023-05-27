package com.callor.memo.service;

public interface Service {
	public void printSelectAll();	// 전체 리스트 출력.
	
	public void insertMemo();	// 메모 새롭게 입력
	
	public void updateMemo();	// 메모 수정하기

	public void deleteMemo();	// 메모 삭제

	public void findByWriter();	// 메모 작성자로 검색

	public void findBySeq();	// 메모 시퀀스로 검색

	public void printContent(int seq);	// 메모 내용 보기
}
