package edu.lmu.cmsi.joseph.mostRecent;

import java.util.Iterator;

public class LinkedIteratorImplementation<E> implements Iterator<E>{
    private Node<E> current = null;
    private Node<E> previous = null;
    private LinkedAllocation<E> instance = null;

    public LinkedIteratorImplementation(LinkedAllocation<E> input) {
        instance = input;
    }

    public boolean hasNext() {
        if(current == null){
            return(instance.getFirst().getValue() != null);
        }else{
            return(current.getNext().getValue() != null);
        }
    }

    public E next() {
        if(this.current == null){
            Node<E> right = instance.getFirst();
            if(right == null){
                return null;
            }else{
                current = right;
                Node<E> temp = current.getNext();
                return(temp.getValue());
            }
        }else{
            previous = current;
            current = current.getNext();
            return current.getValue();            
        }
    }

    public void remove() {
        if(previous != null){
            previous.setNext(current.getNext());
        }else{
            instance.firstNode = current.getNext();
        }   
    }
}