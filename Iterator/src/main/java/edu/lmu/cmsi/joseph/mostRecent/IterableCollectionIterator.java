package edu.lmu.cmsi.joseph.mostRecent;

import java.util.Iterator;

public class IterableCollectionIterator<E> implements Iterator<E>{
    private E[] ours;
    private int currentObject = -1;

    public IterableCollectionIterator(E[] inform) {
        ours = inform;
    }

    public boolean hasNext() {
        if(this.currentObject == ours.length){
            return false;
        }else{
            return(ours[currentObject + 1] != null);
        }
    }

    public E next() {
        if(this.currentObject < (ours.length - 1)) {
            return ours[++currentObject];
        }else{
            return null;
        }
    }

    public void remove() {
        int size = ours.length;
        for(int i = currentObject; i < (size - 1); i++){
            ours[i] = ours[i+1];
        }
        ours[size-1] = null;
    }
}