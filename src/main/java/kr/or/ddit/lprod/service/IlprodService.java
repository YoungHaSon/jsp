package kr.or.ddit.lprod.service;

import java.util.Map;

import kr.or.ddit.paging.model.PageVo;

public interface IlprodService {
	
	Map<String, Object> LprodPagination(PageVo pageVo);

}
