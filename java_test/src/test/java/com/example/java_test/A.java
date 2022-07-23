package com.example.java_test;

public class A {

    static void doSomething(Runnable runnable){
        runnable.run();
    }

    public static void main(String[] args) {
        doSomething(() -> System.out.println("哈哈哈哈哈"));
    }
}
