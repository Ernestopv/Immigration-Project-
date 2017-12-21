/*Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year*/
/* This is my LinkedList */
package LinkedList;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// AbstractSequentialList is used to be able to have sequential access data store as linked list behavior
// NOTE IN THIS ALGORITHM I'M USING GENERICS BECUASE IT'S EASIER  WORKING WITH DIFFERENT TYPES ALTHOUGH
//IM WORKING WITH JUST STORING STRINGS ,BUT  THAT MAKES  RELIABLE AND FASTER, 
//AND THE MOST IMPORTANT TO BE EASY TO READ MY ALGORITHM
public class MyLinkedList<E> extends AbstractSequentialList<E> {
	private int size = 0;
	private Node<E> firstObject; // first node called first object is implemented
	private Node<E> lastObject;// second node called last object is implemented

	public MyLinkedList() {
	}

	public MyLinkedList(Collection<? extends E> c) { // initialize the collection
		this();
		addAll(c);
	}

	void linkLast(E e) {
		final Node<E> l = lastObject;
		final Node<E> newNode = new Node<>(l, e, null); // put the information at the end as the lastobject , but
		lastObject = newNode; // if the linkedlist doesn't have any elements is coming as the first
		if (l == null)
			firstObject = newNode;
		else
			l.next = newNode;
		size++;
		modCount++;
	}

	void linkBefore(E e, Node<E> succ) {

		final Node<E> pred = succ.prev;
		final Node<E> newNode = new Node<>(pred, e, succ); // it creates the another link before one it's inserted
		succ.prev = newNode;
		if (pred == null)
			firstObject = newNode;
		else
			pred.next = newNode;
		size++;
		modCount++;
	}

	E unlink(Node<E> x) {
		// it helps to get of the way the element form the list (unlink)
		final E element = x.item;
		final Node<E> next = x.next;
		final Node<E> prev = x.prev;

		if (prev == null) {
			firstObject = next;
		} else {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			lastObject = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		size--;
		modCount++;
		return element;
	}

	// getFirst() it will get the first element from the list
	public E getFirst() {
		final Node<E> f = firstObject;
		if (f == null)
			throw new NoSuchElementException();
		return f.item;
	}

	// getLast() it will get the last element from the list

	public E getLast() {
		final Node<E> l = lastObject;
		if (l == null)
			throw new NoSuchElementException();
		return l.item;
	}

	// removeFirst() removes first element from the list but this is using generic element 

	public E removeFirst() {
		final Node<E> f = firstObject;
		if (f == null)
			throw new NoSuchElementException();
		final E element = f.item;
		final Node<E> next = f.next;
		f.item = null;
		f.next = null; // help GC
		firstObject = next;
		if (next == null)
			lastObject = null;
		else
			next.prev = null;
		size--;
		modCount++;
		return element;
	}

	// removesLast() it removes the last element from the list but this is using generic element 

	public E removeLast() {
		final Node<E> l = lastObject;
		if (l == null)
			throw new NoSuchElementException();
		final E element = l.item;
		final Node<E> prev = l.prev;
		l.item = null;
		l.prev = null; // help GC
		lastObject = prev;
		if (prev == null)
			firstObject = null;
		else
			prev.next = null;
		size--;
		modCount++;
		return element;
	}

	// addFirst() add an element at the top of the list
	public void addFirst(E e) {
		final Node<E> f = firstObject;
		final Node<E> newNode = new Node<>(null, e, f);
		firstObject = newNode;
		if (f == null)
			lastObject = newNode;
		else
			f.prev = newNode;
		size++;
		modCount++;
	}

	// public void to add last element to the list 
	public void addLast(E e) {
		linkLast(e);
	}

	
// this one  takes the size of the current linkedlist 
	public int size() {
		return size;
	}

	

	/**
	 * Removes all of the elements from this list. The list will be empty after this
	 * call returns.
	 */
	public void clear() {

		for (Node<E> x = firstObject; x != null;) {
			Node<E> next = x.next;
			x.item = null;
			x.next = null;
			x.prev = null;
			x = next;
		}
		firstObject = lastObject = null;
		size = 0;
		modCount++;
	}

	// get the element by the index using generic 
	public E get(int index) {
		checkElementIndex(index);
		return node(index).item;
	}

	// set and  modify the value of a current value by giving index where the element which needs to be modified and element to modify the content 
	public E set(int index, E element) {
		checkElementIndex(index);
		Node<E> x = node(index);
		E oldVal = x.item;
		x.item = element;
		return oldVal;
	}

	// add value to the linked-list but is going to be added at the last 
	public void add(int index, E element) {
		checkPositionIndex(index);

		if (index == size)
			linkLast(element);
		else
			linkBefore(element, node(index));
	}

	// remove an element given the index 
	public E remove(int index) {
		checkElementIndex(index);
		return unlink(node(index));
	}
	// identified the index from an element and this method is going to be used in checkelementIndexMehtod 
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}
// identifies the position if still there is going release true 
	private boolean isPositionIndex(int index) {
		return index >= 0 && index <= size;
	}
// this is to get and outofbounds message if it is 
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	// check element index , if there is the index , indicated by the user
	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	// check position of the index 
	private void checkPositionIndex(int index) {
		if (!isPositionIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}
	
	// this node is generic  it will get the node , by an specific index 

	Node<E> node(int index) {
		// assert isElementIndex(index);

		if (index < (size >> 1)) {
			Node<E> x = firstObject;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = lastObject;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}
	
	// remove element , this method it will remove the first element from the linkedlist 

	public E remove() {
		return removeFirst();
	}

	// this class iterates every node from the linkedlist 
	@SuppressWarnings("unused")
	private abstract class ListItr implements ListIterator<E> {
		private Node<E> lastReturned = null;
		private Node<E> next;
		private int nextIndex;
		private int expectedModCount = modCount;

		ListItr(int index) {
			// assert isPositionIndex(index);
			next = (index == size) ? null : node(index);
			nextIndex = index;
		}

		public boolean hasNext() {
			return nextIndex < size;
		}

		public E next() {
			checkForComodification();
			if (!hasNext())
				throw new NoSuchElementException();

			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.item;
		}

		final void checkForComodification() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
		}
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

	
	@Override
	public java.util.ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
