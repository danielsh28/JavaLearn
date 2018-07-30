package com.DanielShely;




import com.DanielShely.Map.Entry;

import javax.naming.LinkLoopException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args)  {
        int size = 100;
        int i =0;

        LinkedList<LinkedList<Entry>> list=  new LinkedList();
        Entry entries[] = new Entry[size];


       while(i<size){


           entries[i]=new Entry(new Random().nextInt(),String.valueOf(i));
           ++i;
       }
        i=0;
       while(i<size){

           ++i;

       }

        System.out.println(list.popFront());


    }
}





