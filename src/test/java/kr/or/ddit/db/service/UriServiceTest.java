package kr.or.ddit.db.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.db.model.UriVo;

import org.junit.Test;

public class UriServiceTest {

	@Test
	public void uritest() {
		/*** Given ***/
		IuriService service = new UriService();

		/*** When ***/
		List<UriVo> uriList = service.uriMapping();

		/*** Then ***/
		assertEquals("kr.or.ddit.controller.MainController", uriList.get(0).getClassname());

	}

}