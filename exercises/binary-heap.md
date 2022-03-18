# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer

1. La partition est : Pour pop() on a si il renvoie un élément ou renvoie une exception. Pour peek() renvoie un élément sans l'enlever ou une exception. Pour push() ajouter et tri les éléments.


2. Les tests de l'étape précedente sont les suivants: 

```java
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
```
Pour cette étape, on a ajouté l'appel de la méthode count().

3. Pas de condition à 2 conditions

4. PIT a généré 6 mutations pour un score de 100%.


