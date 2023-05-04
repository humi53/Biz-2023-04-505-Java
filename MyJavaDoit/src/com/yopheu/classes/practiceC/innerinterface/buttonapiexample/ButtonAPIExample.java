package com.yopheu.classes.practiceC.innerinterface.buttonapiexample;

class Button {
	OnClickListener ocl;

	interface OnClickListener {
		public abstract void onClick();
	}

	void setOnClickListener(OnClickListener ocl) {
		this.ocl = ocl;
	}

	void onClick() {
		ocl.onClick();
	}
}

public class ButtonAPIExample {
	public static void main(String[] args) {
		Button btn1 = new Button();
		btn1.setOnClickListener(new Button.OnClickListener() {
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("개발자 1: 음악 재생");

			}
		});
		btn1.onClick();
		
		Button btn2 = new Button();
		btn2.setOnClickListener(new Button.OnClickListener() {
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("개발자 2: 네이버 접속");

			}
		});
		btn2.onClick();
	}
}
