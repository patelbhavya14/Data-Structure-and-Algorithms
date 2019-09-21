package algorithms;

import java.util.Scanner;

public class DivideAndConquereMatrixMul {
    public static void main(String[] args) {
        System.out.println("Enter size of matrix:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int c[][] = new int[n][n];
        int d[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                c[i][j] = j+1;
                d[i][j] = j+1;
            }
        }

        long startTime = System.currentTimeMillis();
        int ans[][] = matrixMultiplication(c, d, n);

        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime - startTime)/1000.0);

//        for(int i=0; i<ans.length; i++) {
//            for(int j=0; j<ans.length; j++) {
//                System.out.print(ans[i][j]+ " ");
//            }
//            System.out.println();
//        }
    }

    static int[][] matrixMultiplication(int m1[][], int m2[][], int n) {
        int ans[][] = new int[n][n];
        if(n <= 2) {
            ans[0][0] = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];
            ans[0][1] = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];
            ans[1][0] = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];
            ans[1][1] = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1];

            return ans;
        }

        int a1[][] = new int[n/2][n/2];
        int a2[][] = new int[n/2][n/2];
        int b1[][] = new int[n/2][n/2];
        int b2[][] = new int[n/2][n/2];
        int c1[][] = new int[n/2][n/2];
        int c2[][] = new int[n/2][n/2];
        int d1[][] = new int[n/2][n/2];
        int d2[][] = new int[n/2][n/2];
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                a1[i][j] = m1[i][j];
                a2[i][j] = m2[i][j];
                b1[i][j] = m1[i][j+(n/2)];
                b2[i][j] = m2[i][j+(n/2)];
                c1[i][j] = m1[i+(n/2)][j];
                c2[i][j] = m2[i+(n/2)][j];
                d1[i][j] = m1[i+(n/2)][j+(n/2)];
                d2[i][j] = m2[i+(n/2)][j+(n/2)];
            }
        }


        int p1[][] = matrixMultiplication(a1, a2, n/2);
        int p2[][] = matrixMultiplication(b1, c2, n/2);
        int p3[][] = matrixMultiplication(a1, b2, n/2);
        int p4[][] = matrixMultiplication(b1, d2, n/2);
        int p5[][] = matrixMultiplication(c1, a2, n/2);
        int p6[][] = matrixMultiplication(d1, c2, n/2);
        int p7[][] = matrixMultiplication(c1, b2, n/2);
        int p8[][] = matrixMultiplication(d1, d2, n/2);


        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                ans[i][j] = p1[i][j]+p2[i][j];
                ans[i][j+n/2] = p3[i][j]+p4[i][j];
                ans[i+n/2][j] = p5[i][j]+p6[i][j];
                ans[i+n/2][j+n/2] = p7[i][j]+p8[i][j];
            }
        }
        return ans;
    }
}
