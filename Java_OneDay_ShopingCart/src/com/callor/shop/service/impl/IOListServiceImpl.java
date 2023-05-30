package com.callor.shop.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.mapper.IOListDao;
import com.callor.shop.mapper.ProductDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.models.IOListDto;
import com.callor.shop.models.ProductDto;
import com.callor.shop.service.BuyerService;
import com.callor.shop.service.IOListService;
import com.callor.shop.service.ProductService;

public class IOListServiceImpl implements IOListService{
	protected IOListDao ioListDao;
	protected BuyerDao buyerDao;
	protected ProductDao productDao;
	protected BuyerService buyerService;
	protected ProductService productService;
	protected Scanner scan;
	
	public IOListServiceImpl() {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		ioListDao = sqlSession.getMapper(IOListDao.class);
		buyerDao = sqlSession.getMapper(BuyerDao.class);
		productDao = sqlSession.getMapper(ProductDao.class);
		buyerService = new BuyerServiceImpl();
		productService = new ProductSerivceImpl();
		scan = new Scanner(System.in);
	}
	
	@Override
	public void insert() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat today = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		String todayString = today.format(date);
		String timeString = time.format(date);
		
		//ioSEQ, ioDate, ioTime, ioBuid, ioPCode, ioQuan, ioPrice
		String ioDate = todayString;
		String ioTime = timeString;
		String ioBuid = "";
		String ioPCode = "";
		int ioQuan = 0;
		int ioPrice = 0;
		
