package algorithms;

import java.util.Random;
import java.util.Scanner;

public class OptimizedStrassenMatrixMul {
    public static void main(String[] args) {
        System.out.println("Enter size of matrix:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Random r = new Random();
        int c[][] = new int[n][n];
        int d[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                c[i][j] = r.nextInt(10);
                d[i][j] = r.nextInt(10);
            }
        }

        long startTime = System.nanoTime();

        int ans[][] = matrixMultiplication(c, d, n);

        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime)/1000000000.0);

//        for(int i=0; i<ans.length; i++) {
//            for(int j=0; j<ans.length; j++) {
//                System.out.print(ans[i][j]+ " ");
//            }
//            System.out.println();
//        }
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

    static int[][] matrixMultiplication(int m1[][], int m2[][], int n) {
        int ans[][] = new int[n][n];
        if(n == 1) {
            return matrixMultiplication(m1, m2);
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


        int p1[][] = matrixMultiplication(a1, sub(b2,d2), n/2);
        int p2[][] = matrixMultiplication(add(a1, b1), d2, n/2);
        int p3[][] = matrixMultiplication(add(c1, d1), a2, n/2);
        int p4[][] = matrixMultiplication(d1, sub(c2, a2), n/2);
        int p5[][] = matrixMultiplication(add(a1, d1), add(a2, d2), n/2);
        int p6[][] = matrixMultiplication(sub(b1, d1), add(c2, d2), n/2);
        int p7[][] = matrixMultiplication(sub(a1, c1), add(a2, b2), n/2);


        int x1[][] = add(sub(add(p5, p4), p2),p6);
        int x2[][] = add(p1, p2);
        int x3[][] = add(p3, p4);
        int x4[][] = sub(sub(add(p1, p5), p3), p7);

        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                ans[i][j] = x1[i][j];
                ans[i][j+n/2] = x2[i][j];
                ans[i+n/2][j] = x3[i][j];
                ans[i+n/2][j+n/2] = x4[i][j];
            }
        }

        return ans;
    }

    static int[][] add(int m1[][], int m2[][]) {
        int add[][] = new int[m1.length][m1.length];

        for(int i=0; i<m1.length; i++) {
            for(int j=0; j<m2.length; j++) {
                add[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return add;
    }

    static int[][] sub(int m1[][], int m2[][]) {
        int sub[][] = new int[m1.length][m1.length];

        for(int i=0; i<m1.length; i++) {
            for(int j=0; j<m2.length; j++) {
                sub[i][j] = m1[i][j] - m2[i][j];
            }
        }

        return sub;
    }
}
