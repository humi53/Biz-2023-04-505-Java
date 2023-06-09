package com.yopheu.threadsync.practiceA.keyobject_1;

// 3개의 동기화 영역이 동일한 열쇠로 동기화 됐을때
class MyData{
	synchronized void abc() {
		for(int i = 0; i < 3; i++) {
			System.out.println(i + "sec");
			try {Thread.sleep(1000);}catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
	synchronized void bcd() {
		for(int i = 0; i < 3; i++) {
			System.out.println(i + "초");
			try {Thread.sleep(1000);}catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
	void cde() {
		synchronized(this) {
			for(int i = 0; i < 3; i++) {
				System.out.println(i + "번째");
				try {Thread.sleep(1000);}catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		}
	}
}

public class KeyObject_1 {
	public static void main(String[] args) {
		// 공유 객체
		MyData myData = new MyData();
		// 3개의 쓰레드가 각각의 메서드 호출
		new Thread() {
			public void run() {
				myData.abc();
			};
		}.start();
		new Thread() {
			public void run() {
				myData.bcd();
			};
		}.start();
		new Thread() {
			public void run() {
				myData.cde();
			};
		}.start();
	}
}
