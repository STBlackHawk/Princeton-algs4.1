/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date:10/18/2018
 *  Description:PercolationStats for Princton Algorithm I class on Coursera
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats {
     private final double [] C;
     private double m, s, cL, cH;
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0 ){
            throw new IllegalArgumentException
                    ("n should not be less than or equal to zero");
        }

            C = new double [trials];
            for (int z = 0; z< trials; z++){
                Percolation p = new Percolation(n);
                int u;
                int l;
                while (!p.percolates()) {
                    u = StdRandom.uniform(1,n+1);
                    l = StdRandom.uniform(1,n+1);
                    p.open(u,l);
                }
                C[z] = ((float)p.numberOfOpenSites())/(n*n);
            }
        m = StdStats.mean(C);
        s = StdStats.stddev(C);
        cL = m - (1.96*s/(Math.sqrt(C.length)));
        cH = m + (1.96*s/(Math.sqrt(C.length)));

        }

        public double mean(){
        return m;
        }

        public double stddev(){
        return s;
        }

        public double confidenceLo(){
        return cL;
        }

        public double confidenceHi(){
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

