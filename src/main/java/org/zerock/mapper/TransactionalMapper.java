package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.UserDrawVO;

public interface TransactionalMapper {
	public List<UserDrawVO> getList();
	public void draw(UserDrawVO draw);
	public void updateUser(UserDrawVO draw);
	public void insertRecord(UserDrawVO draw);
}
