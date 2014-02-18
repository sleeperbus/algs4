public class Percolation {
	private WeightedQuickUnionUF uf;
	private int size;
	private int[] sitesOpen;
	private int[] sitesFull;

	// convert cordination to 1D Index.  x, y start from 1
	private int xyTo1D(int x, int y) {
		return (x - 1) + (y - 1) * this.size;
	}

	// check if indices are out of bounds
	private boolean isBeyoundIndex(int i, int j) {
		if (i <= 0 || i > this.size) throw new IndexOutOfBoundsException("row i out of bounds");
		if (j <= 0 || j > this.size) throw new IndexOutOfBoundsException("column j out of bounds");
		return true;
	}

	private void connectWithNeighbors(int i, int j) {
		// right
		if (isBeyoundIndex(i+1, j) && isOpen(i+1, j)) {
			this.uf.union(xyTo1D(i, j), xyTo1D(i+1, j));
		}
		// left
		if (isBeyoundIndex(i-1, j) && isOpen(i-1, j)) {
			this.uf.union(xyTo1D(i, j), xyTo1D(1-i, j));
		}
		// top
		if (isBeyoundIndex(i, j-1) && isOpen(i, j-1)) {
			this.uf.union(xyTo1D(i, j), xyTo1D(i, j-1));
		}
		// bottom
		if (isBeyoundIndex(i, j+1) && isOpen(i, j+1)) {
			this.uf.union(xyTo1D(i, j), xyTo1D(i, j+1));
		}
	}

	public Percolation(int N) {
		// 2 is for virtual sites, top & bottom
		this.uf = new WeightedQuickUnionUF((N*N + 2));
		this.size = N;
		this.sitesOpen = new int[N*N];
		this.sitesFull = new int[N*N];

		// connect virtual top to top rows
		for (int idx = 0; idx < this.size; idx++) {
			this.uf.union(N*N, idx);
		}
		// connect virtual bottom to bottom rows
		for (int idx = N*N - N; idx < N*N; idx++) {
			this.uf.union(N*N + 1, 0);
		}
	}

	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		if (isBeyoundIndex(i, j)) {
			int idx = this.sitesOpen[xyTo1D(i, j)];
			if (idx == 0) {
				this.sitesOpen[idx] = 1;
			}
		}
		connectWithNeighbors(i, j);
	}

	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		if (isBeyoundIndex(i, j)) {
			if (this.sitesOpen[xyTo1D(i, j)] == 1) return true;
		}
		return false;
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		return true;
	}

	// does the system percolate
	public boolean percolates() {
		return true;
	}


	public static void main(String[] args) {
		
	}
}