package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
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

	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return dao.updateUser(userVo);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	* Method : encryptPassAlluser
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치 , 재실행 하지마세요 절대..
	*/
	@Override
	public int encryptPassAlluser() {
		//0. sql실행에 필요한 Session객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		//1. 모든 사용자 정보를 조회 (단, 기존 암호화 적용 사용자 제외)
		List<UserVo> userList = dao.userListForPassEncrypt(sqlSession);
		
		//2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트!
		int updateCntSum = 0;
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = dao.updateUserEncryptPass(sqlSession, userVo);
			updateCntSum += updateCnt;
			
			//업데이트 실패
			if(updateCnt !=1){
				sqlSession.rollback();
				break;
			}
		}
		//3. sqlSession 객체를 commit, close
		sqlSession.commit();
		sqlSession.close();
		
		return updateCntSum;
	}
	
	public static void main(String[] args){
		IuserService userService = new UserService();
		int updateCnt = userService.encryptPassAlluser();
		logger.debug("updateCnt : {}", updateCnt);
	}
}
