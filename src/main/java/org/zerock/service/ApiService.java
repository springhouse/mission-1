package org.zerock.service;


import java.util.List;

import org.zerock.domain.UserDrawVO;
import org.zerock.domain.WellVO;

public interface ApiService {
	public List<UserDrawVO> getList();
	public List<WellVO> getListbyName(String username);
	public void insert(WellVO well);
	public void draw(UserDrawVO draw);
	public void updateUser(UserDrawVO draw);
	public void insertRecord(UserDrawVO draw);
}
