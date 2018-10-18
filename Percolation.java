/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date: 10/17/2018
 *  Description: Percolation for algortihm class in Princton on Coursera
 **************************************************************************** */

import java.util.Arrays;
import java.lang.*;

public class Percolation {
    int [][] matrix;

    public Percolation (int n){
        if ( n < 1) throw java.lang.IllegalArgumentException("n should be >= 1");
        else
        matrix = new int[n][n];
       for (int i = 0; i < n ; i++){
           Arrays.fill(matrix[i], 1);
       }


    }
    public void open(int row, int col){
        if (matrix[row][col] == 0 ) {
        }
        else {
            matrix [row][col] = 1;
        }
    }

    public boolean  isOpen (int row, int col){

        if (matrix[row][col] == 0 ) {
            return true;
        }

       return false;
    }

    public boolean isFull (int row, int col){
        if (matrix[row][col] > 0 ) {
            return true;
        }

        return false;

    }

    public int numberOfOpenSites(){
        int m = 0;
        for (int j = 0; j < matrix.length ;  j++){
            for (int k = 0 ; k< matrix.length; k++){
                if (matrix[j][k] == 0 ){
                    m++;
                }
            }
        }
        return m;
    }

    public boolean percolates(){
        int [][] IdMatrix = new int [matrix.length][matrix.length];
        for (int i= 1; i <= IdMatrix.length; i++){
            if (matrix[1][i] == 1) {
                IdMatrix[1][i] = i;
            }
        }

        for (int j = 2; j <= IdMatrix.length ;  j++){
            for (int k = 1 ; k<= IdMatrix.length; k++){
                if (matrix[j-1][k] == 1 ){
                    IdMatrix[j][k] = IdMatrix[j-1][k];

                }
            }
        }
    }

    public static void main(String[] args) {



    }
}
