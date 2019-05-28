package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	
	//Test 코드!!!
	public static void main(String[] args) {
		
		//userList() test
		/***Given***/
		IuserDao userDao = new UserDao();
	
		/***When***/
		List<UserVo> userList = userDao.userList();
		
		/***Then***/
		logger.debug("userList : " + userList);
	
		
		//getUser() test
		/***Given***/
		/***When***/
		UserVo user = userDao.getUser("brown");
		UserVo user1 = userDao.getUser("cony");
	
		/***Then***/
		logger.debug("userInfo : " + user);
		logger.debug("userInfo : " + user1);
		
		
		
	}

	/**
	 * Method : userList 작성자 : PC13 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVo> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userList");
		sqlSession.close();
		return userList;
	}

	/**
	* Method : getUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVo getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVo user = sqlSession.selectOne("user.getUser",userId);
		sqlSession.close();
		return user;
	}

	/**
	* Method : userPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userPagingList", pageVo);
		sqlSession.close();
		return userList;
	}

	/**
	* Method : usersCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회 
	*/
	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = (Integer) sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return usersCnt;
	}
}
