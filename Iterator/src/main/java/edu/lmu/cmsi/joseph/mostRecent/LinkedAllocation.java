package edu.lmu.cmsi.joseph.mostRecent;

import edu.lmu.cmsi.joseph.mostRecent.IterableCollection;
import edu.lmu.cmsi.joseph.mostRecent.Node;
import edu.lmu.cmsi.joseph.mostRecent.ThisCollection;

public class LinkedAllocation<E> implements ThisCollection<E>{
	protected Node<E> firstNode = null;
	protected Node<E> lastNode = null;
	private int size;
	private int max;

	public LinkedAllocation(int num){
		max = num;
	}

	public LinkedAllocation(E[] input){
		for(int i = 0; i < input.length; i++){
			this.add(input[i]);
		}
		max = input.length;
	}

    public E getNewest(){
    	return lastNode.getValue();
    }

    public E getOldest(){
    	return firstNode.getValue();
    }

    public Node<E> getFirst(){
    	return firstNode;
    }

    public Node<E> getLast(){
    	return lastNode;
    }

    public void add(E added){
    	if(added == null){
    		throw new NullPointerException();
    	}
    	Node<E> mew = (Node<E>) new Node(added);
    	if(lastNode == null){
    		firstNode = mew;
    		lastNode = mew;
    		size++;
    	}else{
    		if(size == max){
    			firstNode = firstNode.getNext();
    			lastNode.setNext(mew);
    			lastNode = mew;
    		}else{
	    		lastNode.setNext(mew);
	    		lastNode = mew;
	    		size++;
	    	}
    	}
    }

    public int getSize(){
    	return size;
    }

    public void reset(){
    	firstNode = null;
    	lastNode = null;
    	size = 0;
    }    
}