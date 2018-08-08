package com.DanielShely;




import com.DanielShely.Map.HashMap;
import com.DanielShely.Map.MyPair;

import javax.naming.LinkLoopException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Main {
    String s1 = "123";
    String s2 = new String("123");
    int i = 0;

    public int getI() {
        return i;
    }

    public  void setI(int i) {
        this.i = i;
    }


    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Main m = new Main();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (m.i<=100) {
                    synchronized (m.s2){


                        try {
                            m.s2.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(m.getI());
                        m.s2.notify();
                    }
                 }

            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int k = 0;
                while (m.i<=100) {
                    synchronized (m.s1) {
                        System.out.println("Incrementing to " + ++k);
                        ;
                        m.setI(k);
                        /*System.out.println("notify to get");*/
                        m.s1.notify();
                        try {
                            m.s1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    synchronized (m.s1) {
                        m.s1.notify();

                    }
                }

            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}











