package com.DanielShely;

import java.lang.reflect.Method;
import java.util.Date;

public class Person <E>{

    int id;

    public Person(int id) {
        this.id = id;
    }

    public void notifyforIdPrint2(E event ){

        System.out.println("Hi! i'm oserver with ID of " + id
                + " and event is : " + event);

    }

    public void notifyForTimePrint2(E event){

        System.out.println("Showing time : " + new Date() + " of observer id: " + id
                + " and event is : " + event);

    }



    void subscribeMe(DispatcherCallBack<E> disp,String methodName ) throws NoSuchMethodException {
        Method met= this.getClass().getMethod(methodName,Object.class);
        ObserverCallBack<Person<E>> obsFunc = new ObserverCallBack<Person<E>>(this,met);
        disp.subscribe(obsFunc);

    }
}
