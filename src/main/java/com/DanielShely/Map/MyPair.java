package com.DanielShely.Map;


import java.util.Map;

public class  MyPair<K ,V > implements Map.Entry<K,V> {


    K key;
    V value;

    public MyPair(K key, V value){
        this.key=key;
        this.value=value;
    }

    public V setValue(V value) {
        this.value = value;
        return value;
    }


    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return (key==null? 0: key.hashCode()) ^ (value==null? 0 :value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if(obj.getClass().isInstance(this)) {
           return (((MyPair) obj).value.equals(this.value)) &&
                    (((MyPair) obj).key.equals(this.key));
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s,%s]", key.toString(),value.toString());
    }

    public static  <K,V> MyPair<V,K> swap(MyPair<K,V> entry){

        return  (new MyPair<V,K>(entry.getValue(),entry.getKey()));

    }
    public static  <K,V>  MyPair<K,V> of(K key, V value){

        return new MyPair<K,V>(key,value);

    }

    public static <T extends Comparable<? super T>>  MyPair<T,T> minMax(T elements[]){
        T min=elements[0];
        T max= elements[0];
        int size= elements.length;

        for(int i=1; i<size; i++){
            if (max.compareTo(elements[i])<0){
                max= elements[i];
            }
            if (min.compareTo(elements[i])>0){
                min= elements[i];
            }

        }
        return  (new MyPair<T,T>(min,max));

    }



}

