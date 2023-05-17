package com.yopheu.bank.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yopheu.bank.models.BuyerDto;
import com.yopheu.bank.service.BuyerService;
import com.yopheu.bank.utils.Config;
import com.yopheu.bank.utils.Line;

public class BuyerServiceImplV1 implements BuyerService {

	List<BuyerDto> buyerList;
	
	public BuyerServiceImplV1() {
		buyerList = new ArrayList<>();
	}
	
	@Override
	public void loadBuyer() {
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(Config.BUYER_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String[] data = scan.nextLine().split("\t");
			BuyerDto buDto = new BuyerDto();
			buDto.buId = data[0];
			buDto.buName = data[1];
			buDto.buTel = data[2];
			buDto.buAddr = data[3];
			buDto.buBirth = data[4];
			buDto.buJob = data[5];
			buyerList.add(buDto);
		}
	}

	@Override
	public void printBuyerList() {
		System.out.println(Line.dLine(100));
		System.out.println("고객정보 리스트");
		System.out.println(Line.dLine(100));
		System.out.println("고객ID\t고객명\t전화번호\t주소\t생년월일\t직업");
		OutputStream os = System.out;
		PrintWriter out = new PrintWriter(os);
		printBuyerList(out);
		System.out.println(Line.dLine(100));
		out.close();
	}

	@Override
	public BuyerDto getBuyer(String buId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inputBuyer() {
		InputStream io = null;
		Scanner scan = null;
		
		io = System.in;
		scan = new Scanner(io);
		
		BuyerDto bDto = null;
		
		while(true) {
			
			String buId ;
			while(true) {
				int intHBuId = getHighNewBuId();
				String strHBuId = String.format("%04d", intHBuId);
				System.out.print("고객ID(" + strHBuId + ") >> ");
				buId = scan.nextLine();
				if(buId.equals("")) {
					buId = strHBuId;
					break;
				}
				if(buId.equalsIgnoreCase("QUIT")) break;
				try {
					int ibuId = Integer.valueOf(buId);
					buId = String.format("%04d", ibuId);
					bDto = searchBuyer(buId);
					if(bDto != null) {
						System.out.println(bDto.toString());
						System.out.println(bDto.buId + "]의 고객정보가 있습니다. 데이터를 수정합니다.");
					}
					break;
				}catch (Exception e) {
					System.out.println("고객 ID는 숫자를 입력하세요.");
				}
			}
			if(buId.equalsIgnoreCase("QUIT")) break;
			
			
			
			System.out.print("이름 >> ");
			String buName = scan.nextLine();
			if(buName.equalsIgnoreCase("QUIT"));
			if(bDto != null) {
				if(buName.equals("")) buName = bDto.buName;
			}
			System.out.print("전화번호 >> ");
			String buTel = scan.nextLine();
			if(buTel.equalsIgnoreCase("QUIT")) break;
			if(bDto != null) {
				if(buTel.equals("")) buTel = bDto.buTel;
			}
			System.out.print("주소 >> ");
			String buAddr = scan.nextLine();
			if(buAddr.equalsIgnoreCase("QUIT")) break;
			if(bDto != null) {
				if(buAddr.equals("")) buAddr = bDto.buAddr;
			}
			System.out.print("생년월일 >> ");
			String buBirth = scan.nextLine();
			if(buBirth.equalsIgnoreCase("QUIT")) break;
			if(bDto != null) {
				if(buBirth.equals("")) buBirth = bDto.buBirth;
			}
			System.out.print("직업 >> ");
			String buJob = scan.nextLine();
			if(buJob.equalsIgnoreCase("QUIT")) break;
			if(bDto != null) {
				if(buJob.equals("")) buJob = bDto.buJob;
			}
			
			if(bDto == null) {
				bDto = new BuyerDto();
				bDto.buId = buId;
				buyerList.add(bDto);
			}
			bDto.buName = buName;
			bDto.buTel = buTel;
			bDto.buAddr = buAddr;
			bDto.buBirth = buBirth;
			bDto.buJob = buJob;
			
			
			System.out.println("입력된 데이터 : " + bDto.toString());
			System.out.println("-".repeat(70));
		}
		System.out.println(buyerList.toString());
		
		String buyerFile = "src/com/yopheu/bank/datas/buyer.txt";
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(buyerFile);
			out = new PrintWriter(os);
			
			printBuyerList(out);
			out.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
	}

	protected int getHighNewBuId() {
		int high = 0;
		for(BuyerDto dto : buyerList) {
			int buId = Integer.valueOf(dto.buId);
			if(high < buId) {
				high = buId;
			}
		}
		return high + 1;
	}
	
	protected BuyerDto searchBuyer(String buId) {
		BuyerDto buDto = null;
		for(BuyerDto dto : buyerList ) {
			if(dto.buId.equals(buId)) {
				buDto = dto;
				break;
			}
		}
		return buDto;
	}

	@Override
	public void printBuyerList(PrintWriter out) {
		for(BuyerDto dto : buyerList) {
			out.printf("%s\t", dto.buId);
			out.printf("%s\t", dto.buName);
			out.printf("%s\t", dto.buTel);
			out.printf("%s\t", dto.buAddr);
			out.printf("%s\t", dto.buBirth);
			out.printf("%s\n", dto.buJob);
		}

		
	}
	
}
