package com.jml.param.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 在springboot中有许多的参数注解，这里举例几个常用的注参数解。
 */
@RestController
@RequestMapping("/parameter")
public class ParameterController {

    /**
     * @PathVariable：路径变量
     * @param id
     * @param name
     * @param pv
     * @return
     */
    @RequestMapping(value = {"/pathValue/{id}/{name}"},method = {RequestMethod.GET})
    public Map pathValue(@PathVariable("id") Integer id,
                         @PathVariable("name") String name,
                         @PathVariable Map pv){
        Map map=new HashMap<String,Object>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);

        return map;
    }

    /**
     * @RequestHeader：获取请求头
     * @param userAgent
     * @param ua
     * @return
     */
    @RequestMapping(value = {"/heand"},method = {RequestMethod.GET})
    public Map getHeand(@RequestHeader("User-Agent") String userAgent,
                        @RequestHeader Map ua){
        Map map=new HashMap<String,Object>();
        map.put("userAgent",userAgent);
        map.put("ua",ua);

        return map;
    }

    /**
     * @RequestParam：获取请求参数
     * @param id
     * @param name
     * @param rp
     * @return
     */
    @GetMapping("/param")
    public Map getParam(@RequestParam("id") String id,
                        @RequestParam("name") String name,
                        @RequestParam Map rp){
        Map map=new HashMap<String,Object>();

        map.put("id",id);
        map.put("name",name);
        map.put("rp",rp);

        return map;
    }

    /**
     * @CookieValue：获取cookie值
     * @param _seeyon
     * @param cookie
     * @return
     */
    @RequestMapping("/cookie")
    @CrossOrigin(origins = "*")
    public Map getCookie(@CookieValue("_seeyon") String _seeyon,
                         @CookieValue("_seeyon") Cookie cookie){
        Map map=new HashMap<String,Object>();
        map.put("seeyon",_seeyon);
        map.put("cookie",cookie.getName()+"===>"+cookie.getValue());

        return map;
    }


    /**
     * @RequestBody：获取请求体
     * @param content
     * @return
     */
    @PostMapping("/body")
    public Map getBody(@RequestBody String content){
        Map map=new HashMap<String,Object>();

        map.put("content",content);

        return map;
    }


    /**
     *
     * @RequestAttribute：获取request域属性
     * @param request
     * @return
     */
    @GetMapping("/forWard")
    public void getForword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id",001);
        request.setAttribute("name","小花");
        request.getRequestDispatcher("/parameter/ra").forward(request,response);
    }

    @ResponseBody
    @GetMapping("/ra")
    public Map getRa(@RequestAttribute("id") Integer id,
                     @RequestAttribute("name") String name){
        Map map=new HashMap<String,Object>();

        map.put("id",id);
        map.put("name",name);

        return map;
    }



}
