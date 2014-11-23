package edu.lmu.cmsi.joseph.mostRecent;

import java.util.Iterator;
import edu.lmu.cmsi.joseph.mostRecent.LinkedIteratorImplementation;

public class LinkedIterator<E> implements Iterable<E> {
    private LinkedAllocation thisGuy;

    public LinkedIterator(LinkedAllocation example) {
        thisGuy = example;      
    }

    public Iterator<E> iterator() {
        return new LinkedIteratorImplementation<E>(thisGuy);
    }
}