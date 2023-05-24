package com.yopheu.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yopheu.bank.config.DBConnection;
import com.yopheu.bank.config.DBContract;
import com.yopheu.bank.models.AccDto;
import com.yopheu.bank.service.AccService;

public class AccServiceImplV1 implements AccService{

	// DB 에 연결 session 구축하는 도구
	protected final Connection dbconn;
	
	public AccServiceImplV1() {
		// dbConn 도구를 이미 만들어둔 DBConnection 클래스 코드를
		// 사용하여 초기화 한다
		dbconn = DBConnection.getDBConn();
	}
	
//	public int db2Update(PreparedStatement pStr) throws SQLException {
//		int result = pStr.executeUpdate();
//		
//		return result;
//	}
	
	public List<AccDto> db2List(PreparedStatement pStr) throws SQLException {
		List<AccDto> accDtoList = new ArrayList<>();
		ResultSet result = pStr.executeQuery();
		while(result.next()) {
			accDtoList.add(result2Dto(result));
		}
		pStr.close();
		result.close();
		return accDtoList;
	}
	
	@Override
	public List<AccDto> selectAll() {
		
		String sql = " SELECT "
				+ " acnum, acdiv, acbuid, acbalance "
				+ " FROM tbl_acc "
				+ " ORDER BY acnum ";
		try {
			PreparedStatement pStr = dbconn.prepareStatement(sql);
			List<AccDto> accList = db2List(pStr);
			return accList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * throws ...
	 * try ... catch ... 으로 처리를 해야하는 코드가 있을 경우
	 * 직접 처리하지 않고 이 method 를 호출한 곳으로
	 * exception 을 대리 처리하도록 하는 조치
	 * 
	 */
	protected AccDto result2Dto(ResultSet result) throws SQLException {
		AccDto accDto = new AccDto();
		accDto.acNum = result.getString(DBContract.ACC.ACC_NUM);
		accDto.acDiv = result.getString(DBContract.ACC.ACC_DIV);
		accDto.acBuid = result.getString(DBContract.ACC.ACC_BUID);
		// SELECT 된 데이터의 type 이 확실하게 숫자형(특히 정수형)인 경우
		// getInt() method 를 사용하여 직접 정수형으로 변환 후 받을 수 있다
		accDto.acBalance = result.getInt(DBContract.ACC.ACC_BALANCE);
		return accDto;
	}

	@Override
	public AccDto findById(String acNum) {
		String sql = " SELECT "
				+ " acnum, acdiv, acbuid, acbalance "
				+ " FROM tbl_acc "
				+ " WHERE acnum = ? ";
		try {
			PreparedStatement pStr = dbconn.prepareStatement(sql);
			pStr.setString(1, acNum);
			ResultSet result = pStr.executeQuery();
			
			AccDto accDto = null;
			if(result.next()) {
				accDto = result2Dto(result);
			}
			pStr.close();
			result.close();
			return accDto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(AccDto accDto) {
		String sql = " INSERT INTO tbl_acc(acnum, acdiv, acbuid, acbalance) "
				+ " VALUES (?, ?, ?, ?) ";
		try {
			PreparedStatement pStr = dbconn.prepareStatement(sql);
			pStr.setString(1, accDto.acNum);
			pStr.setString(2, accDto.acDiv);
			pStr.setString(3, accDto.acBuid);
			pStr.setInt(4, accDto.acBalance);
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(AccDto accDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String acNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccDto> findByBuId(String acBuId) {
		
		String sql = " SELECT "
				+ " acnum, acdiv, acbuid, acbalance "
				+ " FROM tbl_acc "
				+ " WHERE acbuid = ? ";
		try {
			PreparedStatement pStr = dbconn.prepareStatement(sql);
			pStr.setString(1, acBuId);
			List<AccDto> accDtoList = db2List(pStr);
			return accDtoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String maxAcNum(String date) {
		String sql = " SELECT substr(max(acnum),9) FROM tbl_acc "
				+ " WHERE substr(acNum,0,8) = ? ";
		
		PreparedStatement pStr;
		try {
			pStr = dbconn.prepareStatement(sql);
			pStr.setString(1, date);
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				return result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}
}
