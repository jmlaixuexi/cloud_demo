package com.jml.sharding.db.slave;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
//此处classes内的内容是@SpringBootApplication入口
@SpringBootTest(classes = {ShardingDbSlaveApplication.class})
@AutoConfigureMockMvc
public class StoreRestControllerTest {

    private Logger log= LoggerFactory.getLogger(StoreRestControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void apiTest() throws Exception {
//        //构建请求
//        MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/store/{storeId}")
//                .contentType("text/html") //指定请求的contentType头信息
//                .accept(MediaType.APPLICATION_JSON); //指定请求的Accept头信息
//        //发送请求，获取结果
//        ResultActions perform=mockMvc.perform(request);
//        //请求结果检验
//        perform.andExpect(MockMvcResultMatchers.status().isOk());
//        //表示执行后响应结果
//        MvcResult mvcResult=perform.andReturn();
//        MockHttpServletResponse response=mvcResult.getResponse();
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/store/1")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        log.info("响应状态: {}",mvcResult.getResponse().getStatus());
        log.info("响应内容{}",mvcResult.getResponse().getContentAsString(Charset.forName("utf-8")));
    }

}
