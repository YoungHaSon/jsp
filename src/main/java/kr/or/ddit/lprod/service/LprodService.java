package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public class LprodService implements IlprodService {

	private IlprodDao dao;
	
	public LprodService(){
		dao = new LprodDao();
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodService.class);

	@Override
	public Map<String, Object> LprodPagination(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", dao.lprodPagingList(pageVo));
		
		int lprodCnt = dao.lprodCnt();
		int paginationSize = (int)Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
		
	}
	

}
