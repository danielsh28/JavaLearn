package com.DanielShely;

import java.util.ArrayList;
import java.util.Queue;

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

}