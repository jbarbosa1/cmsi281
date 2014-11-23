package edu.lmu.cmsi.joseph.mostRecent;

import edu.lmu.cmsi.joseph.mostRecent.IterableCollection;
import edu.lmu.cmsi.joseph.mostRecent.IterableCollectionIterator;
import java.util.ArrayList;

public class HasArrayList<E> implements ThisCollection<E>{
	private int occupancy;
	private ArrayList<E> thisArray;

	public HasArrayList(int size){
		if(size < 0){
			throw new IllegalArgumentException("Can't have a negative size");
		}else{
			thisArray = new ArrayList<E>(size);
			occupancy = size;
		}
	}

	public E getOldest(){
		return thisArray.get(0);
	}

	public E getNewest(){
		return thisArray.get(thisArray.size() - 1);
	}

	public void add(E element){
		if(element == null){
			throw new NullPointerException();
		}
		else{
			if(thisArray.size() == occupancy){
				thisArray.remove(0);
				thisArray.add(element);
			}else{
				thisArray.add(element);
			}
		}
	}

	public int getSize(){
		return thisArray.size();
	}

	public void reset(){
		ArrayList<E> temp = new ArrayList<E>(0);
		thisArray = temp;
	}
}