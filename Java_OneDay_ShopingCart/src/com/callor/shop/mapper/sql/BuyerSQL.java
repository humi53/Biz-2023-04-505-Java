package com.callor.shop.mapper.sql;

public class BuyerSQL {
	//buId, buName, buTel, buAddr
	public static final String BUYER_INSERT =
			" INSERT INTO tbl_buyer(buId, buName, buTel, buAddr) "
			+ " VALUES(#{buId}, #{buName}, #{buTel}, #{buAddr}) ";
	
	public static final String BUYER_UPDATE =
			" UPDATE tbl_buyer "
				+ " SET buName = #{buName}, "
				+ " buTel = #{buTel}, "
				+ " buAddr = #{buAddr} "
				+ " WHERE buId = #{buId} ";
}
