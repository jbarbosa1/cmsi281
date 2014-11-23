package edu.lmu.cmsi.joseph.mostRecent;

public class Node<E>{

    private E value = null;
    private Node<E> next = null;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return this.value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public boolean hasNext(){
        return(this.next != null);
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}