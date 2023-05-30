package com.callor.shop.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.ProductDao;
import com.callor.shop.models.ProductDto;
import com.callor.shop.service.ProductService;

public class ProductSerivceImpl implements ProductService {
	protected ProductDao productDao;
	protected Scanner scan;
	
	public ProductSerivceImpl() {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		productDao = sqlSession.getMapper(ProductDao.class);
		scan = new Scanner(System.in);
	}
	
	@Override
	public void printProductList() {
		List<ProductDto> productDtoList = productDao.selectAll();
		printProductTitle();
		for(ProductDto productDto : productDtoList) {
			printProduct(productDto);
		}
		System.out.println("=".repeat(120));
		
	}
	private void printProductTitle() {
		System.out.println("=".repeat(120));
		System.out.println(" \t 상품정보");
		System.out.println("-".repeat(60));
		System.out.println("상품코드\t\t상품명\t품목\t매입단가\t매출단가\t");
	}
	
	private void printProduct(ProductDto productDto) {
		//pCode, pName , pItem, pIPrice, pOPrice
		System.out.printf("%s\t", productDto.pCode);
		System.out.printf("%s\t", productDto.pName);
		System.out.printf("%s\t", productDto.pItem);
		System.out.printf("%d\t", productDto.pIPrice);
		System.out.printf("%d\t", productDto.pOPrice);
		System.out.println();
	}

	@Override
	public void insertProduct() {
		ProductDto productDto = null;
		String pCode = "";
		String pName = "";
		String pItem = "";
		String strPIPrice = "";
		int pIPrice = 0;
		float fPOPrice = 0.0f;
		int pOPrice = 0;
		
		System.out.printf("상품코드 >> ");
		pCode = scan.nextLine();		
		productDto = productDao.findByCode(pCode);
		boolean isNewDto = false;
		if(productDto == null) {
			isNewDto = true;
			productDto = new ProductDto();
		}else {
			isNewDto = false;
			System.out.println("상품코드가 존재합니다. 해당 정보를 업데이트 합니다.");
			pCode = productDto.pCode;
		}
		
		System.out.printf("상품명(%s) >> ", isNewDto ? "신규" : productDto.pName);
		pName = scan.nextLine();
		if(!isNewDto && pName.equals("")) pName = productDto.pName;
		
		System.out.printf("품목(%s) >> ", isNewDto ? "신규" : productDto.pItem);
		pItem = scan.nextLine();
		if(!isNewDto && pItem.equals("")) pItem = productDto.pItem;
		
		while(true) {
			System.out.printf("매입단가(%s) >> ", isNewDto ? "신규" : productDto.pIPrice+"");
			strPIPrice = scan.nextLine();
			if(!isNewDto && strPIPrice.equals("")) {
				pIPrice = productDto.pIPrice;
				break;
			}
			try {
				pIPrice = Integer.valueOf(strPIPrice);
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
		
		fPOPrice =  pIPrice + (pIPrice * 0.22f);
		pOPrice = (int) Math.round(fPOPrice / 10) * 10;
		System.out.printf("매출단가(자동입력) >> %d\n", pOPrice);
		
		productDto.pCode = pCode;
		productDto.pName = pName;
		productDto.pItem = pItem;
		productDto.pIPrice = pIPrice;
		productDto.pOPrice = pOPrice;
		
		int result = -1;
		if(isNewDto) {
			result = productDao.insert(productDto);
		}else {
			result = productDao.update(productDto);
		}
		
		if(result < 0) {
			System.out.printf("err : %s 실패하였습니다.\n", isNewDto ? "생성이": "업데이트가");
		}else {
			System.out.printf("[%s]%s %s 성공하였습니다.\n",pCode,pName, isNewDto ? "생성이": "업데이트가");
		}
		
		
		
	}

}
