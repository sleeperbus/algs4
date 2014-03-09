import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	private class Node<Item> {
		Item item;
		Node<Item> next;
		Node<Item> prev;
	}

	// construct an empty randomized queue
	public RandomizedQueue()                 
	{
		N = 0;
		first = null;
		last = null;
	}

	// is the queue empty?
	public boolean isEmpty() 
	{ return (first == null || last == null); }

	// return the number of items on the queue	
	public int size() { return N; }

	// add the item
	public void enqueue(Item item)
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

	// delete and return a random item
	public Item dequeue()                    
	{
		if (isEmpty()) throw new NoSuchElementException("Under Flow");
		Item item;
		int rndSel = StdRandom.uniform(N);
		// if random number is first item
		if (rndSel == 0) {
			item = first.item;
			first = first.next;
			if (first != null) first.prev = null;
			N--;
			return item;
		}
		// if random number is last item
		else if (rndSel == N-1) {
			item = last.item;
			last = last.prev;
			last.next = null;
			N--;
			return item;
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
			N--;
			return item;
		}
	}

	// return (but do not delete) a random item
	public Item sample()                     
	{
		int rndNum = StdRandom.uniform(N);
		Item item;
		Node<Item> current = first;
		if (rndNum == 0) item = current.item;
		else {
			int n = 1;
			current = current.next;
			while ( n != rndNum) {
				current = current.next;
				n++;				
			}
			item = current.item;
		}
		return item;
	}
	
	// return an independent iterator over items in random order
	public Iterator<Item> iterator() { 
		return new RandomIterator<Item>(N, first); 
	}
	
	// helper class
	private class RandomIterator<Item> implements Iterator<Item> {
		private Item[] items;
		private int index;

		// create random Node list based on this RandomizedQueue
		public RandomIterator(int arrSize, Node<Item> first) {
			items = (Item[]) new Object[arrSize];
			Node<Item> current = first;
			index = 0;

			while (current != null) {
				items[index] = current.item;
				current = current.next;
				index++;
			}

			// shuffle
			index = 0;
			StdRandom.shuffle(items);
		}
		
		public boolean hasNext() { return index+1 >= items.length; }
		public void remove() { throw new UnsupportedOperationException(); }
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = items[index];
			index++;
			return item;
		}
	}
	
	
	public static void main(String[] args)   // unit testing
	{

	}
	
}