package ru.roman.algo.construct;

import java.util.Map;

public class LoopExample {

    public static void main(String[] args) {

        Map<Character, Long> map = null;
        for (Map.Entry<Character, Long> entry : map.entrySet()) {}
        for (Character key : map.keySet()) {}
        for (Long value : map.values()) {}

    }
}
