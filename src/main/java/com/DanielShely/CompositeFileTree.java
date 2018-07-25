package com.DanielShely;



import java.io.File;
import java.util.ArrayList;

public class CompositeFileTree {
    public static void main(String[] args) throws InterruptedException {
        Composite comp = new Composite() {
            int c = 7;

            public void print() {
                System.out.println("fuck youuuuuuuuuuuuuuuu" + c);
            }
        };
        comp.print();

    }
}

class Directory implements  Composite{
    ArrayList<Composite> list;
    int depth;
    String name;
    Directory(String name, int depth){
        this.name=name;
        this.depth= ++depth;
        list=new ArrayList<Composite>();
        File f =new File(name);
        File files[] = f.listFiles();
        for(File file: files){
            if (f==null) {
                break;
            }

            if(file.isDirectory()){
                list.add(new Directory(file.getAbsolutePath(),this.depth));
            }
            else{
                list.add(new FileLeaf(file.getAbsolutePath(),this.depth ));

            }
        }
    }
    public void print() {

        for(int i=0; i<depth ; i++ ){
            System.out.printf("│");
            System.out.printf("  ");
        }
        if(depth>0){
            System.out.printf("├──");
        }

        System.out.println(new File(name).getName());

        for(Composite f: list){
            f.print();

        }

    }
}

class FileLeaf implements  Composite{
    private int depth;
    private  String name;

    FileLeaf(String name, int depth){
        this.name=name;
        this.depth=depth;
    }

        public void print() {


            for (int i = 0; i < depth + 1; i++) {
                System.out.printf("│");
                System.out.printf("  ");
            }


            System.out.printf("├──");

            System.out.println(new File(name).getName());
        }
}


interface Composite {
    void print();
}