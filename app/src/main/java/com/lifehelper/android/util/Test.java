package com.lifehelper.android.util;

public class Test {
    private  Person[] test_arry = new Person[]{new Person("a",12),new Person("b",10)};


    public static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
