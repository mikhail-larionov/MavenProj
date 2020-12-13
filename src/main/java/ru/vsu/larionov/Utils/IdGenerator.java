package ru.vsu.larionov.Utils;

import java.util.Date;

public class IdGenerator {
    public static long generateId(){
        return new Date().getTime();
    }
}
