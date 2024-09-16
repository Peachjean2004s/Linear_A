import java.util.Arrays;
import java.util.Scanner;

public class Det66051068{
    public static void main(String[] args) {
        int[][] mat = InputMatrix();
        priint(mat);
        //int[][] m = { { 1, 2, 3, 0 }, { 0, 3, 5, 1 }, { 0, 1, 9, -6 }, { 1, -5, -2, 8 } };
        System.out.println("Determinant is : " + Determinant(mat));

    }

    private static int[][] InputMatrix() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] Matrix = new int[m][n];
        MatrixIsSquare(Matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return Matrix;
    }

    private static void MatrixIsSquare(int[][] Matrix) {
        if (Matrix[0].length != Matrix.length) {
            System.out.println("CANT FIND DET");
            System.exit(0);
        }
    }

    private static int[][] GetCofactor(int[][] Matrix, int DelRow, int DelCol) {
        int i = 0, j = 0;
        int[][] temp = new int[Matrix.length - 1][Matrix.length - 1];
        for (int row = 0; row < Matrix[0].length; row++) {
            for (int col = 0; col < Matrix.length; col++) {
                if (row != DelRow && col != DelCol) {
                    temp[i][j++] = Matrix[row][col];
                }
                if (j == Matrix.length - 1) {
                    j = 0;
                    i++;
                }
            }
        }
        return temp;
    }

    private static int Determinant(int[][] Matrix) {
        int det = 0;
        int sign = 1;
        if (Matrix[0].length == 1 && Matrix.length == 1) {
            return Matrix[0][0];
        }
        for (int i = 0; i < Matrix.length; i++) {
            det += sign * Matrix[0][i] * Determinant(GetCofactor(Matrix, 0, i));
            sign = -sign;
        }
        return det;

    }

    private static void priint(int[][] n) {
        for (int[] row : n) {
            System.out.println(Arrays.toString(row));
        }
    }

}