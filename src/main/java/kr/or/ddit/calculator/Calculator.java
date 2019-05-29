package kr.or.ddit.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//문자열 계산기
//String text = "1,5,10,20"; -->
//calculator(text) --> 36
//1. 문자열 안에 숫자를 구분 짓는 구분자를 제거한 남은 숫자들은 전부 더한 값을 구한다.
//2. 구분자는 두가지 가능 : " , " 이거나 " : " 만 가능 "1,5:10,20" --> 36 
//3. 문자열이 공백이거나, null이면 0을 리턴! :  ""; , null --> 0
//4. 문자열 시작이 "//과 \n 통해 커스컴 구분자를 지정 할 수 있다. 
// "//;\n1;5;10;20" --> 36
//5. 숫자 구분자는 커스텀 구분자와 기본 구분자 두가지를 섞어 사용할 수 있다.
// "//;\n1,5;10:20" --> 36
public class Calculator {

	private String Seperator = ",|:";

	public int calculate(String text) {
		// 3번
		if (ifEmptyOrNull(text))
			return 0;

		// custom seperator 연산 필요!
		text = parseSeperator(text);
		
		// refactor 기능! Alt + shift + M!
		int result = calculateSum(text.split(Seperator));
		return result;
	}

	private String parseSeperator(String text) {
		if (text.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			if (m.find()) {
				Seperator = Seperator + "|[" + m.group(1) + "]";
				text = m.group(2);
			}
		}
		return text;
	}
	
	private boolean ifEmptyOrNull(String text) {
		return text == null || text.isEmpty();
	}

	private int calculateSum(String[] numberStrings) {
		int result = 0;

		for (String numberString : numberStrings)
			result += Integer.parseInt(numberString);
		return result;
	}
}
