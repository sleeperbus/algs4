//import org.junit.*;
//import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class TestDeque {
	public void TestDeque() {

	}

	public void testIsEmpty() {
		StdOut.println("isEmpty test");
		int testInt = 10;
		Deque<Integer> deque = new Deque<Integer>();

		assertEquals(true, deque.isEmpty());

		deque.addFirst(testInt);
		assertEquals(false, deque.isEmpty());

		deque.removeFirst();
		assertEquals(true, deque.isEmpty());
	}	

	public void testSize() {
		StdOut.println("size test");
		Deque<Integer> deque = new Deque<Integer>();

		assertEquals(0, deque.size());

		deque.addFirst(10);
		deque.addFirst(20);
		deque.addFirst(30);
		deque.removeLast();
		deque.addFirst(30);
		deque.removeLast();

		assertEquals(2, deque.size());
	}

	public void testAddFirst() {
		StdOut.println("addFirst test");
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(10);
		assertEquals(10, (int)deque.removeFirst());

		deque.addFirst(10);
		deque.addFirst(20);
		deque.addFirst(30);
		assertEquals(30, (int)deque.removeFirst());
	}

	public void testAddLast() {
		StdOut.println("addLast test");
		Deque<Integer> deque = new Deque<Integer>();

		deque.addLast(10);
		assertEquals(10, (int)deque.removeFirst());

		deque.addLast(10);
		deque.addLast(20);
		deque.addLast(30);
		deque.addLast(40);
		deque.addFirst(50);
		assertEquals(40, (int)deque.removeLast());
	}

	public void testRemoveFirst() {
		StdOut.println("removeFirst test");
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(10);
		assertEquals(10, (int)deque.removeFirst());

		deque.addFirst(10);
		deque.addLast(20);
		deque.addFirst(30);
		deque.addLast(40);
		deque.removeFirst();

		assertEquals(10, (int)deque.removeFirst());
	}

	public void testRemoveLast() {
		StdOut.println("removeLast test");
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(10);
		deque.addFirst(20);
		deque.addFirst(30);
		assertEquals(10, (int)deque.removeLast());

		deque.addLast(40);
		assertEquals(40, (int)deque.removeLast());
	}

	public void testIterator() {
		StdOut.println("removeLast test");
		Deque<Integer> deque = new Deque<Integer>();
		
	}



	public static void main(String[] args) {
		TestDeque test = new TestDeque();
		test.testIsEmpty();
		test.testSize();
		test.testAddFirst();
		test.testAddLast();
		test.testRemoveFirst();
		test.testRemoveLast();
	}
	
}