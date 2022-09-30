package com.jml.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
//此处classes内的内容是@SpringBootApplication入口
@SpringBootTest(classes = {MybatisApplicaction.class})
@AutoConfigureMockMvc
public class ProductControllerTest {

    private Logger log= LoggerFactory.getLogger(ProductControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void apiTest() throws Exception {
        //构建请求
        MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/product/get/1")
                .contentType("text/html") //指定请求的contentType头信息
                .accept(MediaType.APPLICATION_JSON); //指定请求的Accept头信息
        //发送请求，获取结果
        ResultActions perform=mockMvc.perform(request);
        //请求结果检验
        perform.andExpect(MockMvcResultMatchers.status().isOk());
        //表示执行后响应结果
        MvcResult mvcResult=perform.andReturn();
        MockHttpServletResponse response=mvcResult.getResponse();
        log.info("响应状态: {}",response.getStatus());
        log.info("响应内容{}",response.getContentAsString());
    }

    @Test
    public void apiTest2() throws Exception {
//        //构建请求
//        MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/product/get/1")
//                .contentType("text/html") //指定请求的contentType头信息
//                .accept(MediaType.APPLICATION_JSON); //指定请求的Accept头信息
//        //发送请求，获取结果
//        ResultActions perform=mockMvc.perform(request);
//        //请求结果检验
//        perform.andExpect(MockMvcResultMatchers.status().isOk());
//        //表示执行后响应结果
//        MvcResult mvcResult=perform.andReturn();
//        MockHttpServletResponse response=mvcResult.getResponse();
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/product/get/1")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        log.info("响应状态: {}",mvcResult.getResponse().getStatus());
        log.info("响应内容{}",mvcResult.getResponse().getContentAsString());
    }
}
