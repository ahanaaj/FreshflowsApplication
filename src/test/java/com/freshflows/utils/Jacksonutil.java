package com.freshflows.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;

import java.io.IOException;
import java.io.InputStream;

public class Jacksonutil {

  /*  public static <T> T json(String fileName, Class<T> T) throws IOException {
        InputStream is = Jacksonutil.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, T);

    }
*/
    @Step
public static <T> T fnJson(String fileName, Class<T> T) throws IOException {
    InputStream is = Jacksonutil.class.getClassLoader().getResourceAsStream("datafile.json");
    ObjectMapper objectMapper = new ObjectMapper();
   return objectMapper.readValue(is, T);
}
}
