package org.zerock.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.UserDrawVO;
import org.zerock.service.TransService;

import lombok.extern.log4j.Log4j;
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RestController
@Log4j
@RequestMapping("/api/*")
@Controller
public class TransController {
	
	@Autowired
	private TransService service;
	
	@GetMapping(value = "/list")
	public List<UserDrawVO> list() {
		return service.getList();
	}
	@PostMapping(value = "/draw")
	@Transactional
	public void post(@RequestBody Map<String, Object> s) {
		UserDrawVO draw = new UserDrawVO();
		draw.setUsername(s.get("username").toString());
		draw.setAmount((int)s.get("amount"));
		service.draw(draw);
			log.info("Performing updateUser and insertRecord now..........");
			service.updateUser(draw);
			service.insertRecord(draw);
	}
	
	@GetMapping(value = "/test")
	public void get(@RequestBody Map<String, Object> s) {
		log.info("get received..");
	}
}
