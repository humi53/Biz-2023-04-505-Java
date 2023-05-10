package com.yopheu.balckjack.exec;

public class ViewTest {
	  public static void clearScreen() {
		    for (int i = 0; i < 80; i++)
		      System.out.println("");
		  }


	public static void main(String[] args) {
		System.out.println("┌──┐");
		System.out.print("│");
		System.out.print("\u001B[31m♥\u001B[0m");
		System.out.print("\u001B[31mA\u001B[0m");
		System.out.println("│");
		System.out.println("└──┘");
		
		System.out.println("┌──┐");
		System.out.print("│");
		System.out.print("\u001B[31m");
		System.out.print("♦A");
		System.out.print("\u001B[0m");
		System.out.println("│");
		System.out.println("└──┘");
		
		System.out.println("┌──┐");
		System.out.print("│");
		System.out.print("♣");
		System.out.print("T");
		System.out.println("│");
		System.out.println("└──┘");
		
		System.out.println("┌──┐");
		System.out.print("│");
		System.out.print("♠");
		System.out.print("A");
		System.out.println("│");
		System.out.println("└──┘");
		
		String colorStart = "\u001B[31m";
		String colorEnd = "\u001B[0m";
		String simbol = "♥";
		String number = "A";
		String cardNum = colorStart + simbol + number + colorEnd;
		System.out.println("┌──┐");
		System.out.println("│"+ cardNum + "│");
		System.out.println("└──┘");
		
		
		colorStart = "";
		colorEnd = "";
		simbol = "♠";
		number = "A";
		cardNum = colorStart + simbol + number + colorEnd;
		System.out.println("┌──┐");
		System.out.println("│"+ cardNum + "│");
		System.out.println("└──┘");
		
//		clearScreen();
	}
}
