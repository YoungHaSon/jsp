package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* UserDaoTest.java
*
* @author PC13
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC13 최초 생성
*
* </pre>
*/
public class UserDaoTest {
	private static final Logger logger = LoggerFactory
		.getLogger(UserDaoTest.class);
	
	private IuserDao userDao;
	
	/*
		JUnit 실행 순서!
		@BeforeClass가 적용된 메서드가 1회 실행
		
		다음 구간은 @Test가 적용된 모든 메서드에 대해 반복 적용
		@Before가 적용된 메서드 실행
		@Test가 적용된 메서드 실행
		@After가 적용된 메서드 실행
		
		@AfterClass가 적용된 메서드가 1회 실행
	  
	*/
	
	//실행 순서에 의해서 junit이 실행될때 마다 userDao의 새로운 객체를 만들어준다!
	//주로 요걸 많이 쓴다!
	@Before
	public void setup(){
		userDao = new UserDao();
		logger.debug("setup");
	}
	
	@BeforeClass
	public static void BeforeClass(){
		logger.debug("beforeClass");
	}

	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	
	//test 메서드입니다.
	/**
	* Method : userListTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	*/
	@Test
	public void userListTest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userDao.userList();

		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : " + userList);

		
	}

	
	//public void 무조껀! 인자도 있으면 안된다?
	/**
	* Method : getUserTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVo uservo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", uservo.getName());
		logger.debug("uservo : " + uservo);
	}
	
	//사용자 페이징 리스트 조회
	//고려사항
	//몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터와 관련
	//정렬순서? : 로직과 관련 (파라미터화 시킬수 있다.) 
	//--> 사용자 아이디 순으로 정렬!!
	
	/**
	* Method : usesrPagingListTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	*/
	@Test
	public void usesrPagingListTest(){
		/***Given***/ //주어진 환경
		PageVo pageVo = new PageVo(1,10);
	
		/*
		PageVo pageVo = new PageVo();
		PAGEVO.SETPAGE(1);
		PAGEVo.setPageSize(10);
		*/
		
		/***When***/
		List<UserVo> userList = userDao.userPagingList(pageVo);
		
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
	
		
	}
	@Test
	public void usersCntTest(){
		/***Given***/
		

		/***When***/
		int usersCnt = userDao.usersCnt();
		
		/***Then***/
		assertEquals(105, usersCnt);
	}
	
	//userVo가 등록이 되는지 안되는지 Test하는 코드!
	//등록이 완료되면 1을 반환! assertEquals(1, insertCnt); 요부분-
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		//사용자 정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			UserVo userVo = new UserVo("userTest", "대덕인", "중앙로", "userTest1234",
					"대전광역시 중구 중앙로76", "영민빌딩 204호", "34940", sdf.parse("2019-05-31"),"","");
		
		/***When***/
		//userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
		//data 삭제
//		userDao.deleteUser(userVo.getUserId());
	}
	
	@Test
	public void updateUserTest()throws ParseException{
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("userTest", "대덕인", "중앙로1", "userTest1234",
				"대전광역시 중구 중앙로30", "영민빌딩 204호 입니다.", "34940", sdf.parse("2019-05-31"),"","");

		/***When***/
		int updateCnt = userDao.updateUser(userVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
	

	
}
