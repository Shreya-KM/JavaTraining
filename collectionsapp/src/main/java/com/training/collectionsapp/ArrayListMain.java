package com.training.collectionsapp;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("mango");
        fruits.add("apple");
        fruits.add("pomogranate");
        fruits.add("guava");

        System.out.println(fruits);

        for(String fruit : fruits) {
        System.out.println(fruit);
        }
    fruits.forEach(fruit -> System.out.println(fruit));

    fruits.add("banana");
    fruits.add("orange");
        fruits.add("papaya");
        fruits.add("strawberry");

        fruits.forEach(fruit -> System.out.println(fruit));

        fruits.remove("apple");
        fruits.forEach(fruit -> System.out.println(fruit));
        fruits.remove(1);
        fruits.forEach(fruit -> System.out.println(fruit));
        fruits.add(1, "pineapple");
        fruits.forEach(fruit -> System.out.println(fruit));

       System.out.println(fruits.size());

        if(fruits.contains("banana")) {
        System.out.println("The list contains banana");
        }
        else {
        System.out.println("The list doesnt contains banana");
        }

        }
}
 