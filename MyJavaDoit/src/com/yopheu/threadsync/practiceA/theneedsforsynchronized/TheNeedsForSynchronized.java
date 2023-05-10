package com.yopheu.threadsync.practiceA.theneedsforsynchronized;

class MyData {
	int data = 3;
	
	public void plusData() {
		int mydata = data;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		data = mydata + 1;
	}
}

class PlusThread extends Thread {
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData = myData;
	}
	@Override
	public void run() {
		myData.plusData();
		System.out.println(getName() + "실행 결과: " + myData.data);
	}
}

public class TheNeedsForSynchronized {
	public static void main(String[] args) {
		// 공유 객체 생성
		MyData myData = new MyData();
		
		// plusThread 1
		Thread plusThread1 = new PlusThread(myData);
		plusThread1.setName("plusThread1");
		plusThread1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		// plusThread 2
		Thread plusThread2 = new PlusThread(myData);
		plusThread2.setName("plusThread2");
		plusThread2.start();
		
	}
}
