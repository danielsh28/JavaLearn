package com.DanielShely;

import com.DanielShely.DataStructures.LinkedList;
import com.DanielShely.Shapes.Circle;
import com.DanielShely.Shapes.Rectangle;
import com.DanielShely.Shapes.Shape;
import com.DanielShely.Shapes.Square;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MainTest {
    public static void main(String[] args) throws ClassNotFoundException {

        LinkedList link = new LinkedList();

        link.pushFront(1);
        link.pushFront(2);
        link.pushFront(3);
        link.pushFront(4);
        link.pushFront(5);


        try {
            System.out.println(link.find(8).next());
        }

        catch (NoSuchElementException e){
            System.out.println("8 wasent found, continue with program");


        }



    }
}
