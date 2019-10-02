/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Random;

/**
 *
 * @author thakk
 */
public class TraditionalMatrixMultiplication {
    public long traditional(int n) {

        Random r =new Random();
       int a[][] = new int[n][n];
       int b[][] = new int[n][n];
       for(int i=0; i<n; i++) {
           for(int j=0; j<n; j++) {
               a[i][j] = r.nextInt(10)+1;
               b[i][j] = r.nextInt(10)+1;
           }
       }

       long startTime = System.nanoTime();

       int c[][] = new int[n][n];

       for(int i=0; i<n; i++) {
           for (int j = 0; j < n; j++) {
               c[i][j] = 0;
               for (int k = 0; k < n; k++) {
                   c[i][j] += a[i][k] * b[k][j];
               }
               //System.out.print(c[i][j] + ” “);
           }
           //System.out.println();
       }

       long stopTime = System.nanoTime();
       return (stopTime - startTime);
   }

}

