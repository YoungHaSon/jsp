package kr.or.ddit.calculator;


import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


public class CalculatorTest {

	//3. 문자열이 공백이거나, null이면 0을 리턴! :  ""; , null --> 0
	@Test
	public void empty_test() {
		/***Given***/
		Calculator cal = new Calculator();
		String text ="";

		/***When***/
		int result = cal.calculate(text);
				
		/***Then***/
		assertEquals(0, result);
	}
	
	@Test
	public void null_test() {
		/***Given***/
		Calculator cal = new Calculator();
		String text = null;

		/***When***/
		int result = cal.calculate(text);
				
		/***Then***/
		assertEquals(0, result);
	}

	//2. 구분자는 두가지 가능 : " , " 이거나 " : " 만 가능 "1,5:10,20" --> 36 
	@Test
	public void defaultSeperatorTest() {
		/***Given***/
		Calculator cal = new Calculator();
		String text = "1,5,10,20";
		
		/***When***/
		int result =  cal.calculate(text);
				
		/***Then***/
		assertEquals(36, result);
	}
	
	//4. 문자열 시작이 "//과 \n 통해 커스컴 구분자를 지정 할 수 있다. 
	// "//;\n1;5;10;20" --> 36
	
	@Test
	public void CustomSeperatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "//;\n1;5;10;20";

		/***When***/
		int result = cal.calculate(text);
		
		/***Then***/
		assertEquals(36, result);
		
	}
	
	@Test
	public void regexpCaptureTest(){
		/***Given***/
		String text = "//;\n1;5;10;20";

		/***When***/
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find());
			String customSeperator = m.group(1);
			String textNumbers = m.group(2);
			
		/***Then***/
		assertEquals(";", customSeperator);
		assertEquals("1;5;10;20", textNumbers);

	}
	
	@Test
	public void seperatorTest(){
		String text = "1,10:20";
		
		String[] textArray = text.split(",|:");
		assertEquals(3, textArray.length);
		assertEquals("1", textArray[0]);
		
	}
	
	//5. 숫자 구분자는 커스텀 구분자와 기본 구분자 두가지를 섞어 사용할 수 있다.
	// "//;\n1,5;10:20" --> 36
	
	@Test
	public void custom_default_seperatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "//;\n1,5;10:20";

		/***When***/
		int result = cal.calculate(text);

		/***Then***/
		assertEquals(36, result);
		
	}
	
	
	
	
	
}
