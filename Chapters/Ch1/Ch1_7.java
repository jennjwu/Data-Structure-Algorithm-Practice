/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch1;

/**
 *
 * @author jennjwu
 */
public class Ch1_7 {
    public static void main(String[] args) {
        int[][] test = new int[][] {
            {1,1,2,4,5},
            {1,1,1,3,0},
            {1,5,3,2,1}
        };
        
        setZeroes(test);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println("");
        }
    }
    
    
    public static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length]; //how long the matrix is
        boolean[] column = new boolean[matrix[0].length]; //how wide it is
        
        
        for (int i = 0; i < matrix.length; i++) {
            //for rows
            for (int j = 0; j < matrix[0].length; j++) {
                //for each column in a row
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        
    }
}
