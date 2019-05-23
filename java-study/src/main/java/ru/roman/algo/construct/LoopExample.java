package ru.roman.algo.construct;

import java.util.List;
import java.util.Map;

public class LoopExample {

    public static void main(String[] args) {

        Map<Character, Long> map = null;
        for (Map.Entry<Character, Long> entry : map.entrySet()) {}
        for (Character key : map.keySet()) {}
        for (Long value : map.values()) {}

        int[] arr = null;
        for (int i = 0; i < arr.length; i++) {}                // array
        for (int i = arr.length - 1; i >= 0; i--) {}           // reverse array

        List<Long> list = null;
        for (int i = 0; i < list.size(); i++) {}               // list
        for (int i = list.size() - 1; i >= 0; i--) {}          // reverse list
    }
}
