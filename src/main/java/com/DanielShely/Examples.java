package com.DanielShely;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Queue;


class Generics<T extends Shape >{
    private T data;

    T pick(T a1, T a2) {
        return a2;
    }

    void printInfo(){
        new B().foo(8.88);
    }
     private T fromInner(){
        System.out.println("return data of: " + data);
        return data;
    }


    static class B {
        private int i;

        static private <T> void   foo(T t){
            System.out.println("Inside foo method  of the inner class of b \nand" +
                    " argument is " + t.toString() + " from type " +  t.getClass().getName()
            + "\nwhile data is not valid  ");
            /* + data);
            fromInner();*/
        }
    }

    Generics(T data){
        this.data=data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static void main(String[] args) {
        Generics<Rectangle> g = new Generics<>(new Rectangle(4d,7d,"fucking Yellow", true ));
        Generics.B.foo(8);

    }


}









/*
class ThreadIsAbitch{
    static Queue list = new java.util.LinkedList();
     public static void main(String[] args) throws InterruptedException {
            long  time1=System.currentTimeMillis();

         Thread producer= new Thread(new Runnable() {
             public void run() {
                 System.out.println("Starting Producer");

                     for (int i = 0; i <10000000; ++i) {
                         synchronized (list){
                         list.add(i);

                     }
                 }
                 System.out.println("Ending Producer");
             }
         });
         Thread consumer1= new Thread(new Runnable() {
                 public void run () {

                     System.out.println("start Consumer 1");
                     synchronized (list) {
                     while (list.size() != 0) {

                             list.poll();
                         }
                     }
                 }
         });
         Thread consumer2= new Thread(new Runnable() {
             public void run () {

                 System.out.println("start Consumer 2");
                 synchronized (list) {
                     while(list.size()!=0) {

                             list.poll();

                         }
                     }
                }

         });
         producer.start();
         consumer1.start();
         consumer2.start();
         producer.join();
         consumer1.join();
         consumer2.join();

         long time2=System.currentTimeMillis();

         System.out.println("Time of execution: " + (time2-time1));



     }

}*/
