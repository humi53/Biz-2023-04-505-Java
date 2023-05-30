package com.callor.shop.mapper.sql;

public class ProductSQL {
	
	public static final String PRODUCT_INSERT =
			" INSERT INTO tbl_product(pCode, pName , pItem, pIPrice, pOPrice) "
			+ " VALUES(#{pCode}, #{pName} , #{pItem}, #{pIPrice}, #{pOPrice}) ";
	
	public static final String PRODUCT_UPDATE = 
			"UPDATE tbl_product "
			+ "SET pName = #{pName}, "
			+ "    pItem = #{pItem}, "
			+ "    pIPrice = #{pIPrice}, "
			+ "    pOPrice = #{pOPrice} "
			+ "    WHERE pCode = #{pCode} ";

}
