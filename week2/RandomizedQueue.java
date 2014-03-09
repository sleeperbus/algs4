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
		if (isEmpty()) {
			first = last;
			last.prev = null;
		}
		else {
			oldlast.next = last;
			last.prev = oldlast;			
		}
		N++;
	}

	public Item dequeue()                    // delete and return a random item
	{
		if (isEmpty()) throw new NoSuchElementException("Under Flow");
		Item item;
		int rndSel = StdRandom.uniform(N);
		// if random number is first item
		if (rndSel == 0) {
			item = first.item;
			first = first.next;
			first.prev = null;
		}
		// if random number is last item
		else if (rndSel == N-1) {
			item = last.item;
			last = last.prev;
			last.next = null;
		}
		// if selected number is between node 1 to node N-1		
		else {	
			Node<Item> current = first.next;		
			int n = 1;
			while ( n != rndSel) {
				current = current.next;
				n++;
			}
			item = current.item;
			current.prev.next = current.next;			
		}
		
		return item;		
	}
	public Item sample()                     // return (but do not delete) a random item
	{
		int rndNum = StdRandom.unifom(N);
		Item item;
		Node<Item> current = first;
		if (rndNum == 0) item = current.item;
		else {
			while ( n != rndNum) {
				n++;				
				current = current.next;
			}
			item = current.item;
		}
		return item;
	}
	
	public Iterator<Item> iterator()         // return an independent iterator over items in random order
	{
		return new RandomIterator<Item>();
	}
	
	// helper class
	private class RandomIterator<Item> implements<Iterator> {
		// create random Node list based on this RandomizedQueue
		public RandomIterator() {
			
		}
		
		public boolean hasNext() {
			
		}
		
		public Item next() {
			
		}
		
	}
	
	
	public static void main(String[] args)   // unit testing
	
}