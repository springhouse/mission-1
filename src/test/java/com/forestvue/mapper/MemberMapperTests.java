package com.forestvue.mapper;

import com.forestvue.config.RootConfig;
import com.forestvue.domain.AuthVO;
import com.forestvue.domain.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class MemberMapperTests {
    @Setter(onMethod_ = @Autowired)
    private MemberMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;

    @Test
    public void insert(){
        MemberVO member = new MemberVO();
        member.setUserName("ex00");
        member.setUserpw(pwencoder.encode("pw00"));
        mapper.write(member);
        log.info(member);
    }
    @Test
    public void grant(){
        AuthVO auth = new AuthVO();
        auth.setAuth("ROLE_ADMIN");
        auth.setUserid("1");
        mapper.grant(auth);
        log.info(auth);
    }
}
