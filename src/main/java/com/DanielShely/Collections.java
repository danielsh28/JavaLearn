package com.DanielShely;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collections {


    public static void main(String[] args) {

        Map map= new HashMap(Integer.MAX_VALUE/10000000);
         int i=0;
         fillMap(map, Integer.MAX_VALUE);



    }

    static   Map<Integer,String > fillMap(Map map, int size){

        Integer i =0;

        while (i<size){
            map.put(i,String.valueOf(i));

            ++i;
        }

        return map;
    }


}
