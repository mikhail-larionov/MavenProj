package ru.vsu.larionov.connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Hangars {
    Map<Integer, String> hangars = new HashMap<>();

    public Hangars() {
    }
    public Hangars(Map<Integer, String> hangars) {
        this.hangars = hangars;
    }

    public Map<Integer, String> getHangars() {
        return hangars;
    }
}
