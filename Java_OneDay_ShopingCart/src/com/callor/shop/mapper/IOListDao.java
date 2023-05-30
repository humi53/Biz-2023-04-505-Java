package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.shop.models.IOListDto;

public interface IOListDao {
	// 전체판매 List
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice FROM tbl_iolist ORDER BY ioSEQ ASC ")
	public List<IOListDto> selectAll();
	
	// 판매내역
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice FROM tbl_iolist WHERE iopcode = #{iopcode} ORDER BY ioSEQ ASC ")
	public List<IOListDto> findByPCode(String ioPCode);
	
	// 판매등록
	@Insert(" INSERT INTO tbl_iolist(ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice) "
			+ "VALUES(seq_iolist.nextval, #{ioDate}, #{ioTime}, #{ioBuid}, #{ioPCode}, #{ioQuan}, #{ioPrice}) ")
	public int insert(IOListDto dto);
	
	// 고객별 판매 List
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice FROM tbl_iolist WHERE ioBuid = #{ioBuid} ORDER BY ioSEQ ASC ")
	public List<IOListDto> findByBuId(String ioBuId);
	
	// 기간별 판매 List
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice FROM tbl_iolist "
			+ " WHERE ioDate BETWEEN #{sioDate} AND #{eioDate} ")
	public List<IOListDto> findByDate(@Param("sioDate") String sioDate, @Param("eioDate") String eioDate);
	
	// 고객 및 기간별 판매 List
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice FROM tbl_iolist "
			+ " WHERE ioPCode = #{ioPCode} and ioDate BETWEEN #{fioDate} AND #{lioDate} ")
	public List<IOListDto> findByBuIdDate(@Param("ioPCode") String ioPCode, @Param("fioDate") String fioDate, @Param("lioDate")String lioDate);
}
