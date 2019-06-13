package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.vo.ProdVo;

public class ProdService implements IprodService {
	
	private IprodDao dao;
	
	public ProdService(){
		dao = new ProdDao();
	}
	
	@Override
	public List<ProdVo> prodList(String prod_lgu) {
		return dao.prodList(prod_lgu);
	}
}
