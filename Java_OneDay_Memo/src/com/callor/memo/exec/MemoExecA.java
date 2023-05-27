package com.callor.memo.exec;

import java.util.Scanner;

import com.callor.memo.service.Service;
import com.callor.memo.service.impl.ServiceImpl;

public class MemoExecA {
	public static void main(String[] args) {
		Service service = new ServiceImpl();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			service.printSelectAll();
			System.out.println(" 작성자이름 검색 : names , 번호검색 : ids");
			System.out.println("신규 : n, 삭제 : d, 수정 : u");
			System.out.println(" 메모내용보기 : (숫자)  종료 : QUIT");
			System.out.println("-".repeat(60));
			System.out.print(" >> ");
			String str = scan.nextLine();
			if(str.equalsIgnoreCase("QUIT")) {
				System.out.println("종료합니다.");
				break;
			}else if(str.equalsIgnoreCase("n")) {
				service.insertMemo();
			}else if(str.equalsIgnoreCase("d")) {
				service.deleteMemo();
			}else if(str.equalsIgnoreCase("u")) {
				service.updateMemo();
			}else if(str.equals("names")) {
				service.findByWriter();
			}else if(str.equals("ids")) {
				service.findBySeq();
			}else {
				try {
					int seq = Integer.valueOf(str);
					service.printContent(seq);
				} catch (Exception e) {
					System.out.println("없는 명령어 입니다.");
					continue;
				}
			}
		}
		
		
		// 메모 전체리스트 보기
		// 메모 새롭게 입력
		// 메모 수정하기
		// 메모 삭제
		// 메모 작성자로 검색
		// 메모 검색
		// 메모 내용 보기
		
		// 1. 전체리스트를 보여준다
		// 신규 n, 메모내용보기 번호, 작성자로 검색 names , 검색 ids, 종료 QUIT
		
	}
}
