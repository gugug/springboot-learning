package com.gdufs.girl;

import com.gdufs.girl.controller.GirlController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GirlApplicationTests {

    @Test
    public void contextLoads() {
    }

    @InjectMocks
    private GirlController girlController;

    @Autowired
    WebApplicationContext wac;
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void testDelete() throws Exception {
        RequestBuilder request;// 6、del删除id为1的girl
        request = delete("/girls/4");
        mvc.perform(request)
                .andExpect(content().string(equalTo("")));
    }

    @Test
    public void testPut() throws Exception {
        RequestBuilder request;// 4、put修改id为1的girl
        request = put("/girls/3")
                .param("cupSize", "11");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":3,\"cupSize\":\"11\",\"age\":null}")));
    }

    @Test
    public void testPost() throws Exception {
        RequestBuilder request;// 2、post提交一个girl
        request = post("/girls/")
                .param("cupSize", "1")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":3,\"cupSize\":\"1\",\"age\":20}")));
    }

    @Test
    public void tetsGet() throws Exception {
        RequestBuilder request;// 1、get查一下girl列表，应该为空
        request = get("/girls");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}
