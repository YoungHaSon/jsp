package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

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


}
