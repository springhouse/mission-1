package cocurrency;

import com.forestvue.domain.UserDrawInfo;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
public class UserThread implements Runnable {
    private String name;
    private MockMvc mvc;

    UserThread(String username, MockMvc mvc){
        name = username;
        this.mvc = mvc;
    }

    @Override
    public void run() {
        for(int i=0; i<50; i++){
            UserDrawInfo info = new UserDrawInfo();
            info.setUsername(this.name);
            info.setAmount(2);
            String json = new Gson().toJson(info);
            try {
                mvc.perform(post("/draw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
