package cn.ustb.controller;

import cn.ustb.pojo.User;
import cn.ustb.utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RestController 前后端分离的时候，只会返回字符串，不会走视图解析器。@RestController 表示下面的所有方法都不走视图解析器
@Controller // 会被视图解析器解析，走视图解析器
public class UserController {

    //@RequestMapping(value = "/json",produces = "application/json;charset=utf-8") // 原生态的乱码解析
    @RequestMapping("/json")
    @ResponseBody // 不会走视图解析器，直接返回一个字符串，配合@Controller使用
    public String json() throws JsonProcessingException {
        // jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("SMITH", 10, "男");
        String str = mapper.writeValueAsString(user);// 会把一个值变为字符串
        return str;
    }

    @RequestMapping("/jsons")
    @ResponseBody
    public String jsons() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = new ArrayList<User>();
        User user1 = new User("SMITH-1", 10, "男");
        User user2 = new User("SMITH-2", 11, "男");
        User user3 = new User("SMITH-3", 12, "男");
        User user4 = new User("SMITH-4", 13, "男");
        User user5 = new User("SMITH-5", 14, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        String str = mapper.writeValueAsString(users);// 会把一个值变为字符串
        return str;
    }

    @RequestMapping("/jsontime1")
    @ResponseBody
    public String jsonTime1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        // 方式一：使用SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ObjectMapper的时间解析后默认是时间戳：Timestamp
        String str = mapper.writeValueAsString(sdf.format(date));// 会把一个值变为字符串
        return str;
    }

    @RequestMapping("/jsontime2")
    @ResponseBody
    public String jsonTime2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        // 方式二：使用ObjectMapper
        // 设置不使用时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);
        // ObjectMapper的时间解析后默认是时间戳：Timestamp
        String str = mapper.writeValueAsString(date);// 会把一个值变为字符串
        return str;
    }

    @RequestMapping("/jsontime3")
    @ResponseBody
    public String jsonTime3() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date);
    }

    @RequestMapping("/fastjson")
    @ResponseBody
    public String fastjson() {
        List<User> users = new ArrayList<User>();
        User user1 = new User("SMITH-1", 10, "男");
        User user2 = new User("SMITH-2", 11, "男");
        User user3 = new User("SMITH-3", 12, "男");
        User user4 = new User("SMITH-4", 13, "男");
        User user5 = new User("SMITH-5", 14, "男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(users);
        System.out.println("JSON.toJSONString(list)==>" + str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>" + str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1 = JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>" + jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>" + jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>" + to_java_user);

        return "Hello";
    }

}
