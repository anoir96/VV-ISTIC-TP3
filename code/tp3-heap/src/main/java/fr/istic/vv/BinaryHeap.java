package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeap<T> {
	
	private Comparator<T> comparator;
	private List<T> list = new ArrayList<T>();

    public BinaryHeap(Comparator<T> comparator) {
    	this.comparator = comparator;
    }

	public T pop() {
    	if(list.isEmpty()) throw new NoSuchElementException();
    	return list.remove(0);
    }

    public T peek() {
    	if(list.isEmpty()) throw new NoSuchElementException();
    	return list.get(0);
    }

    public void push(T element) {
    	list.add(element);
    	list.sort(comparator);
    }

    public int count() {
    	return list.size();
    }
}
