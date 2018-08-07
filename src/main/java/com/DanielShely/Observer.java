package com.DanielShely;

import java.util.Date;
import java.util.function.Consumer;

public class Observer<T>{
    int id;


    Observer(int id){
        this.id=id;
    }

    void registerMe(Consumer<T> func, Dispatcher<T> disp){
        disp.subscribe(func);

    }


    public void notifyforIdPrint(T event ){

        System.out.println("Hi! i'm oserver with ID of " + id
                + " and event is : " + event);

    }

    public void notifyForTimePrint(T event){

        System.out.println("Showing time : " + new Date() + " of observer id: " + id
        + " and event is : " + event);



    }


}
