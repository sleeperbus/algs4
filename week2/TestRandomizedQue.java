import static org.junit.Assert.*;

public class TestRandomizedQue {
	public void TestRandomizedQue() {

	}

	public void testIsEmpty() {
		StdOut.println("isEmpty test");
		int testInt = 10;			

		RandomizedQueue<Integer> randQue = new RandomizedQueue<Integer>();

		assertEquals(true, randQue.isEmpty());

		randQue.enqueue(testInt);
		assertEquals(false, randQue.isEmpty());
	}

	public void testSize() {
		StdOut.println("size test");

		RandomizedQueue<Integer> randQue = new RandomizedQueue<Integer>();
		randQue.enqueue(10);
		randQue.enqueue(20);
		randQue.enqueue(30);
		randQue.dequeue();

		assertEquals(2, randQue.size());
	}

	public void testEnqueue() {
		StdOut.println("enqueue test");
		RandomizedQueue<Integer> randQue = new RandomizedQueue<Integer>();

		randQue.enqueue(10);
		randQue.enqueue(20);
		randQue.enqueue(30);
		randQue.enqueue(40);
		randQue.enqueue(50);
		randQue.enqueue(60);
		randQue.enqueue(70);
		randQue.enqueue(80);
		randQue.enqueue(90);

		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
		StdOut.println("dequeue number: " + randQue.dequeue());
	}


	public static void main(String[] args) {

		TestRandomizedQue test = new TestRandomizedQue();

		test.testIsEmpty();
		test.testSize();
		test.testEnqueue();
	}





}