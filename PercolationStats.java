/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
        public PercolationStats(int n, int trials){
            new Percolation(n);
            for (int z = 0; z< trials; z++){
                Percolation.open(StdRandom.uniform(n+1),
                     StdRandom.uniform(n+1));

            }

        }


    public static void main(String[] args) {

    }
}
