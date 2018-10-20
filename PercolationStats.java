/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date:10/18/2018
 *  Description:PercolationStats for Princton Algorithm I class on Coursera
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
     private int [] C;
     private double m, s, cL, cH;
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0 ){
            throw new IllegalArgumentException
                    ("n should not be less than or equal to zero");
        }
            Percolation p = new Percolation(n);
            C = new int[trials];
            for (int z = 0; z< trials; z++){
                while (!p.percolates()) {
                    p.open(StdRandom.uniform(n)+1,
                           StdRandom.uniform(n)+1);
                }
                C[z] = p.numberOfOpenSites();
            }

        }

        public double mean(){
        m = StdStats.mean(C);
        return m;
        }

        public double stddev(){
        s = StdStats.stddev(C);
        return s;
        }

        public double confidenceLo(){
        cL = mean() - (1.96/ stddev());
        return cL;
        }

        public double confidenceHi(){
        cH = mean() + (1.96/stddev());
        return cH;
        }


    public static void main(String[] args) {
    String char1 = args[0];
    String char2 = args[1];
    int n = Integer.parseInt(char1);
    int T = Integer.parseInt(char2);
    PercolationStats P = new PercolationStats(n,T);
    System.out.println("mean            "+ P.mean());
    System.out.println("stddev          "+ P.stddev());
    System.out.println("95% confiden interval = ["+P.confidenceLo()+", "+P.confidenceHi()+"]");
    }

}

