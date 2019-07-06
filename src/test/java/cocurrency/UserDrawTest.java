package cocurrency;

import com.forestvue.config.RootConfig;
import com.forestvue.config.ServletConfig;
import com.forestvue.domain.UserDrawInfo;
import com.forestvue.domain.UserScoreVO;
import com.forestvue.service.WellService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
@Log4j
public class UserDrawTest {

    private MockMvc mockMvc;

    @Autowired
    WellService wellService;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        wellService.deleteAll();
        for(int i=1; i<=50; i++){
            UserScoreVO vo = new UserScoreVO();
            vo.setUsername("person"+i);
            wellService.register(vo);
        }
    }

    @Test
    public void userActionTest(){
        UserDrawInfo info = new UserDrawInfo();
        info.setUsername("person1");
        info.setAmount(2);
        String json = new Gson().toJson(info);
        try {
            mockMvc.perform(post("/draw")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=1; i<=50; i++){
            Runnable r = new UserThread("person"+i,mockMvc);
            Thread t = new Thread(r);
            threads.add(t);
        }
        for(Thread t: threads){
            t.start();
        }
        for(Thread t: threads){
            t.join();
        }
        Assert.assertEquals(5000,wellService.getWell());
    }
}
