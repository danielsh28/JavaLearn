package com.DanielShely;




import com.DanielShely.Map.HashMap;
import com.DanielShely.Map.MyPair;

import javax.naming.LinkLoopException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Main {

      static class A{
       static  String name;
        A(String name){
            this.name=name;

        }
    }
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a= new A("aaa");
        System.out.println(A.name);
    }
}











