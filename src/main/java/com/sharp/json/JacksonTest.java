package com.sharp.json;

import com.alibaba.fastjson.parser.JSONScanner;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharp.model.ParamDate;

import java.io.IOException;

public class JacksonTest {
    public static void main(String[] args) throws IOException {
//        String requestDate = "{\n" +
//                "    \"date1\": \"2019-06-28 16:32:33\",\n" +
//                "    \"date2\": \"2019-06-28T16:32:33\",\n" +
//                "    \"date3\": \"2019-06-28 16:32:33Z\",\n" +
//                "    \"date4\": \"2019-06-28 16:32:33Z\",\n" +
//                "    \"date5\": \"2019-06-28 16:32:33\"\n" +
//                "}";
//        ObjectMapper mapper = new ObjectMapper();
//        ParamDate paramDate = mapper.readValue(requestDate, ParamDate.class);
//        System.out.println(paramDate);
        JSONScanner iso8601Lexer = new JSONScanner("2019-06-28T16:32:33");
//        JSONScanner iso8601Lexer = new JSONScanner("2019-06-28 16:32:33");
        try {
            if (iso8601Lexer.scanISO8601DateIfMatch()) {
                System.out.println(iso8601Lexer.getCalendar().getTime());
            }
        } finally {
            iso8601Lexer.close();
        }
    }
}
