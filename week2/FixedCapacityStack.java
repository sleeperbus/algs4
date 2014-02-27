public class FixedCapacityStack<Item> {
	private Item[] s;
	private int N = 0;

	// generic array compilation error
	// not allowed in java
	public FixedCapacityStack(int capacity) {
//		s = new Item[capacity];
		s = (Item[]) new Object[capacity];
	}

	public boolean isEmpty() { return N == 0; }

	public void push(Item item) {
		s[N++] = item;
	}

	public Item pop() {
		return s[--N];
	}
}