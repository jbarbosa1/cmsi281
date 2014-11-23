package edu.lmu.cmsi.joseph.mostRecent;

import java.util.Iterator;
import edu.lmu.cmsi.joseph.mostRecent.ThisCollection;
import edu.lmu.cmsi.joseph.mostRecent.IterableCollection;

public class IterableArray<E> implements ThisCollection<E>{
	private E[] ourArray;
	private int counter;
	private int currentIndex = 0;
	private int max;

	public IterableArray(){
		ourArray = (E[]) new Object[0];
		counter = 0;
		max = 0;
	}

	public IterableArray(int num){
		E[] a = (E[]) new Object[num];
		this.ourArray = a;
		this.max = num;
	} 

	public E getOldest(){
		return ourArray[0];
	}

	public E getNewest(){
		if(currentIndex > 0){
			return ourArray[currentIndex-1];
		}else{
			return ourArray[0];
		}
	}	

	public void add(E element){
		if(element == null){
			throw new NullPointerException();
		}else{
			if(currentIndex == 0){
				ourArray[currentIndex] = element;
				currentIndex++;
			}else if(currentIndex < (max)){ 
				ourArray[currentIndex] = element;
				currentIndex++;			
			}else{
				E[] here = (E[]) new Object[max];
				for(int i = 1; i < max; i++){
					here[i - 1] = ourArray[i];
				}
				ourArray = here;
				currentIndex--;
				ourArray[currentIndex] = element;
				currentIndex++;
			}
		}
	}

	public int getSize(){
		int counter = 0;
		IterableCollection<E> tester = new IterableCollection<E>(ourArray);

		Iterator<E> iter = tester.iterator();
		for(int i = 0; i < ourArray.length; i++){
			if(ourArray.length == 0){
				return counter;
			}else if(ourArray.length == 1){
				counter++;
			}else{
				while(iter.next() != null){
					counter++;
				}
			}
		}
		return counter;
	}

	public void reset(){
		ourArray = (E[]) new Object[0];
		counter = 0;
		currentIndex = 0;		
	}
}