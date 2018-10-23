/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date: 10/17/2018
 *  Description: Percolation for Princton Algorithm I class on Coursera
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
     private int[][] matrix;
     private WeightedQuickUnionUF IdMatrix;

    public Percolation(int n){

        if (n <= 0 ){
            throw new IllegalArgumentException
                    ("n should not be less than or equal to zero");
        }
            matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = 1;
        }


    }

    public  void open(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        if (matrix[row -1][col -1] == 0) {
        }
        else {
            matrix[row - 1][col -1] = 0;
        }
    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        if (matrix[row-1][col-1] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length) {
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                            + "than zero or more than n");
        }

        int l = matrix.length;
        IdMatrix = new WeightedQuickUnionUF((l*l));
        boolean b = false;


        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (matrix[i][j] == 0) {

                    if (i != 0 && matrix[i - 1][j] == 0) {
                        IdMatrix.union((((i - 1) * l) + j), ((i * l) + j));

                    }
                    if (j != 0 && matrix[i][j - 1] == 0) {
                        IdMatrix.union((((i) * l) + (j - 1)), ((i * l) + j));

                    }
                    if (j != l - 1 && matrix[i][j + 1] == 0) {
                        IdMatrix.union((((i) * l) + (j + 1)), ((i * l) + j));

                    }
                    if (i != l - 1 && matrix[i + 1][j] == 0) {
                        IdMatrix.union((((i + 1) * l) + (j)), ((i * l) + j));

                    }

                }
            }

        }

        if (matrix[row - 1][col - 1] == 0) {
            for (int m = 0; m < l; m++) {
                if (matrix[0][m] == 0 ) {
                    b = IdMatrix.connected((((row - 1) * l) + (col - 1)), (m));
                    if (b)  break;
                }
            }

        }
        return b;
    }

    public int numberOfOpenSites() {
        int m = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[j][k] == 0) {
                    m++;
                }
            }
        }
        return m;
    }

    public boolean percolates() {
        boolean b = false;
        for (int m = 1; m < matrix.length; m++) {
            b = isFull(matrix.length - 1, m);

        }
        return b;
    }

}

//Checking new credentials





