public class PercolationStats {
    private double percolMean;
    private double percolStddev;
    private double confidence95 = 1.96;
    private int gridSize;
    private int exTimes;
    private double [] ratio;

    public PercolationStats(int N, int T) {
        this.gridSize = N;
        this.exTimes = T;
        this.ratio = new double[T];
        int count;

        for (int idx = 0; idx < this.exTimes; idx++) {
            count = numOfOpenSitesToPercolates(this.gridSize);
            this.ratio[idx] = Double.valueOf(count)
                    / Double.valueOf(this.gridSize*this.gridSize);
        }
        this.percolMean = StdStats.mean(ratio);
        this.percolStddev = StdStats.stddev(ratio);
    }

    // return number of opened sites to percolates
    private int numOfOpenSitesToPercolates(int size) {
        int n1, n2;
        int openedSitesCount = 0;

        Percolation percol = new Percolation(size);
        while (!percol.percolates()) {
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
        return 
        (
            this.percolMean 
            - (
                (this.confidence95 * this.percolStddev) 
                / Math.sqrt(this.exTimes)
                )
        );
    }

    // returns uppper bound of the 95% confidence interval
    public double confidenceHi() {
        return (this.percolMean 
            + ((this.confidence95 * this.percolStddev) 
                / Math.sqrt(this.exTimes)));
    }    

    // test client
    public static void main(String[] args) {
        int p1 = Integer.parseInt(args[0]);
        int p2 = Integer.parseInt(args[1]);

        PercolationStats test = new PercolationStats(p1, p2);
        double mean = test.mean();
        double stddev = test.stddev();
        double confiHi = test.confidenceHi();
        double confiLo = test.confidenceLo();

        StdOut.printf("mean\t\t\t: %f\n", mean);
        StdOut.printf("stddev\t\t\t: %f\n", stddev);
        StdOut.println(confiLo);
        StdOut.println(confiHi);
    }
}
