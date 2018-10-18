/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date: 10/17/2018
 *  Description: Percolation for Princton Algorithm I class on Coursera
 **************************************************************************** */

import edu.princeton.cs.algs4.StdStats;
import java.lang.IllegalArgumentException;

import java.util.Arrays;
public class Percolation {
    int[][] matrix;
    int[][] IdMatrix;

    public Percolation(int n) throws IllegalArgumentException {
        if (n <= 0 ){
            throw new IllegalArgumentException
                    ("n should not be less than or equal to zero");
        }
            matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 1);
        }


    }

    public  void open(int row, int col) throws IllegalArgumentException {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        if (matrix[row - 1][col - 1] == 0) {
        }
        else {
            matrix[row - 1][col - 1] = 0;
        }
    }

    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        if (matrix[row - 1][col - 1] == 0) {
            return true;
        }

        return false;
    }

    public boolean isFull(int row, int col) {
        if (row <= 0 || row > matrix.length
                || col <= 0 || col > matrix.length ){
            throw new IllegalArgumentException
                    ("your row and coloiumn input are less "
                             + "than zero or more than n");
        }

        IdMatrix = new int[matrix.length][matrix.length];
        int[] IdArray = new int[5];
        boolean b = false;

        for (int i = 1; i < IdMatrix.length; i++) {
            for (int j = 0; j < IdMatrix.length; j++) {

                if (matrix[i][j] == 0) {
                    IdMatrix[i][j] = i * matrix.length + j;
                    IdArray[0] = IdMatrix[i][j];
                }
                if (matrix[i - 1][j] == 0) {
                    IdArray[1] = IdMatrix[i - 1][j];
                }
                if (matrix[i][j - 1] == 0) {
                    IdArray[2] = IdMatrix[i][j + 1];
                }
                if (matrix[i][j + 1] == 0) {
                    IdArray[3] = IdMatrix[i][j + 1];
                }
                if (matrix[i + 1][j] == 0) {
                    IdArray[4] = IdMatrix[i + 1][j];
                }

                int min = IdArray[0];
                for (int k = 0; k < 5; k++) {
                    if (IdArray[k] < min) {
                        min = IdArray[k];
                    }
                }
                IdMatrix[i][j] = min;
            }
            for (int j = matrix.length; j > 0; j--) {

                if (matrix[i][j] == 0) {
                    IdArray[0] = IdMatrix[i][j];
                }
                if (matrix[i - 1][j] == 0) {
                    IdArray[1] = IdMatrix[i - 1][j];
                }
                if (matrix[i][j - 1] == 0) {
                    IdArray[2] = IdMatrix[i][j + 1];
                }
                if (matrix[i][j + 1] == 0) {
                    IdArray[3] = IdMatrix[i][j + 1];
                }

                if (matrix[i + 1][j] == 0) {
                    IdArray[4] = IdMatrix[i + 1][j];
                }

                int min = IdArray[0];
                for (int k = 0; k < 4; k++) {
                    if (IdArray[k] < min) {
                        min = IdArray[k];
                    }
                }
                IdMatrix[i][j] = StdStats.min(IdArray);
            }

        }

        if (matrix[row - 1][col - 1] == 0) {
            for (int m = 0; m < matrix.length; m++)
                if (IdMatrix[row][col] == IdMatrix[0][m])
                    b = true;
        }
        else {

            b = false;
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
        for (int m = 1; m < IdMatrix.length; m++) {
            b = isFull(matrix.length - 1, m);

        }
        return b;
    }

}





