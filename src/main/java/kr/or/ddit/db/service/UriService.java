package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.IuriDao;
import kr.or.ddit.db.dao.UriDao;
import kr.or.ddit.db.model.UriVo;

public class UriService implements IuriService {

	private IuriDao dao;
	
	//UserDao에 있는 것을 쓰기위해!! 필요!
	public UriService() {
		dao = new UriDao();
	}
	
	@Override
	public List<UriVo> uriMapping() {
		return dao.uriMapping();
	}

}
