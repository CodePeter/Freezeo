package com.sharp.json;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.parser.JSONScanner;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.sharp.model.ParamDate;

import java.util.Date;

public class FastjsonTest {

    public static void main(String[] args) {
        String requestDate = "{\n" +
                "    \"date1\": \"2019-06-28 16:32:33\",\n" +
                "    \"date2\": \"2019-06-28T16:32:33\",\n" +
                "    \"date3\": \"2019-06-28 16:32:33Z\",\n" +
                "    \"date4\": \"2019-06-28 16:32:33Z\",\n" +
                "    \"date5\": \"2019-06-28 16:32:33\"\n" +
                "}";
//        ParamDate paramDate = JSON.parseObject(requestDate, ParamDate.class);
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        System.out.println(paramDate);
//        SerializerFeature.UseISO8601DateFormat
//        JSONScanner scanner = new JSONScanner("2019-06-28 16:32:33");
//        scanner.scanString();
//
//        System.out.println(scanner.getCalendar().toInstant());
//        Date date = JSON.parseObject("{ \"date\": \"2019-06-28 16:32:33\" }", Date.class);
//        System.out.println(date.toInstant());

    }
}
