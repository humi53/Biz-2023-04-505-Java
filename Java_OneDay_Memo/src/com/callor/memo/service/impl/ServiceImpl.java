package com.callor.memo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.memo.config.DBConnection;
import com.callor.memo.mapper.MemoDao;
import com.callor.memo.models.MemoDto;
import com.callor.memo.service.Service;

public class ServiceImpl implements Service{
	protected final MemoDao memoDao;
	Scanner scan;
	public ServiceImpl() {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		memoDao = sqlSession.getMapper(MemoDao.class);
		scan = new Scanner(System.in);
	}
	// 메모 전체리스트 보기
	@Override
	public void printSelectAll() {
		List<MemoDto> memoList = memoDao.selectAll();
		System.out.println("=".repeat(60));
		System.out.println(" 메모 입니다. 메모 메모. (전체리스트) ");
		printMemoList(memoList);
	}
	protected void printMemo(MemoDto dto) {
		System.out.println("=".repeat(60));
		System.out.println("일련번호\t제목\t작성자\t작성일자\t");
		System.out.println("-".repeat(60));
		System.out.printf("%d\t", dto.m_seq);
		System.out.printf("%s\t", dto.m_subject);
		System.out.printf("%s\t", dto.m_writer);
		System.out.printf("%s\t", dto.m_date);
		System.out.println();
		System.out.println("=".repeat(60));
	}
	protected void printMemoList(List<MemoDto> memoList) {
		
		System.out.println("=".repeat(60));
		System.out.println("일련번호\t제목\t작성자\t작성일자\t");
		System.out.println("-".repeat(60));
		for(MemoDto dto : memoList) {
			System.out.printf("%d\t", dto.m_seq);
			System.out.printf("%s\t", dto.m_subject);
			System.out.printf("%s\t", dto.m_writer);
			System.out.printf("%s\t", dto.m_date);
			System.out.println();
		}
		System.out.println("=".repeat(60));
	}
	// 메모 새롭게 입력
	@Override
	public void insertMemo() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat today = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = today.format(date);
		
		//m_seq,m_writer,m_date,m_subject,m_content
		System.out.print("작성자 >> ");
		String m_writer = scan.nextLine();
		
		System.out.print("제목 >> ");
		String m_subject = scan.nextLine();
		
		System.out.print("내용 >> ");
		String m_content = scan.nextLine();
		
		MemoDto memoDto = new MemoDto();
		memoDto.m_writer = m_writer;
		memoDto.m_date = todayString;
		memoDto.m_subject = m_subject;
		memoDto.m_content = m_content;
		int result = memoDao.insert(memoDto);
		if(result < 0) {
			System.out.println("err : 입력이 실패하였습니다. enter키를 누르세요");
		}else {
			System.out.println("입력이 성공하였습니다. enter키를 누르세요");
		}
		scan.nextLine();
	}
	// 메모 수정하기
	@Override
	public void updateMemo() {
		System.out.println("변경할 번호를 입력하세요.");
		System.out.print(" >> ");
		String s_id = scan.nextLine();
		int m_id = 0;
		try {
			m_id = Integer.valueOf(s_id);
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		MemoDto dto = memoDao.findById(m_id);
		if(dto == null) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.printf("%d를 수정합니다.", dto.m_seq);
		System.out.print("작성자 >> ");
		String m_writer = scan.nextLine();
		if (m_writer.equals("")) m_writer = dto.m_writer;
		
		System.out.print("제목 >> ");
		String m_subject = scan.nextLine();
		if (m_subject.equals("")) m_subject = dto.m_subject;
		
		System.out.print("내용 >> ");
		String m_content = scan.nextLine();
		if (m_content.equals("")) m_content = dto.m_content;
		
		dto.m_writer = m_writer;
		dto.m_subject = m_subject;
		dto.m_content = m_content;
		
		int result = memoDao.update(dto);
		if(result < 0) {
			System.out.println("err : 업데이트 실패하였습니다.");
		}else {
			System.out.println("업데이트 완료하였습니다.");
		}
		
	}
	// 메모 삭제
	@Override
	public void deleteMemo() {
		System.out.print("삭제할 번호 >> ");
		String s_id = scan.nextLine();
		int m_id = 0;
		try {
			m_id = Integer.valueOf(s_id);
			System.out.print("진짜 삭제 하시겠습니까? (YES/NO) >> ");
			s_id = scan.nextLine();
			if(!s_id.equalsIgnoreCase("YES")) {
				return;
			}
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		int result = memoDao.delete(m_id);
		if(result < 0 ) {
			System.out.println("삭제 실패하였습니다.");
		}else {
			System.out.printf("%d가 삭제 되었습니다.\n", m_id);
		}
	}
	// 메모 작성자로 검색
	@Override
	public void findByWriter() {
		System.out.print("탐색할 작성자명 >> ");
		String m_writer = scan.nextLine();
		
		List<MemoDto> memoList = memoDao.findByWriter(m_writer);
		if(memoList.isEmpty()) {
			System.out.println("=".repeat(60));
			System.out.printf(" '%s' 의 검색결과 입니다.(%d건)\n ", m_writer, memoList.size());
			printMemoList(memoList);
		}else {
			System.out.println("검색결과가 없습니다.");
		}
		System.out.println("넘어가려면 enter를 누르세요.");
		scan.nextLine();
		
	}
	// 메모 시퀀스로 검색
	@Override
	public void findBySeq() {
		System.out.print("탐색할 번호 >> ");
		String s_id = scan.nextLine();
		int m_id = 0;
		try {
			m_id = Integer.valueOf(s_id);
		} catch (Exception e) {
			System.out.println("검색 시도조차 실패.");
			return;
		}
		
		MemoDto memoDto = memoDao.findById(m_id);
		if(memoDto == null) {
			System.out.println("=".repeat(60));
			System.out.printf(" 번호 '%d' 의 검색결과 입니다.\n ", m_id);
			printMemo(memoDto);
		}else {
			System.out.println("검색결과가 없습니다.");
		}
		System.out.println("넘어가려면 enter를 누르세요.");
		scan.nextLine();
	}
	// 메모 내용 보기
	@Override
	public void printContent(int seq) {
		
		MemoDto memoDto = memoDao.findById(seq);
		if(memoDto == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}else {
			System.out.println("=".repeat(60));
			System.out.printf(" 일련번호 : %d \n", memoDto.m_seq);
			System.out.printf(" 제목 : %s \n", memoDto.m_subject);
			System.out.printf(" 작성자 : %s \n", memoDto.m_writer);
			System.out.printf(" 작성일자 : %s \n", memoDto.m_date);
			System.out.println("-".repeat(60));
			System.out.printf(" 내용 : %s \n", memoDto.m_content);
			System.out.println("=".repeat(60));
			System.out.println("넘어가려면 enter를 누르세요.");
			scan.nextLine();
			
		}
	}
}
