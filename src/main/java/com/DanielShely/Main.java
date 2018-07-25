package com.DanielShely;




import java.util.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InterruptedException {
        /*Generics<Rectangle> g = new Generics<>(new Rectangle(4d,7d,"fucking Yellow", true ));
         *//*Generics.B.foo(8)*//*;
        g.printInfo();*/
        Random r= new Random(1);
        int i =0;
        com.DanielShely.LinkedList  l = new com.DanielShely.LinkedList();
        while(i<8){
            Integer num= Math.abs(r.nextInt()%1000);
            l.pushFront(num );
            ++i;
        }
        com.DanielShely.LinkedList.LinkedListItr itr= l.begin();

        while(itr.hasNext()){
            l.pushFront(Math.abs(r.nextInt()%1000));
            System.out.println(itr.next());
        }




    }
}





