package com.callor.memo.models;

public class MemoDto {
	public int m_seq;//	NUMBER
	public String m_writer;//	nVARCHAR2(20)
	public String m_date;//	VARCHAR2(10)
	public String m_subject;//	nVARCHAR2(20)
	public String m_content;//	nVARCHAR2(400)
	public MemoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemoDto(int m_seq, String m_writer, String m_date, String m_subject, String m_content) {
		super();
		this.m_seq = m_seq;
		this.m_writer = m_writer;
		this.m_date = m_date;
		this.m_subject = m_subject;
		this.m_content = m_content;
	}
	@Override
	public String toString() {
		return "MemoDto [m_seq=" + m_seq + ", m_writer=" + m_writer + ", m_date=" + m_date + ", m_subject=" + m_subject
				+ ", m_content=" + m_content + "]";
	}

}
