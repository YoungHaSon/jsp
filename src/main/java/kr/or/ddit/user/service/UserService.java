package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService implements IuserService {

	//--------------------------
	//요부분 이해 .....XXX
	private IuserDao dao;
	
	//UserDao에 있는 것을 쓰기위해!! 필요!
	public UserService() {
		dao = new UserDao();
	}
	//--------------------------
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	
	/**
	 * Method : userList 작성자 : PC13 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 리스트 조회
	 */
	
	@Override
	public List<UserVo> userList() {
		return dao.userList();
	}

	@Override
	public UserVo getUser(String userId) {
		return dao.getUser(userId);
	}

	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		//1.List<UserVo>,usersCnt()를 필드로 하는 vo
		
		//2.List<Object> resultList = new ArrayList<Object>(); --> 비추!
		// resultList.add(userList);
		// resultList.add(usersCnt);
		
		//3.Map<String, Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("userList", userList);
		// resultMap.put("usersCnt", usersCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));
		
		//usersCnt --> paginationSize를 계산해서 변경
		int usersCnt = dao.usersCnt();
		//pageSize = pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
	

}
