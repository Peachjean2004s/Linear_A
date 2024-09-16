package Guassian;

import java.util.Scanner;

public class GaussianElimination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix : ");
        int size = sc.nextInt();

        double[][] matrix = new double[size][size + 1];

        System.out.println("Enter the elements of the matrix : ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(matrix[i][i]) < Math.abs(matrix[j][i])) {
                    double[] temp = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = temp;
                }
            }
            for (int j = i + 1; j < size; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k <= size; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
        double[] result = new double[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = matrix[i][size];
            for (int j = i + 1; j < size; j++) {
                result[i] -= matrix[i][j] * result[j];
            }
            result[i] /= matrix[i][i];
        }

        System.out.println("result is : ");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == -0.0) {
                result[i] = 0.0;
            }
            System.out.println("x" + (i + 1) + " = " + result[i]);
        }
        sc.close();
    }
}
