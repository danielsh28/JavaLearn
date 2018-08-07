package com.DanielShely;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObserverCallBack<T> implements CallBackBase{
    WeakReference<T> obj;
    Method method;



    public ObserverCallBack(T obj, Method method) {
        this.obj = new WeakReference<T>(obj);

        this.method = method;

    }



    @Override
    public void notifyEvent(Object event) throws InvocationTargetException, IllegalAccessException {


          method.invoke(obj.get(), event);


    }
}


interface CallBackBase<E>{

    void notifyEvent(E event ) throws InvocationTargetException, IllegalAccessException;
}
