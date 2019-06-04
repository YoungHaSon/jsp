package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {

	/**
	* Method : userList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	List<UserVo> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	UserVo getUser(String userId);
	
	Map<String, Object> userPagingList(PageVo pageVo);

	int insertUser(UserVo userVo);

	int deleteUser(String userId);
	
	int updateUser(UserVo userVo);
/////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	* Method : encryptPassAlluser
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	*/
	int encryptPassAlluser();
	
	
}
