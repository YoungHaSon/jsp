package kr.or.ddit.db.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.db.model.UriVo;

import org.junit.Test;

public class UriDaoTest {

	@Test
	public void uritest() {
		/*** Given ***/
		IuriDao dao = new UriDao();

		/*** When ***/
		List<UriVo> uriList = dao.uriMapping();

		/*** Then ***/
		assertEquals("/main.do", uriList.get(0).getUri());

	}

}
