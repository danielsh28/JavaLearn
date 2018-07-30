package com.DanielShely;


import java.util.NoSuchElementException;

public class LinkedList<T> {

   private  Node stubHead;
    private long size;


    public LinkedList() {

        this.stubHead=new Node(null,null);
        size=0;


    }

    public long size() {
        return this.size;
    }
    public boolean isEmpty(){
        return (stubHead.next==null);
    }


    public void pushFront(T data) {

        Node newNode=new Node(data,stubHead.next);
        stubHead.next=newNode;


    }

    public T popFront() {
        Node popNode=stubHead.next;
        T ret=null;
        if(popNode!=null) {
           ret =  (T) popNode.data;
            stubHead.next = stubHead.next.next;
            popNode.next = null;
        }

        return ret;
    }

    public LinkedListItr find(T obj) {
         LinkedListItr itr = this.begin();

         while(itr.hasNext()){

             if(itr.curr_node.next.data.equals(obj)){
                 return(itr);
             }
             itr.next();
         }
         return(new LinkedListItr(new Node(null, null)));


    }

    public LinkedListItr begin() {

        return new LinkedListItr(stubHead);
    }

    private  class  Node <T> {
        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data= data;
            this.next=next;
        }


    }

     class LinkedListItr implements listIterator {

        private Node curr_node;
        /* private method to peek current node data without increment to next node*/
        private T getData(){


            return curr_node==null?null: (T) curr_node.data;
        }

        LinkedListItr(Node node){
            curr_node=node;
        }


        public boolean hasNext() {
            return curr_node.next !=null;

        }


        public T next() throws NoSuchElementException{

            if(!(curr_node.next ==null)){
                curr_node=curr_node.next;
                return (T) curr_node.data;
            }
            else{
                throw new NoSuchElementException();
            }
        }
    }

}


interface listIterator<T>{

    boolean hasNext();

   T next() throws NoSuchElementException;

}







