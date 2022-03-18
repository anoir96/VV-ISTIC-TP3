package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

class BinaryHeapTest {

	@Test
	void test() {
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> Integer.compare(a, b));
		//heap vide
		assertThrows(NoSuchElementException.class, () -> heap.peek());
		//test peek
		heap.push(99);
		assertTrue(heap.peek()==99);
		
		//test count
		assertTrue(heap.count() == 1);
		
		//test pop
		heap.push(1);
		assertTrue(heap.pop()==1 && heap.pop()==99);
		assertThrows(NoSuchElementException.class, () -> heap.pop());
		
		//test count
		assertTrue(heap.count() == 0);
	}

}
