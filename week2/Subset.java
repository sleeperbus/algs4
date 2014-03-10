public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randQue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            randQue.enqueue(item);
        }

        for (int i = 0; i < k; i++) {
            String item = randQue.dequeue();
            StdOut.println(item);
        }
    }
}