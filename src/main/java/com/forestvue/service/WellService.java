package com.forestvue.service;

import com.forestvue.domain.UserActionVO;
import com.forestvue.domain.UserDrawInfo;
import com.forestvue.domain.UserScoreVO;
import com.forestvue.mapper.UserScoreMapper;
import com.forestvue.repository.Well;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class WellService {
    private UserScoreMapper userScoreMapper;

   @Autowired
    Well w;

    public void draw(UserDrawInfo info){
        w.remove(info.getAmount());
        userScoreMapper.addScore(info);
    }
    public void deleteAll(){
        userScoreMapper.deleteUserAction();
        userScoreMapper.deleteUserScore();
    }

    public int getWell(){
        return w.getWell();
    }
    public void register(UserScoreVO user){
        userScoreMapper.addUser(user);
    }
    public List<UserScoreVO> getUsers(){
        return userScoreMapper.getUsers();
    }
    public List<UserActionVO> getUserActionsById(int id){
        return userScoreMapper.getUserActionsById(id);
    }
}
