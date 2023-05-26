package com.yopheu.student.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yopheu.student.config.DBConnection;
import com.yopheu.student.mapper.StudentDao;
import com.yopheu.student.models.StudentDto;

public class DbExecA {
	public static void main(String[] args) {
		
		// SqlSessionFactory에게 DB 와 연결할 Session 요청하기
		// openSession()의 true : INSERT, UPDATE, DELETE 를 수행할때
		// 자동으로 COMMIT 명령을 실행하라
		// 이 옵션을 사용하지 않으면 Java 에서 추가, 수정, 삭제한 데이터가
		// SQL Developer 등에서 확인이 안될수 있다.
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		
		// StudentDao interface 구현한 DaoImplV1 과 같은 코드를
		// 생성하여 stDao 에 담아준다
		StudentDao stDao = sqlSession.getMapper(StudentDao.class);
		
		List<StudentDto> stdList = stDao.selectAll();
		System.out.println(stdList.toString());
		
	}
}
