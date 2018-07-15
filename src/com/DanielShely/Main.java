    package com.DanielShely;

    import java.util.NoSuchElementException;


    public class Main{
        public static void main(String[] args) throws ClassNotFoundException {
          Outer out= new Outer();
          Outer.Inner in=out.new Inner();
          in.foo(23);

        }
    }
   class Outer {

        int x =0;

       public class Inner {
            int x=1;

            void foo(int x){
                System.out.println("x= " +x );
                System.out.println("this.x= " + this.x);
                System.out.println("Outer.thos.x= " + Outer.this.x);
            }

        }


    }

