package algorithms;

import javafx.scene.Scene;

import java.util.Scanner;

public class MatrixEmpiricalStudy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of matrix");
        int n = in.nextInt();
        TraditionalMatrixMul trad = new TraditionalMatrixMul();
        StrassenMatrixMul stras = new StrassenMatrixMul();

    }


}
