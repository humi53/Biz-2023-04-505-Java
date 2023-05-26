package com.callor.memo.mapper.sql;

public class MemoSQL {
	//m_seq,m_writer,m_date,m_subject,m_content
	public static final String MEMO_INSERT 
		= " INSERT INTO "
			+ " tbl_memo(m_seq, m_writer, m_date, m_subject, m_content) "
			+ " VALUES(seq_memo.nextval, #{m_writer}, #{m_date}, #{m_subject}, #{m_content}) ";
	
	public static final String MEMO_UPDATE 
		= " UPDATE tbl_memo "
				+ " SET m_writer = #{m_content}, "
				+ " m_date = #{m_date}, "
				+ " m_subject = #{m_subject}, "
				+ " m_content = #{m_content} "
				+ " WHERE m_seq = #{m_seq} ";
}
