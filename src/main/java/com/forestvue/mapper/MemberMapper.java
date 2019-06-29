package com.forestvue.mapper;

import com.forestvue.domain.AuthVO;
import com.forestvue.domain.MemberVO;

public interface MemberMapper {
    public MemberVO read(String username);
    public void write(MemberVO vo);
    public void grant(AuthVO vo);
}
