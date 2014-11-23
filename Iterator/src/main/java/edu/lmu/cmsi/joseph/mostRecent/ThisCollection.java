package edu.lmu.cmsi.joseph.mostRecent;

public interface ThisCollection<E>{

	public E getOldest();

	public E getNewest();

	public void add(E element);

	public int getSize();

	public void reset();
}