package java2_hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Task1 {

    //Скорость  добавления важнее скорсоти поиска
    //Вывод всех уникальных значений в строковом массиве
    public void uniqueWords(String[] array) {
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(array));
        System.out.println(set);
    }

    //Скорость поиска важнее скорости добавления
    //Подсчет количества одинаковых слов в строковом массиве
    public void countWords(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}
