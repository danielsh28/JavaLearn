package com.DanielShely.Shapes;

public abstract class Shape {
protected String color;
protected boolean filled;

     public Shape(String color, boolean filled){
         this.color=color;
         this.filled=filled;
     }
     public Shape(){
         this.color="BLACK";
         this.filled=false;
     }


      String getColor(){
          return this.color;

      };
     void setColor(String color){
         this.color=color;
     }
    boolean isFilled(){
        return this.filled;
    }
     void setFilled(boolean filled){
         this.filled=filled;

     }

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public String toString() {
        return super.toString();
    };


}
