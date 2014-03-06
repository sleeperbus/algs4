import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private int N;						// size of deque
	private Node<Item> first;			// top of deque
	private Node<Item> last;			// bottom of deque

	// helper linked list class
	private class Node<Item> {
		private Item item;
		private Node<Item> next;
		private Node<Item> prev;
	}

	/**
	 * Initializes an empty deque
	 */
	public Deque() {
		first = null;
		last = null;
		N = 0;
	}

	/**
	 * Is this deque empty?
	 * @return true if deque is empty; false otherwise
	 */
	public boolean isEmpty() { return (first == null || last == null); }

	/**
	 * Returns the number of items in this deque
	 * @return the number of items in this deque
	 */
	public int size() { return N; }

	/**
	 * Adds the item to top of this deque
	 * @param item the item to add
	 */
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException();
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.prev = null;
		if (isEmpty()) {
			last = first;
			first.next = null;
		}
		else {
			first.next = oldfirst;
			oldfirst.prev = first;
		}
		N++;
	}

	/**
	 * Adds the item to bottom of this deque
	 * @param item the item to add
	 */
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException();
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
			last.prev = null;
		}
		else {
			last.prev = oldlast;
			oldlast.next = last;
		}
	}

	/**
	 * Removes the item from top of the deque 
	 * @return the item from top of the deque
	 * @throw java.util.NoSuchElementException if this deque is empty
	 */
	public Item removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("Deque Underflow");
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		else first.prev = null;

		N--;
		return item;
	}

	/**
	 * Removes the item from bottom of the deque 
	 * @return the item from bottom of the deque
	 * @throw java.util.NoSuchElementException if this deque is empty
	 */
	public Item removeLast() {
		if (isEmpty()) throw new NoSuchElementException("Deque Underflow");
		Item item = last.item;
		last = last.prev;
		if (isEmpty()) first = null;
		else last.next = null;

		N--;
		return item;
	}

	public Iterator<Item> iterator() { 
		return new ListIterator<Item>(first);		
	}

	// an iterator, doesn't implements remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() { return current != null; }
		public void remove() { throw new UnsupportedOperationException(); }
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {

	}
}