package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {

	/*
	사용자 전체리스트를 조회 하는 메서드
	1. 메서드 인자가 필요한가?
	2. 리턴 타입은 뭐가 될까? List<UserVo>
	3. 메서드 이름은 뭐가 적당하지? : userList
	*/
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	private IuserService service;
	
	@Before
	public void setup(){
		service = new UserService();
//		logger.debug("setup");
	}
	
	@Test
	public void userList(){
		
		/***Given***/

		/***When***/
		List<UserVo> userList = service.userList();
		
		/***Then***/
		assertNotNull(userList);
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
//		logger.debug("userList : " + userList);
		
	}
	
	@Test
	public void getUser(){
		/***Given***/
		String userId1 = "cony";
		
		/***When***/
		UserVo uservo = service.getUser(userId1); 
		
		/***Then***/
		assertEquals("코니", uservo.getName()); 
//		logger.debug("uservo : " + uservo);
		
	}
	
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
		Map<String, Object> resultMap = service.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		//PagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//usersCnt assert
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		
		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : " + paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
		
	}
	
	//userVo가 등록이 되는지 안되는지 Test하는 코드!
		//등록이 완료되면 1을 반환! assertEquals(1, insertCnt); 요부분-
		@Test
		public void insertUserTest() throws ParseException{
			/***Given***/
			//사용자 정보를 담고 있는 vo객체 준비
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
				UserVo userVo = new UserVo("대덕인", "userTest", "중앙로", "userTest1234",
						"대전광역시 중구 중앙로76", "영민빌딩 204호", "34940", sdf.parse("2019-05-31"));
			
			/***When***/
			//userDao.insertUser()
			int insertCnt = service.insertUser(userVo);
			
			/***Then***/
			assertEquals(1, insertCnt);
			
			//data 삭제
			service.deleteUser(userVo.getUserId());
		}
	
	
}
