package com.DanielShely;

import java.util.PriorityQueue;

public class WaitablePQueue<E> extends Thread{

    PriorityQueue<E> queue;

    WaitablePQueue(){
        queue= new PriorityQueue<>();
    }

    public synchronized boolean enqueue(E elem){
        return queue.add(elem);
    }

    public synchronized E dequeue(){
        return queue.poll();
    }






    public static void main(String[] args) throws InterruptedException {

        WaitablePQueue<Integer> q = new WaitablePQueue<>();
        Thread push = new Thread(() -> {
            int i=0;
            while(i<100) {
                q.enqueue(++i);

            }
        });
        Thread pop = new Thread(() -> {
            Integer i =q.dequeue();
            while(i<=100) {
                if (i == null) {
                    throw new NullPointerException();
                }
                System.out.println(i);
            }

        });
        push.start();
        pop.start();
        push.join();
        pop.join();
    }


}
