package com.DanielShely.Shapes;

public class Rectangle extends  Shape {
    protected Double width;
    protected Double length;

    public Rectangle() {
        super();
        width=0.0;
        length=0.0;
    }

    public Rectangle(Double width,Double length) {
        super("BLACK", false);
        this.width=width;
        this.length=length;
    }

    public Rectangle(Double width,Double length, String color,boolean filled){

        this.width=width;
        this.length=length;
        this.color=color;
        this.filled=filled;
    }

    @Override
    double getArea() {
        return width*length;
    }

    @Override
    double getPerimeter() {
        return 2*width+ 2*length;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        String ret= String.format("Rectangle with a Perimeter of %.2f"
                + " and " + "Area of %.2f ",this.getPerimeter(),  this.getArea());
        return ret;


    }

}
