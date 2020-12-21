package ru.vsu.larionov.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vsu.larionov.connection.Hangars;

public class Parser {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Hangars hangarsParser(String data) throws JsonProcessingException {
        return objectMapper.readValue(data, Hangars.class);
    }
}
