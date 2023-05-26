package com.callor.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.memo.mapper.sql.MemoSQL;
import com.callor.memo.models.MemoDto;

public interface MemoDao {
	//m_seq,m_writer,m_date,m_subject,m_content
	
	@Select(" SELECT * FROM tbl_memo ORDER BY m_seq ASC ")
	public List<MemoDto> selectAll();

	@Select(" SELECT * FROM tbl_memo WHERE m_seq = #{id} ORDER BY m_seq ASC ")
	public MemoDto findById(int id);
	
	@Select(" SELECT * FROM tbl_memo WHERE m_writer LIKE '%' || #{writer} || '%' ORDER BY m_seq ASC ")
	public List<MemoDto> findByWriter(String writer);

	@Insert(MemoSQL.MEMO_INSERT)
	public int insert(MemoDto dto);

	@Update(MemoSQL.MEMO_UPDATE)
	public int update(MemoDto dto);

	@Delete(" DELETE FROM tbl_memo WHERE m_seq = #{id} ")
	public int delete(int id);
}
