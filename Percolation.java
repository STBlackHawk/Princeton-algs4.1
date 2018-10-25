/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date: 10/17/2018
 *  Description: Percolation for Princton Algorithm I class on Coursera
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private boolean[][] matrix;
    private final WeightedQuickUnionUF IdMatrix ;
    private final WeightedQuickUnionUF Percolate;

    private int NoOpen;



    public Percolation(int n){

        if (n <= 0 ){
            throw new IllegalArgumentException
                    ("n should not be less than or equal to zero");
        }

        matrix = new boolean[n][n];
        IdMatrix =  new WeightedQuickUnionUF((matrix.length*matrix.length)+1);
        Percolate =  new WeightedQuickUnionUF((matrix.length*matrix.length)+2);
        NoOpen = 0;




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



        if (!isOpen(row, col)) {
            int r;
            matrix[i][j] = true;
            NoOpen++;

            if (i == 0){
                IdMatrix.union((i*l)+j,(matrix.length * matrix.length));
                Percolate.union((i*l)+j,(matrix.length * matrix.length));
            }

            if(i == l-1){
                Percolate.union((i*l)+j,(matrix.length * matrix.length)+1);
            }


            if (i != 0 && matrix[i-1][j]){
                IdMatrix.union((((i - 1) * l) + j), ((i * l) + j));
                Percolate.union((((i - 1) * l) + j), ((i * l) + j));
            }
            if (j != 0 && matrix[i][j - 1]) {
                IdMatrix.union((((i) * l) + (j - 1)), ((i * l) + j));
                Percolate.union((((i) * l) + (j - 1)), ((i * l) + j));
            }
            if (j != l - 1 && matrix[i][j + 1]) {
                IdMatrix.union((((i) * l) + (j + 1)), ((i * l) + j));
                Percolate.union((((i) * l) + (j + 1)), ((i * l) + j));
            }
            if (i != l - 1 && matrix[i + 1][j]) {
                IdMatrix.union((((i + 1) * l) + (j)), ((i * l) + j));
                Percolate.union((((i + 1) * l) + (j)), ((i * l) + j));
            }



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
        if(isOpen(row,col)) {
            b =  IdMatrix.connected(((row - 1) * matrix.length) + (col - 1),
                                      (matrix.length * matrix.length));
        }
        return b;
    }

    public int numberOfOpenSites() {
        return NoOpen;
    }

    public boolean percolates() {
      return Percolate.connected(
              (matrix.length * matrix.length),
              (matrix.length * matrix.length)+1);
    }

}




