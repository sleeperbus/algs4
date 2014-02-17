public class Percolation {
	private WeightedQuickUnionUF uf;
	private int size;
	private int cordinationToIndex(int i, int j) {
		return i;
	}

	public Percolation(int N) {
		this.uf = new WeightedQuickUnionUF(N*N);
		this.rowLen = this.columnLen = N;
	}

	public void open(int i, int j) {
	}

	public boolean isOpen(int i, int j) {
		return true;
	}

	public boolean isFull(int i, int j) {
		return true;
	}

	public boolean percolates() {
		return true;
	}


	public static void main(String[] args) {
		
	}
}