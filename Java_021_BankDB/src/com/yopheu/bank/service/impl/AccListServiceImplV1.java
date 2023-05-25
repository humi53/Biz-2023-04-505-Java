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
import com.yopheu.bank.models.AccListDto;
import com.yopheu.bank.service.AccListService;

public class AccListServiceImplV1 implements AccListService{

	protected Connection dbconn;
	
	public AccListServiceImplV1() {
		dbconn = DBConnection.getDBConn();
	}
	
	
	@Override
	public List<AccListDto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccListDto findById(long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AccListDto dto) {
		String sql = " INSERT INTO tbl_accList "
				+ " (aioSEQ, acNum, aioDate, aioTime, aioDiv, aioInput, aioOutput) "
				+ " VALUES( "
				+ " seq_acclist.nextval, "
				+ " ?, " // 계좌번호
				+ " ?, " // 거래일자
				+ " ?, " // 거래시각
				+ " ?, " // 거래구분(1:입금, 2:출금)
				+ " ?, " // 입금액
				+ " ?) "; // 출금액
		
		int result = -1;
		try {
			PreparedStatement pStr = dbconn.prepareStatement(sql);
			pStr.setString(1, dto.acNum);
			pStr.setString(2, dto.aioDate);
			pStr.setString(3, dto.aioTime);
			pStr.setString(4, dto.aioDiv);
			pStr.setInt(5, dto.aioInput);
			pStr.setInt(6, dto.aioOutput);
			
			// 쿼리 실행하는 method
			// SELECT : executeQuery(),
			// INSERT, UPDATE, DELETE : executeUpdate()
			result = pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<AccListDto> findByDateDestance(String sDate, String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccListDto> findByAcNum(String acNum) {
		String sql = "SELECT aioseq, acnum, aiodate, aiotime, aiodiv, aioinput, aiooutput, aiorem "
				+ " FROM tbl_acclist "
				+ " WHERE acnum = ? ";
		try {
			PreparedStatement pStr = dbconn.prepareStatement(sql);
			pStr.setString(1, acNum);
			List<AccListDto> accDtoList = db2List(pStr);
			return accDtoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccListDto> findByAcNumAndDateDest(String acNum, String sDate, String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(AccListDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return 0;
	}


	protected List<AccListDto> db2List(PreparedStatement pStr) throws SQLException {
		List<AccListDto> accListDtoList = new ArrayList<>();
		ResultSet result = pStr.executeQuery();
		while(result.next()) {
			accListDtoList.add(result2Dto(result));
		}
		pStr.close();
		result.close();
		return accListDtoList;
	}
	protected AccListDto result2Dto(ResultSet result) throws SQLException {
		//aioseq, acnum, aiodate, aiotime, aiodiv, aioinput, aiooutput, aiorem 
		AccListDto accListDto = new AccListDto();
		accListDto.aioSEQ = result.getLong(DBContract.ACCLIST.AIO_SEQ);
		accListDto.acNum = result.getString(DBContract.ACCLIST.AC_NUM);
		accListDto.aioDate = result.getString(DBContract.ACCLIST.AIO_DATE);
		accListDto.aioTime = result.getString(DBContract.ACCLIST.AIO_TIME);
		accListDto.aioDiv = result.getString(DBContract.ACCLIST.AIO_DIV);
		accListDto.aioInput = result.getInt(DBContract.ACCLIST.AIO_INPUT);
		accListDto.aioOutput = result.getInt(DBContract.ACCLIST.AIO_OUTPUT);
		accListDto.aioREM = result.getString(DBContract.ACCLIST.AIO_REM);
		return accListDto;
	}
}
