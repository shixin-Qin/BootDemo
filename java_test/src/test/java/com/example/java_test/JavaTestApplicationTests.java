package com.example.java_test;

import com.example.co.T;
import com.example.java_test.po.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@SpringBootTest
class JavaTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void name() {

    }

    @Test
    void name2() {
        T t = new T(4);
        System.out.println("创建完 i:" + t.getI());
    }

    @Test
    void name3() {
        int i = Integer.MAX_VALUE;
        int j = i + 0;
        int k = i + j;
        System.out.println(k);
    }

    @Test
    void name4() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }


    @Test
    void name5() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("执行方法");
                Thread.sleep(5000);
                return 99999999;
            }
        });
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }

    @Test
    void name6() {
        Person person = new Person("张三", 20);
        Person person1 = person;
        System.out.println("修改前.........");
        System.out.println(person);
        System.out.println(person1);

        person1.setAge(30);
        System.out.println("修改后.........");
        System.out.println(person);
        System.out.println(person1);

    }


    @Test
    void name7() {
        byte b = 127;
        b++;
        System.out.println(b);
    }

    @Test
    void name8() {
        int i = 9999999;
        byte b= (byte) i;
        System.out.println(b);
    }

    @Test
    void name9() {
        int i = Integer.MAX_VALUE;
        System.out.println(i++);
        System.out.println(i);
    }
}
