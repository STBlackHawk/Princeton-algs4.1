/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class PercolationStats {

    int o = 0;
    public PercolationStats(int n, int trials){
            new Percolation(n);

            for (int z = 0; z< trials; z++){
                Percolation.open(StdRandom.uniform(n+1),
                     StdRandom.uniform(n+1));
                    o = o + Percolation.numberOfOpenSites();
            }

        }
        public double mean(){
         double m = o/trials;

        }


    public static void main(String[] args) {

    }
}
