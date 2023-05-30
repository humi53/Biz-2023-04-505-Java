package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.mapper.sql.ProductSQL;
import com.callor.shop.models.ProductDto;

public interface ProductDao {
	//pCode, pName , pItem, pIPrice, pOPrice
	// 상품전체리스트
	@Select(" SELECT pCode, pName , pItem, pIPrice, pOPrice FROM tbl_product ORDER BY pCode ASC")
	public List<ProductDto> selectAll();
	
	// 상품명으로 탐색
	@Select(" SELECT pCode, pName , pItem, pIPrice, pOPrice FROM tbl_product WHERE pName = #{pName} ORDER BY pCode ASC ")
	public List<ProductDto> findByName(String pName);
	
	// 상품code로 탐색
	@Select(" SELECT pCode, pName , pItem, pIPrice, pOPrice FROM tbl_product WHERE pCode = #{pCode} ")
	public ProductDto findByCode(String pCode);
	
	// 상품등록
	@Insert(ProductSQL.PRODUCT_INSERT)
	public int insert(ProductDto dto);
	
	// 상품수정
	@Update(ProductSQL.PRODUCT_UPDATE)
	public int update(ProductDto dto);
	
	// 가장 높은 Code
	@Select(" SELECT MAX(pCode) as pCode FROM tbl_product ")
	public String getMaxPCode();
}
