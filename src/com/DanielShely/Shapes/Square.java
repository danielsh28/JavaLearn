package com.DanielShely.Shapes;

import java.util.logging.Level;

public class Square  extends  Rectangle{

    Square() {
        super();
        length= 0.0;
    }
         Square(Double side) {

            setLength(side);
            setWidth(side);
        }

        Square(Double side, String color, boolean filled){
        this.length=side;
        this.width=side;
        this.color=color;
        this.filled=filled;

        }

    public Double getSide() {
        return width;
    }

    void setSide(Double side){
        setLength(side);
        setWidth(side);
    }

    @Override
    public String toString() {
        String ret =String.format("Square with side of %.2f and area of %.2f and"
                + " a Parimeter of %.2f",this.getSide(), this.getArea(),this.getPerimeter());

        return ret;
    }
}
