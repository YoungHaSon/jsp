package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;



public class LprodDao implements IlprodDao {

	/**
	* Method : lprodPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param lprodVo
	* @return
	* Method 설명 : lprod 페이징 리스트 조회
	*/
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.lprodPagingList",pageVo);
		sqlSession.close();
		return lprodList;
	}

	/**
	* Method : lprodCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 수 조회
	*/
	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodCnt = (Integer) sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		return lprodCnt;
	}



}
