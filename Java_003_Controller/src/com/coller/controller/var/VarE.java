package com.coller.controller.var;

public class VarE {
	public static void main(String[] args) {
		String str = "Republic of Korea";
		String nation = "";	//비어있다. 숫자변수에는 0이 들어있다.
		
		// str 에 저장된 문자열을 12번째 에서 잘라서
		// 오른쪽의 문자열을 nation 변수에 저장
		nation = str.substring(12);
		System.out.println(nation);
		
		// str에 저장된 문자열을 9번째에서 한번자르고
		// 11번째에서 또 한번 잘라고 그 사이의 문자열을 출력.
		System.out.println(str.substring(9, 11));	// 다른 언어와 조금 다르다
		
		
	}
}
