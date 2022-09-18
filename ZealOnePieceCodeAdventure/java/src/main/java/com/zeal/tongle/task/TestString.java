package com.zeal.tongle.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author Tongle
 * @Description TODO
 * Created on 2020-08-06
 */
public class TestString {
    public static void main(String[] args) throws JsonProcessingException {
        //ArrayList<String> list = new ArrayList<>();
        //list.add("1111");
        //list.add("2222");
        //list.add("3333");
        //System.out.println(StringUtils.join(list,"-"));
        //System.out.println(String.format("consumer-%s-%d","111111",333333));
//
        //String json = "{\"key\":11111,\"values\":333}";
        //ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //JsonNode jsonNode = objectMapper.reader().readTree(json);
        //JsonNode values = jsonNode.findPath("values");
        //Iterable<JsonNode> elements = ()-> values.elements();
        //Stream<JsonNode> stream = StreamSupport.stream(elements.spliterator(), false);
        //stream.forEach(x-> System.out.println(x));
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("111","333");
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.toJSONString(stringStringHashMap));


    }
}
