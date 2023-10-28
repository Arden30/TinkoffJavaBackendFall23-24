package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {

    }

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> dict = new HashMap<>();
        for (T obj : list) {
            if (!dict.containsKey(list.get(list.indexOf(obj)))) {
                dict.put(obj, 1);
            } else {
                dict.replace(obj, dict.get(obj) + 1);
            }
        }

        return dict;
    }

}
