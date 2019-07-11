package org.zerock.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.UserDrawVO;
import org.zerock.service.ApiService;

import lombok.extern.log4j.Log4j;
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RestController
@Log4j
@RequestMapping("/api/*")

public class ApiController {
	
	@Autowired
	private ApiService service;
	
	@GetMapping(value = "/list",
			produces = "application/json")
	public List<UserDrawVO> list() {
		return service.getList();
	}
	@PostMapping(value = "/draw")
	public void post(@RequestBody Map<String, Object> s) {
		log.info("Post...................");
		UserDrawVO draw = new UserDrawVO();
		draw.setUsername(s.get("username").toString());
		draw.setAmount((int)s.get("amount"));
		log.info(s.get("username").toString());
		log.info((int)s.get("amount"));
		log.info("calling draw function now");
		service.draw(draw);
		log.info("AAAAAA");
		if (draw.getStatus() == 1) {
			log.info("Performing updateUser and insertRecord now..........");
			service.updateUser(draw);
			service.insertRecord(draw);
		}
//		log.info(s.get("username").getClass());
//		log.info(s.get("amount").getClass());
//	    well.setUsername(s.get("username"));
//	    well.setAmount((int)s.get("amount"));
//	    service.insert(well);
//		log.info(s.toString());
//		Object obj = (Object) new String("AA");
//		log.info(obj.getClass());
	}
	
	@GetMapping(value = "/test")
	public void get(@RequestBody Map<String, Object> s) {
		log.info("get received..");
	}
}

//@RequestBody Map<String, Object> s