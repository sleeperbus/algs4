import java.util.Iterator;

public class FixedCapacityStackOfStrings implements Iterable<String>{
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() { return N == 0; }
    public void push(String item) {
        s[N++] = item;
    }
    
    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }
    
    
    public Iterator<String> iterator() { return new ReverseArrayIterator(); }
    
    public class ReverseArrayIterator implements Iterator<String> {
    	private int i = N-1;
    	public boolean hasNext() { return i >= 0; }
    	public String next() { return s[i--]; }
    	public void remove() { throw new UnsupportedOperationException(); }
    } 
    
    public static void main(String[] args) {
    	int max = Integer.parseInt(args[0]);
    	FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
    	while (!StdIn.isEmpty()) {
    		String item = StdIn.readString();
    		if (!item.equals("-")) stack.push(item);
    		else if (stack.isEmpty()) StdOut.println("BAD INPUT");
    		else StdOut.print(stack.pop() + " ");
    	}
    	
    	// left on stack
    	StdOut.print("left on stack");
    	for (String s : stack)
    		StdOut.print(s + " ");
    	StdOut.println("End");
    }
    
}