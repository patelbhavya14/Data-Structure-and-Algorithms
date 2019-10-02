/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Kinnar
 */
public class ImprovedStrassenMatrixMultiplication {
    public long improvedStrassen(int n) {
        int c[][] = new int[n][n];
        int d[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                c[i][j] = j+1;
                d[i][j] = j+1;
            }
        }
        
        long startTime = System.nanoTime();

        int ans[][] = strassenMultiplication(c, d, n);

        long stopTime = System.nanoTime();
        
        return stopTime - startTime;
    }
    
    static int[][] strassenMultiplication(int m1[][], int m2[][], int n) {
        int ans[][] = new int[n][n];
        if(n <= 512) {
//            ans[0][0] = m1[0][0] * m2[0][0];
//            int c[][] = new int[n][n];

            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        ans[i][j] += m1[i][k] * m2[k][j];
                    }
                    //System.out.print(c[i][j] + ” “);
                }
                //System.out.println();
            }
            return ans;
        }
        
        int midPt = n/2;
        int a1[][] = new int[midPt][midPt];
        int a2[][] = new int[midPt][midPt];
        int b1[][] = new int[midPt][midPt];
        int b2[][] = new int[midPt][midPt];
        int c1[][] = new int[midPt][midPt];
        int c2[][] = new int[midPt][midPt];
        int d1[][] = new int[midPt][midPt];
        int d2[][] = new int[midPt][midPt];

        for(int i=0; i<midPt; i++) {
            for(int j=0; j<midPt; j++) {
                a1[i][j] = m1[i][j];
                a2[i][j] = m2[i][j];
                b1[i][j] = m1[i][j+midPt];
                b2[i][j] = m2[i][j+midPt];
                c1[i][j] = m1[i+midPt][j];
                c2[i][j] = m2[i+midPt][j];
                d1[i][j] = m1[i+midPt][j+midPt];
                d2[i][j] = m2[i+midPt][j+midPt];
            }
        }


        int p1[][] = strassenMultiplication(a1, sub(b2,d2), midPt);
        int p2[][] = strassenMultiplication(add(a1, b1), d2, midPt);
        int p3[][] = strassenMultiplication(add(c1, d1), a2, midPt);
        int p4[][] = strassenMultiplication(d1, sub(c2, a2), midPt);
        int p5[][] = strassenMultiplication(add(a1, d1), add(a2, d2), midPt);
        int p6[][] = strassenMultiplication(sub(b1, d1), add(c2, d2), midPt);
        int p7[][] = strassenMultiplication(sub(a1, c1), add(a2, b2), midPt);


        int x1[][] = add(sub(add(p5, p4), p2),p6);
        int x2[][] = add(p1, p2);
        int x3[][] = add(p3, p4);
        int x4[][] = sub(sub(add(p1, p5), p3), p7);

        for(int i=0; i<midPt; i++) {
            for(int j=0; j<midPt; j++) {
                ans[i][j] = x1[i][j];
                ans[i][j+midPt] = x2[i][j];
                ans[i+midPt][j] = x3[i][j];
                ans[i+midPt][j+midPt] = x4[i][j];
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
