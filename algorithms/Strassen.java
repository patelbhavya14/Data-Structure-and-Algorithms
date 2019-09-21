/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author thakk
 */
public class Strassen {

    /**
     * @param args the command line arguments
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] Result = new int[n][n];
        if (n == 1) {
            Result[0][0] = A[0][0] * B[0][0];
        } else{

            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);

            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            int[][] P = multiply(add(A11, A22), add(B11, B22));
            int[][] Q = multiply(add(A21, A22), B11);
            int[][] R = multiply(A11, sub(B12, B22));
            int[][] S = multiply(A22, sub(B21, B11));
            int[][] T = multiply(add(A11, A12), B22);
            int[][] U = multiply(sub(A21, A11), add(B11, B12));
            int[][] V = multiply(sub(A12, A22), add(B21, B22));

            int[][] C11 = add(sub(add(P, S), T), V);
            int[][] C12 = add(R, T);
            int[][] C21 = add(Q, S);
            int[][] C22 = add(sub(add(P, R), Q), U);

            join(C11, Result, 0, 0);
            join(C12, Result, 0, n / 2);
            join(C21, Result, n / 2, 0);
            join(C22, Result, n / 2, n / 2);

        }
        return Result;
    }

    public int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] Calculate = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Calculate[i][j] = A[i][j] + B[i][j];
            }
        }
        return Calculate;
    }
    private int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] Calculate = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Calculate[i][j] = A[i][j] - B[i][j];
            }
        }
        return Calculate;
    }

    public void split(int[][] P, int[][] C, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                C[i1][j1] = P[i2][j2];
            }
        }
    }

    public void join(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                P[i2][j2] = C[i1][j1];
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Divide & Conquer\n");

        Strassen sample = new Strassen();

        System.out.println("Enter order n :");
        int N = scan.nextInt();

//        System.out.println("Enter order of matrix A\n");
//        int[][] A = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                A[i][j] = scan.nextInt();
//            }
//        }
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 10);
            }
        }

//        System.out.println("Enter order of matrix B\n");
//        int[][] B = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                B[i][j] = scan.nextInt();
//            }
//        }
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 10);
            }
        }
        long startTime = System.nanoTime();
        int[][] C = sample.multiply(A, B);

        System.out.println("\nProduct of matrices A and  B is : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.print(C[i][j] + " ");
            }
//            System.out.println();
        }
        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime) / 1000000000.0);
    }

}