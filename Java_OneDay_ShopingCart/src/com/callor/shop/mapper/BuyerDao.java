package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.mapper.sql.BuyerSQL;
import com.callor.shop.models.BuyerDto;

public interface BuyerDao {
	// 고객전체리스트
	@Select(" SELECT buId, buName, buTel, buAddr FROM tbl_buyer ORDER BY buId ASC ")
	public List<BuyerDto> selectAll();
	
	// 고객명으로 탐색
	@Select(" SELECT buId, buName, buTel, buAddr FROM tbl_buyer WHERE buName = #{buName} ORDER BY buId ASC ")
	public List<BuyerDto> findByName(String buName);
	
	// 고객ID로 탐색
	@Select(" SELECT buId, buName, buTel, buAddr FROM tbl_buyer WHERE buId = #{buId} ")
	public BuyerDto findById(String buId);
	
	// 고객등록
	@Insert(BuyerSQL.BUYER_INSERT)
	public int insert(BuyerDto dto);
	
	// 고객수정
	@Update(BuyerSQL.BUYER_UPDATE)
	public int update(BuyerDto dto);
	
	// 가장 높은 Code
	@Select(" SELECT MAX(buId) as buId FROM tbl_buyer ")
	public String getMaxBuId();
}
