package com.forestvue.mapper;

import com.forestvue.domain.UserActionVO;
import com.forestvue.domain.UserDrawInfo;
import com.forestvue.domain.UserScoreVO;

import java.util.List;

public interface UserScoreMapper {
    //insert
    public void addUser(UserScoreVO user);
    public void addScore(UserDrawInfo user);

    //update
    public void deleteUserScore();
    public void deleteUserAction();
    //select
    public List<UserActionVO> getUserActionsById(int userid);
    public List<UserScoreVO> getUsers();
}
