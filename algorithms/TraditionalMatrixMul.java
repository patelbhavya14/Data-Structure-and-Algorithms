package algorithms;

import java.util.Random;
import java.util.Scanner;

public class TraditionalMatrixMul {
    public static void main(String[] args) {
        System.out.println("Enter size of matrix:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int a[][] = new int[n][n];
        int b[][] = new int[n][n];
        Random r = new Random();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                a[i][j] = j+1;
                b[i][j] = j+1;
            }
        }

        long startTime = System.nanoTime();

        int c[][] = matrixMultiplication(a, b);

        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime)/1000000000.0);
    }

    static int[][] matrixMultiplication(int m1[][], int m2[][]) {
        int ans[][] = new int[m1.length][m2.length];
        int n = m1.length;

        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = 0;
                for (int k=0; k<n; k++) {
                    ans[i][j] += m1[i][k] * m1[k][j];
                }
                //System.out.print(ans[i][j] + " ");
            }
            //System.out.println();
        }

        return ans;
    }

}

