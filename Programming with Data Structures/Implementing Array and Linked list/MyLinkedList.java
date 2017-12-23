package lab6;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	// Creates a default list 
	public MyLinkedList() {
	}

	// Creates a list from an array of objects
	public MyLinkedList(E[] objects) {
		super(objects);
	}

	// Returns the head element in the list
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	//Returns the last element in the list
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	//Adds an element to the beginning of the list
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		if (tail == null)
			tail = head;
	}

	// Adds an element to the end of the list
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override // Add a new element at the specified index in this list. The index of the head element is 0
	public void add(int index, E e) {
		if (index == 0)
			addFirst(e);
		else if (index >= size)
			addLast(e); // Insert last
		else { // Insert in the middle
			Node<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	//Remove the head node and return the object that is contained in the removed node.
	public E removeFirst() {
		if (size == 0)
			return null;
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null)
				tail = null;
			return temp.element;
		}

	}

	 ///Remove the last node and return the object that is contained in the removed node.
	public E removeLast() {
		if (size == 0)
			return null;
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;
			for (int i = 0; i < size - 2; i++)
				current = current.next;
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override // Remove the element at the specified position in this list. Return the element that was removed from the list.
	public E remove(int index) {
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
@Override
	public void add(E e) {
		if (head == null) {
			head = new Node<E>(e);
			size++;
		} else {
			Node<E> newNode = new Node<>(e);
			Node<E> current = head;

			while (current.next != null)
				current = current.next;
			current.next = newNode;
			size++;

		}
	}
@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
@Override
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}
	@Override
	public int size() {
		return size;
	}

	@Override // Clear the list
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override //Return true if this list contains the element e
	public boolean contains(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				return true;
			current = current.next;
		}

		return false;
	}

	@Override //Return the element at the specified index
	public E get(int index) {
		if (index < 0 || index >= size)
			return null;
		Node<E> current = head;

		for (int i = 0; i < size; i++) {
			if (i == index)
				return current.element;
			current = current.next;
		}

		return null;
	}

	@Override // Return the index of the head matching element in this list. Return -1 if no match.
	public int indexOf(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				return i;
			current = current.next;
		}
		return -1;
	}

	@Override //Return the index of the last matching element in this list.Return -1 if no match.
	public int lastIndexOf(E e) {
		Node<E> current = head;
		int lastIndex = -1;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				lastIndex = i;
			current = current.next;
		}
		return lastIndex;
	}

	@Override // Replace the element at the specified position in this listwith the specified element.
	public Object set(int index, E e) {
		if (index < 0 || index >= size)
			return null;
		Node<E> current = head;
		E temp = null;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				temp = current.element;
				current.element = e;
				break;
			}
			current = current.next;
		}
		return temp;
	}


	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", ");
			} else {
				result.append("]");
			}
		}

		return result.toString();
	}

	@Override //Override iterator() defined in Iterable
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head;

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			System.out.println("Implementation left as an exercise");
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}