package com.aplana.SB;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Trash {
    private static Map<String,String> map = new HashMap<>();

    public static WebDriver driver;

    public static String get(String key){
        return map.get(key);
    }

    public static void put(String key, String value){
        map.put(key, value);
    }
    public static int summa(){
        int num = 0;
        for (String value : map.values()) {

            num += Integer.parseInt(value);
        }
        return num;
    }

}