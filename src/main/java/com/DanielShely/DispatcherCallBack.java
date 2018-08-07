package com.DanielShely;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DispatcherCallBack<T>  {

    List<CallBackBase<T>> observers;

    DispatcherCallBack(){
        observers=new ArrayList<>();

    }

    void subscribe(CallBackBase<T> callBack){
        observers.add(callBack);

    }

    void unsubscribe(CallBackBase<T> callBack){
        observers.remove(callBack);
    }

    void notifyAll(T event) throws InvocationTargetException, IllegalAccessException {

        for ( CallBackBase<T> obs: observers){
            try {
                obs.notifyEvent(event);
            }
        catch (NullPointerException e){

            System.out.println("observer Deleted!");



        }

        }
    }

}

