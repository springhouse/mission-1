package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.UserDrawVO;
import org.zerock.mapper.WellMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransServiceImpl implements ApiService {
	
	@Setter(onMethod_ = @Autowired)
	private WellMapper mapper;
	@Override
	public void draw(UserDrawVO draw) {
		log.info("Getting draw info from a client...........");
		mapper.draw(draw);
	}
	@Override
	public void updateUser(UserDrawVO draw) {
		log.info("Inserting/Updating user into the user table...........");
		mapper.updateUser(draw);
	}
	@Override
	public void insertRecord(UserDrawVO draw) {
		log.info("Inserting a record..................");
		mapper.insertRecord(draw);
	}
	
	@Override
	public List<UserDrawVO> getList() {
		log.info("getting the list..........");
		return mapper.getList();
	}

}