		BuyerDto buyerDto = null;
		ProductDto productDto = null;
		while(true) {
			buyerService.printBuyerList();
			System.out.print("고객ID >> ");
			String buId = scan.nextLine();
			buyerDto = buyerDao.findById(buId);
			if(buyerDto != null) {
				ioBuid = buyerDto.buId;
				break;
			}else {
				System.out.println("없는 회원id 입니다. 확인하시고 다시 입력해주세요.");
			}
		}
		while(true) {
			productService.printProductList();
			System.out.print("상품코드 >> ");
			String pCode = scan.nextLine();
			productDto = productDao.findByCode(pCode);
			if(productDto != null) {
				ioPCode = productDto.pCode;
				break;
			}else {
				System.out.println("없는 상품코드 입니다. 확인하시고 다시 입력해주세요.");
			}
		}
		while(true) {
			System.out.print("수량 >> ");
			String strIoQuan = scan.nextLine();
			try {
				ioQuan = Integer.valueOf(strIoQuan);
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
		while(true) {
			System.out.printf("판매단가(%d) >> ", productDto.pOPrice);
			String strIoPrice = scan.nextLine();
			if(strIoPrice.equals("")) {
				ioPrice = productDto.pOPrice;
				break;
			}
			try {
				ioPrice = Integer.valueOf(strIoPrice);
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
		
		IOListDto ioListDto = new  IOListDto();
		ioListDto.ioDate = ioDate;
		ioListDto.ioTime = ioTime;
		ioListDto.ioBuid = ioBuid;
		ioListDto.ioPCode = ioPCode;
		ioListDto.ioQuan = ioQuan;
		ioListDto.ioPrice = ioPrice;
		
		int result = ioListDao.insert(ioListDto);
		if(result < 0) {
			System.out.println(" err : 입력이 실패하였습니다.");
		}else {
			System.out.printf(" %s, %s, %d원, %d개 입력이 성공하였습니다.\n", ioBuid, ioPCode, ioQuan, ioPrice);
		}
	}

	@Override
	public void printFindBuId() {
		String buId;
		while(true) {
			buyerService.printBuyerList();
			System.out.println("판매내역을 확인하고 싶은 고객ID를 입력하세요.");
			System.out.printf("고객ID >> ");
			buId = scan.nextLine();
			if (buyerDao.findById(buId) != null) {
				break;
			}else {
				System.out.println("없는 고객ID 입니다.");
			}
		}
		
		List<IOListDto> ioListDtoList = ioListDao.findByBuId(buId);
		if(ioListDtoList.isEmpty()) {
			System.out.println("거래내역이 없습니다.");
			return;
		}
		printTitle();
		for(IOListDto ioListDto : ioListDtoList) {
			printIoListDto(ioListDto);
		}
		System.out.println("=".repeat(140));
	}
	private void printTitle() {
		System.out.println("=".repeat(140));
		System.out.println(" \t 상품판매리스트");
		System.out.println("-".repeat(140));
		System.out.println("거래일자\t거래시각\t고객ID\t고객이름\t전화번호\t상품코드\t상품명\t판매단가\t수량\t판매합계\t");
		System.out.println("-".repeat(140));
		// ioDate, ioTime, ioBuid, buName, buTel, ioPCode, pName, ioPrice, ioQuan, ioPrice*ioQuan
	}
	private void printIoListDto(IOListDto ioListDto) {
		//long ioSEQ, String ioDate, String ioTime, String ioBuid, String ioPCode, int ioQuan, int ioPrice
		BuyerDto buyerDto = buyerDao.findById(ioListDto.ioBuid);
		ProductDto productDto = productDao.findByCode(ioListDto.ioPCode);
		System.out.printf("%s\t", ioListDto.ioDate);
		System.out.printf("%s\t", ioListDto.ioTime);
		System.out.printf("%s\t", ioListDto.ioBuid);
		System.out.printf("%s\t", buyerDto.buName);
		System.out.printf("%s\t", buyerDto.buTel);
		System.out.printf("%s\t", ioListDto.ioPCode);
		System.out.printf("%s\t", productDto.pName);
		System.out.printf("%s\t", ioListDto.ioPrice);
		System.out.printf("%s\t", ioListDto.ioQuan);
		System.out.printf("%s\t", ioListDto.ioPrice * ioListDto.ioQuan);
		System.out.println();
	}
	
	@Override
	public void printIOListAll() {
		List<IOListDto> ioListDtoList = ioListDao.selectAll();
		printTitle();
		for(IOListDto ioListDto : ioListDtoList) {
			printIoListDto(ioListDto);
		}
		System.out.println("=".repeat(140));
	}

	@Override
	public void printFindDate() {
		String sDate;
		String eDate;
		System.out.println("판매내역을 확인하고 싶은 기간을 입력하세요.");
		System.out.printf("시작날짜 >> ");
		sDate = scan.nextLine();
		System.out.printf("종료날짜 >> ");
		eDate = scan.nextLine();
		
		List<IOListDto> ioListDtoList = ioListDao.findByDate(sDate, eDate);
		if(ioListDtoList.isEmpty()) {
			System.out.println("거래내역이 없습니다.");
			return;
		}
		printTitle();
		for(IOListDto ioListDto : ioListDtoList) {
			printIoListDto(ioListDto);
		}
		System.out.println("=".repeat(140));
		
	}

	@Override
	public void printFindProduct() {
		String pCode;
		productService.printProductList();
		System.out.println("판매내역을 확인하고 싶은 물품코드를 입력하세요.");
		System.out.printf("물품코드 >> ");
		pCode = scan.nextLine();
		
		List<IOListDto> ioListDtoList = ioListDao.findByPCode(pCode);
		if(ioListDtoList.isEmpty()) {
			System.out.println("거래내역이 없습니다.");
			return;
		}
		printTitle();
		for(IOListDto ioListDto : ioListDtoList) {
			printIoListDto(ioListDto);
		}
		System.out.println("=".repeat(140));
		
		
	}

	@Override
	public void printFindDateProduct() {
		String sDate;
		String eDate;
		String pCode;
		productService.printProductList();
		System.out.println("판매내역을 확인하고 싶은 물품코드를 입력하세요.");
		System.out.printf("물품코드 >> ");
		pCode = scan.nextLine();
		System.out.println("판매내역을 확인하고 싶은 물품코드와 기간을 입력하세요.");
		System.out.printf("시작날짜 >> ");
		sDate = scan.nextLine();
		System.out.printf("종료날짜 >> ");
		eDate = scan.nextLine();
		
		List<IOListDto> ioListDtoList = ioListDao.findByBuIdDate(pCode, sDate, eDate);
		if(ioListDtoList.isEmpty()) {
			System.out.println("거래내역이 없습니다.");
			return;
		}
		printTitle();
		for(IOListDto ioListDto : ioListDtoList) {
			printIoListDto(ioListDto);
		}
		System.out.println("=".repeat(140));
	}

}
