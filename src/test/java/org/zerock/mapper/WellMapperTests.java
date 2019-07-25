package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UserDrawVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WellMapperTests {
	@Setter(onMethod_ = @Autowired)
	private WellMapper mapper;
	
	
	public void testDraw() {
		UserDrawVO draw = new UserDrawVO();
		draw.setUsername("Kim");
		draw.setAmount(30);
		mapper.draw(draw);
		log.info("--------------------------"+draw.getStatus());
	}

	public void testtest() {
		System.out.println("-----------------"+ (int)'A' + (int)'Z' + (int)'a' + (int)'z');
	}
	public void testUpdateUser() {
		UserDrawVO draw = new UserDrawVO();
		draw.setUsername("Kim");
		draw.setAmount(30);
		mapper.updateUser(draw);
		log.info("--------------------"+draw.getTotal());
	}
	
	public void testInsertRecord() {
		UserDrawVO draw = new UserDrawVO();
		draw.setUsername("Kim");
		draw.setAmount(30);
		mapper.insertRecord(draw);
	}
	
	public void testGetList() {
		mapper.getList().forEach(record -> log.info(record));
	}
}
