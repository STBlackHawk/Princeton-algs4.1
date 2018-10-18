/* *****************************************************************************
 *  Name:Shahin Taghikhani
 *  Date: 10/17/2018
 *  Description: Percolation for algortihm class in Princton on Coursera
 **************************************************************************** */

import java.util.Arrays;
import java.lang.*;
import java.util.Collections;

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
        int [] IdArray = new int[4];

        for (int i= 1; i < IdMatrix.length; i++){
            for ( int j=0; j < IdMatrix.length; j++){

                if (matrix[i][j] == 0) {
                    IdMatrix[i][j] = i*matrix.length + j;
                    IdArray[0] = IdMatrix[i][j] ;
                }
                if(matrix[i-1][j] == 0){
                    IdArray[1] = IdMatrix[i-1][j];
                }
                if(matrix[i][j-1] == 0){
                    IdArray[2] = IdMatrix[i][j+1];
                }
                if(matrix[i][j+1] == 0){
                    IdArray[3] = IdMatrix[i][j+1];
                }
                int min = IdArray[0];
                for ( int k = 0; k<4; k++){
                    if (IdArray[k] < min){
                        min = IdArray[k];
                    }
                }
                IdMatrix[i][j] = min;
            }
            for ( int j=matrix.length; j > 0; j--){

                if (matrix[i][j] == 0) {
                    IdArray[0] = IdMatrix[i][j] ;
                }
                if(matrix[i-1][j] == 0){
                    IdArray[1] = IdMatrix[i-1][j];
                }
                if(matrix[i][j-1] == 0){
                    IdArray[2] = IdMatrix[i][j+1];
                }
                if(matrix[i][j+1] == 0){
                    IdArray[3] = IdMatrix[i][j+1];
                }
                int min = IdArray[0];
                for ( int k = 0; k<4; k++){
                    if (IdArray[k] < min){
                        min = IdArray[k];
                    }
                }
                IdMatrix[i][j] = min;
            }



            

        }




        for (int j = 2; j <= IdMatrix.length ;  j++){
            for (int k = 1 ; k<= IdMatrix.length; k++){
                if (matrix[j-1][k] == 1 ){


                }
            }
        }
    }

    public static void main(String[] args) {



    }
}
