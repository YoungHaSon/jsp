package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVo;

public interface IprodDao {

	public List<ProdVo> prodList(String prod_lgu);
	//queryForList
	
}
