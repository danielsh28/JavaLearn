package com.DanielShely;

public class Circle extends Shape {
   public  Double radius;

    public Circle() {
        super("BLACK" ,false );
        this.radius= 0.0;
    }

    public Circle(Double radius) {
        super("BLACK" ,false );
        this.radius=radius;

    }

    public Circle(Double radius, String color, boolean filled){
        this.color=color;
        this.filled=filled;
        this.radius=radius;
    }


    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return (this.radius*this.radius)*Math.PI;
    }

    @Override
    double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle with Radius of " + this.radius +
                "and Perimeter of " + this.getPerimeter()
                + " and " + "Area of  " + this.getArea();
    }
}
