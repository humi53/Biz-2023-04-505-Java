package com.yopheu.thread.practiceA.CreateAndStartThread_M1C1;

class SMIFileThread extends Thread{

	@Override
	public void run() {
		
		super.run();
		
		String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
		try {Thread.sleep(10);}catch (InterruptedException e) {
			// 자막 번호 출력
			for(int i = 0; i < strArray.length; i++) {
//				System.out.println(" - (자막 번호) " + );
			}
		}
	}
	
}

public class CreateAndStartThread_M1C1 {

}
