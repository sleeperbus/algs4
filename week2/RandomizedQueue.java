import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	public RandomizedQueue()                 // construct an empty randomized queue
	{
		N = 0;
		prev = null;
		next = null;
	}
	
	public boolean isEmpty()                 // is the queue empty?
	{ return (first == null || last == null); }
	
	public int size()                        // return the number of items on the queue
	{ return N; }

	public void enqueue(Item item)           // add the item
	{
		if (item == null) throw new NullPointerException();
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}

	public Item dequeue()                    // delete and return a random item
	public Item sample()                     // return (but do not delete) a random item
	public Iterator<Item> iterator()         // return an independent iterator over items in random order
	public static void main(String[] args)   // unit testing
	
}