package com.DanielShely;


import java.util.NoSuchElementException;

public class LinkedList {

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


    public void pushFront(Object data) {

        Node newNode=new Node(data,stubHead.next);
        stubHead.next=newNode;


    }

    public Object popFront() {
        Node popNode=stubHead.next;
        Object ret=null;
        if(popNode!=null) {
           ret= popNode.data;
            stubHead.next = stubHead.next.next;
            popNode.next = null;
        }

        return ret;
    }

    public LinkedListItr find(Object obj) {
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

    private class Node {
        private Object data;
        private Node next;

        Node(Object data, Node next) {
            this.data= data;
            this.next=next;
        }


    }

    public class LinkedListItr implements listIterator {

        private Node curr_node;

        private Object getData(){


            return curr_node==null?null:curr_node.data;
        }

        LinkedListItr(Node node){
            curr_node=node;
        }

        @Override
        public boolean hasNext() {
            return curr_node.next !=null;

        }

        @Override
        public Object next() throws NoSuchElementException{

            if(!(curr_node.next ==null)){
                curr_node=curr_node.next;
                return curr_node.data;
            }
            else{
                throw new NoSuchElementException();
            }
        }
    }

}


interface listIterator{

    boolean hasNext();
    Object next() throws NoSuchElementException;

}




