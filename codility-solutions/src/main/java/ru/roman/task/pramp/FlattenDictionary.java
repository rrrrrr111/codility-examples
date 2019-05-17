package ru.roman.task.pramp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 *
 */
class FlattenDictionary {

    static Map<String, String> flattenDictionary(Map<String, Object> dict) {

        // your code goes here
        // O(n)
        // O(n)
        Queue<Object[]> q = new LinkedList<>();

        for (Map.Entry<String, Object> entry : dict.entrySet()) {
            q.add(new Object[]{entry.getKey(), entry.getValue()});
        }

        Map<String, String> res = new LinkedHashMap<>();
        while (!q.isEmpty()) {

            Object[] entry = q.poll();
            if (entry[1] instanceof String)
                res.put((String) entry[0], (String) entry[1]);

            else {
                for (Map.Entry<String, Object> e : ((Map<String, Object>) entry[1]).entrySet()) {
                    q.add(new Object[]{
                            entry[0].equals("")
                                    ? e.getKey()
                                    : (
                                    e.getKey().equals("")
                                            ? entry[0]
                                            : entry[0] + "." + e.getKey()
                            ),
                            e.getValue()});
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        Map<String, String> smmm = new HashMap<>();
        smmm.put("e", "1");

        Map<String, Object> smm = new HashMap<>();
        smm.put("d", "3");
        smm.put("e", smmm);

        Map<String, Object> sm = new HashMap<>();
        sm.put("a", "2");
        sm.put("b", "3");
        sm.put("c", smm);

        Map<String, Object> map = new HashMap<>();
        map.put("Key1", "1");
        map.put("Key2", sm);

        System.out.println(flattenDictionary(map));
    }

}
