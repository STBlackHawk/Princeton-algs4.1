/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date: 10/17/2018
 *  Description: Percolation for Princton Algorithm I class on Coursera
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
     private boolean[][] matrix;
     private final WeightedQuickUnionUF IdMatrix ;

    public Percolation(int n){

        if (n <= 0 ){
            throw new IllegalArgumentException
                    ("n should not be less than or equal to zero");
        }

        matrix = new boolean[n][n];
        IdMatrix =  new WeightedQuickUnionUF((matrix.length*matrix.length));


    }

    public  void open(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        int l = matrix.length;
        int i = row - 1;
        int j = col - 1;


        matrix[i][j] = true;

        if (i != 0 && matrix[i - 1][j]) {
            IdMatrix.union((((i - 1) * l) + j), ((i * l) + j));

        }
        if (j != 0 && matrix[i][j - 1]) {
            IdMatrix.union((((i) * l) + (j - 1)), ((i * l) + j));

        }
        if (j != l - 1 && matrix[i][j + 1]) {
            IdMatrix.union((((i) * l) + (j + 1)), ((i * l) + j));

        }
        if (i != l - 1 && matrix[i + 1][j]) {
            IdMatrix.union((((i + 1) * l) + (j)), ((i * l) + j));

        }


    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        return (matrix[row-1][col-1]);

    }

    public boolean isFull(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length) {
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                            + "than zero or more than n");
        }
        boolean b = false;

        if (matrix[row - 1][col - 1]) {
            for (int m = 0; m < matrix.length; m++) {
                if (matrix[0][m]) {
                    b = IdMatrix.connected((((row - 1) * matrix.length) + (col - 1)), (m));
                    if (b) break;
                }
            }

        }
        return b;
    }

    public int numberOfOpenSites() {
        int m = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[j][k]) {
                    m++;
                }
            }
        }
        return m;
    }

    public boolean percolates() {
        boolean b = false;
        for (int m = 1; m <= matrix.length; m++) {
            if(matrix[matrix.length -1][m -1]) {
                b = isFull(matrix.length, m);
                if (b) break;
            }

        }
        return b;
    }

}






