package ru.vasilev.SpringBootLab1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController

public class HelloController {
    ArrayList<String> list = new ArrayList<>();
    Map<Integer, String> hashMap = new HashMap<>();
    int keyHashMap = 1;
    int sw1 = 0;
    int sw2 =0;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s", defaultValue = "") String s) {
        if (sw1 == 0) {
            sw1 = 1;
            list = new ArrayList<>();
            return "Created ArrayList";
        }
        else {
            list.add(s);
            return String.format("В ArrayList добавлена строка: %s", s);
        }
    }
    @GetMapping("/showArrayList()")
    public String showArrayList() {

            return String.format(list.toString());

    }
    @GetMapping("/updateHashMap")
    public String updateHashMap(@RequestParam(value = "s", defaultValue = "") String s) {
        if (sw2 == 0) {
            sw2 = 1;
            hashMap = new HashMap<>();
            return "Created HashMap";
        }

        hashMap.put(keyHashMap, s);
        keyHashMap ++;
        return String.format("В HashMap добавлена строка: %s", s);
    }
    @GetMapping("/showHashMap()")
    public String showHashMap() {

        return String.format(hashMap.toString());

    }
    @GetMapping("/showAllLenght()")
    public String showAllLenght() {

        return String.format("ArrayList содержит: " + list.size() + " элемента " +
        "HashMap содержит: " + hashMap.size() + " элемента");
    }
}
