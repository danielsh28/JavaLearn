    package com.DanielShely;





    public class ComplexNum {

        double real;
        double img;

        public ComplexNum(double real, double img){
            this.img=img;
            this.real=real;
        }
        static public ComplexNum parse(String numAsString ) throws NumberFormatException{
            String real= numAsString.substring(0,numAsString.indexOf("+")-1);
            String img=numAsString.substring(numAsString.indexOf("+") +
                    2,numAsString.length()-1);
            try {
                double realNum=Double.parseDouble(real);
                double imgNum= Double.parseDouble(img);
                return new ComplexNum(realNum,imgNum );
            }
            catch (Exception e){
                throw new NumberFormatException("Plese specify number in the format of <real_num> + <img_num>i");
            }

        }

        public double getImg() {
            return img;
        }

        public double getReal() {
            return real;
        }

        public  boolean isReal(){
            return (img==0);
        }

        public boolean isImg(){
            return (img!=0);
        }

        public void add(ComplexNum num){

            this.real=this.real + num.real;
            this.img=this.img + num.img;


        }
        public void substract(ComplexNum num) {
            this.real=this.real - num.real;
            this.img=this.img - num.img;

        }

         public ComplexNum fromReal(){
            return new ComplexNum(this.real,0);

         }
         public  ComplexNum fromImaginary(){
            return new ComplexNum(0,this.img);

         }

        @Override
        public String toString() {

            String ret = String.format( "%.2f" + " + " + "%.2f" + "i",this.real,this.img);
            return ret;
        }

        public static void main(String[] args) {

            ComplexNum num = new ComplexNum(5.4,5);
            System.out.println(num);
            System.out.println(num.fromReal());
            ComplexNum numFromStr= parse("5.9 + 6.4i");
            numFromStr.add(num);
            numFromStr.substract(new ComplexNum(-1.7,-1.6));
            System.out.println(numFromStr);


        }


    }

