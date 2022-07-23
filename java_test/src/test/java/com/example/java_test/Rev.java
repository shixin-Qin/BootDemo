package com.example.java_test;

public class Rev {
    public static void main(String[] args) {
        String s = "hello world";
        reverse(s);
    }

    static String reverse(String s){
        if(s.length() <= 1)
            return s;
        return reverse(s.substring(1)) + s.indexOf(0);
    }
}
