public class PercolationStats {
	private int gridSize;
	private int exTimes;
    private static double percolMean;
    private static double percolStddev;
    private static double confidence95 = 1.96;
    private double [] ratio;

    // return number of opened sites to percolates
    private int numOfOpenSitesToPercolates(int size) {
        int n1, n2;
        int openedSitesCount = 0;

        Percolation percol = new Percolation(size);
        while (percol.percolates() == false) {
            n1 = StdRandom.uniform(1, size+1);
            n2 = StdRandom.uniform(1, size+1);
            if (!percol.isOpen(n1, n2)) {
                openedSitesCount++;
                percol.open(n1, n2);
            }
        }
        return openedSitesCount;
    }


	// perform T independent computations experiments on N by N grid
	public PercolationStats(int N, int T) {
		this.gridSize = N;
		this.exTimes = T;
        this.ratio = new double[T];
        int count;

        for (int idx = 0; idx < this.exTimes; idx++) {
            count = numOfOpenSitesToPercolates(N);
            this.ratio[idx] = Float.valueOf(count)/Float.valueOf(N*N);
            StdOut.printf("count %d, %d of %d, ratio %f.\n", count, idx+1, T, this.ratio[idx]);
        }
        this.percolMean = StdStats.mean(ratio);
        this.percolStddev = StdStats.stddev(ratio);
	}

	// sample mean of percolation threshold
	public double mean() {
        return this.percolMean;
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
        return this.percolStddev;
	}

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return 0.0;
    }

    // returns uppper bound of the 95% confidence interval
    public double confidenceHi() {
        return 0.0;
    }    

    // test client
    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(20, 100);
        double mean = test.mean();
        double stddev = test.stddev();

        StdOut.printf("mean\t\t\t: %f\n", mean);
        StdOut.printf("stddev\t\t\t: %f\n", stddev);
    }
}
