package edu.lmu.cmsi.joseph.mostRecent;

import java.util.Iterator;
import edu.lmu.cmsi.joseph.mostRecent.IterableCollectionIterator;

public class IterableCollection<E> implements Iterable<E> {
    private E[] thisGuy;

    public IterableCollection(E[] input) {
        //thisGuy = (E[]) new Object[input.length];
        thisGuy = input;      
    }

    public Iterator<E> iterator() {
        return new IterableCollectionIterator<E>(thisGuy);
    }
}