package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UserDrawVO;
import org.zerock.domain.WellVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ApiServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private ApiService service;
	
	public void testExist() {
		log.info("AAAAAAAAA" + service);
		assertNotNull(service);
	}

		
	public void testgetList() {
		service.getList().forEach(record -> log.info(record));
	}
	
	@Test
	public void testdraw() {
		log.info("AAAA");
		UserDrawVO draw = new UserDrawVO();
		draw.setUsername("KK");
		draw.setAmount(300);
		service.draw(draw);
		log.info("--------------------"+draw.getStatus());
	}
	public void checkUser() {
		
	}
//	public void testRegister() {3
//		BoardVO board = new BoardVO();
//		board.setTitle("ServiceTest로 새로 작성하는 글");
//		board.setContent("new content");
//		board.setWriter("newbie");
//		service.register(board);
//	}
//	
//	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
//	}
//	
//	public void testGet() {
//		log.info(service.get(1L));
//	}
//	
//	public void testDelete() {
//		log.info("REMOVE RESULT: " + service.remove(2L));
//		
//	}
//	
//	public void testUpdate() {
//		BoardVO board = service.get(1L);
//		if (board== null) {
//			return;
//		}
//		
//		board.setTitle("제목 수정합니다");
//		log.info("MODIFY RESULT: " + service.modify(board));
//	}
	
}
