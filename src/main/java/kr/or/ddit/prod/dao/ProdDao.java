package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.vo.ProdVo;

public class ProdDao implements IprodDao {

	@Override
	public List<ProdVo> prodList(String prod_lgu){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVo> prodList = sqlSession.selectList("prod.prodList",prod_lgu);
		sqlSession.commit();
		sqlSession.close();
		return prodList;
	}
}
