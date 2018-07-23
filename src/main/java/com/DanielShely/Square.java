package com.DanielShely;

public class Square  extends  Rectangle{
        private  String secret = "Mamo is gay";
   public Square() {
        super();
        length= 0.0;
    }
         public Square(double side) {

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
