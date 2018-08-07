package com.DanielShely;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Dispatcher<T>  {

    List<Consumer<T>> observers;

    Dispatcher(){
        observers=new ArrayList<>();

    }

    void subscribe(Consumer<T> consumer){
        observers.add(consumer);

    }

    void unsubscribe(Consumer<T> consumer ){
        observers.remove(consumer);
    }

    void notifyAll(T event){

        for ( Consumer obs: observers){
            obs.accept(event);
        }
    }

}
