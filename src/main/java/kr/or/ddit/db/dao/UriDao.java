package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.UriVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class UriDao implements IuriDao {

	@Override
	public List<UriVo> uriMapping() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UriVo> uriList = sqlSession.selectList("uri.uriList");
		sqlSession.commit();
		sqlSession.close();
		return uriList;
	}
}
