    package com.DanielShely;

    import javax.lang.model.type.TypeVariable;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.lang.reflect.Constructor;
    import java.lang.reflect.Field;
    import java.lang.reflect.InvocationTargetException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.NoSuchElementException;


    public class Main {
        public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
            Class sc=null;
            Constructor constructor=null;

                sc = Class.forName("com.DanielShely.Square");
                constructor= sc.getConstructor(Double.TYPE);

            Field[] fields = sc.getDeclaredFields();
            Object obj=constructor.newInstance(7d);

            for(Field field:fields){
                field.setAccessible(true);
                System.out.println("private field name: " + field.getName());
                System.out.println("private field value: " + field.get(obj));
                field.set(obj,"mamo is not gay");

                System.out.println("New private field value: " + field.get(obj));

            }





            }
        }





