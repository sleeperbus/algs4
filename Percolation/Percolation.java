public class Percolation {
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufTemp;
    private int size;
    private boolean[] sitesOpen;

    public Percolation(int N) {
        // 2 is for virtual sites, top & bottom
        this.uf = new WeightedQuickUnionUF((N*N + 2));
        this.ufTemp = new WeightedQuickUnionUF((N*N + 1));        
        this.size = N;
        this.sitesOpen = new boolean[N*N];
    }

    // connect to top
    private void connectToTop(int i, int j) {
       this.uf.union(this.size * this.size, xyTo1D(i, j)); 
    }

    // connect to bottom
    private void connectToBottom(int i, int j) {
       this.uf.union(this.size * this.size + 1, xyTo1D(i, j)); 
    }

    // convert cordination to 1D Index.  x, y start from 1
    private int xyTo1D(int x, int y) {
        int idx = (y - 1) + (x - 1) * this.size;
        return idx;
    }

    // check if indices are out of bounds
    private boolean isBoundIndex(int i, int j) {
        if (i <= 0 || i > this.size) return false;
        if (j <= 0 || j > this.size) return false;
        return true;
    }

    private void checkIndicesBounds(int i, int j) {
        if (i <= 0 || i > this.size) 
            throw new IndexOutOfBoundsException("row i out of bounds");
        if (j <= 0 || j > this.size) 
            throw new IndexOutOfBoundsException("column j out of bounds");
    }   


    private void connectWithNeighbors(int i, int j) {
        // top
        if (isBoundIndex(i-1, j) && isOpen(i-1, j)) {
            this.uf.union(xyTo1D(i, j), xyTo1D(i-1, j));
            this.ufTemp.union(xyTo1D(i, j), xyTo1D(i-1, j));
        }

        // bottom
        if (isBoundIndex(i+1, j) && isOpen(i+1, j)) {
            this.uf.union(xyTo1D(i, j), xyTo1D(i+1, j));
            this.ufTemp.union(xyTo1D(i, j), xyTo1D(i+1, j));
        }

        // left
        if (isBoundIndex(i, j-1) && isOpen(i, j-1)) {
            this.uf.union(xyTo1D(i, j), xyTo1D(i, j-1));
            this.ufTemp.union(xyTo1D(i, j), xyTo1D(i, j-1));
        }

        // right
        if (isBoundIndex(i, j+1) && isOpen(i, j+1)) {
            this.uf.union(xyTo1D(i, j), xyTo1D(i, j+1));
            this.ufTemp.union(xyTo1D(i, j), xyTo1D(i, j+1));
        }

        // connect top and bottom node if (i, j) is top or bottom row
        if (i == 1) {
            this.uf.union(this.size*this.size, xyTo1D(i, j));
            this.ufTemp.union(this.size*this.size, xyTo1D(i, j));
        }
        if (i == this.size) 
            this.uf.union(this.size*this.size+1, xyTo1D(i, j));
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        checkIndicesBounds(i, j);
        if (!this.sitesOpen[xyTo1D(i, j)]) 
            this.sitesOpen[xyTo1D(i, j)] = true;
        connectWithNeighbors(i, j);
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkIndicesBounds(i, j);
        if (this.sitesOpen[xyTo1D(i, j)]) return true;
        return false;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkIndicesBounds(i, j);
        if (this.ufTemp.connected(this.size * this.size, xyTo1D(i, j))) return true;
        return false;
    }

    // does the system percolate
    public boolean percolates() {
        if (this.uf.connected(this.size * this.size, 
            this.size * this.size + 1)) 
            return true;
        return false;
    }

    public static void main(String[] args) {
        int size = 1;
        int count = 0;
        int n1, n2;
        boolean b1;

        Percolation percol = new Percolation(size);
        percol.open(1, 1);
    }
}
