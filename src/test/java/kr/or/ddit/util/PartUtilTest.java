package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtilTest {

	private static final Logger logger = LoggerFactory
			.getLogger(PartUtilTest.class);
	
	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"sally.png\"";

		/***When***/
		String fileName = PartUtil.getFileName(contentDisposition);

		String[] file = contentDisposition.split("; ");
		
		/***Then***/
		logger.debug("file : {} " , fileName );
		assertEquals("sally.png", fileName);
	}

	//uuid test
	@Test
	public void uuidTest(){
		/***Given***/

		/***When***/
		
		logger.debug("UUID.randomUUID().toString() : {}", UUID.randomUUID().toString());
		
		/***Then***/
	}
	
	@Test
	public void getExtTest(){
		/***Given***/
		String fileName = "sally.png";
		String fileName2 = "sally.picture.png";
		String fileName3 = "sally"; //확장자가 없는경우
		
		/***When***/
		String ext = PartUtil.getExt(fileName);
		String ext2 = PartUtil.getExt(fileName2);
		String ext3 = PartUtil.getExt(fileName3);
		
		/***Then***/
		assertEquals(".png", ext); 
		assertEquals(".png", ext2);
		assertEquals("", ext3);
	}
	
	@Test
	public void subStringTest(){
		/***Given***/
		String yyyymm = "201906";

		/***When***/
		String yyyy = yyyymm.substring(0,4);
		String mm = yyyymm.substring(4,6);
		
		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);
		
	}
	
	
}
