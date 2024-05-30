import java.util.Arrays;

public class CroutDecompositionMethod {
    public static double[] solve(double[][] A, double[] B) {
        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            U[i][i] = 1;
        }

        for (int j = 0; j < n; j++) {
            for (int i = j; i < n; i++) {
                L[i][j] = A[i][j];
                for (int k = 0; k < j; k++) {
                    L[i][j] -= L[i][k] * U[k][j];
                }
            }
            for (int i = j + 1; i < n; i++) {
                U[j][i] = A[j][i] / L[j][j];
                for (int k = 0; k < j; k++) {
                    U[j][i] -= (L[j][k] * U[k][i]) / L[j][j];
                }
            }
        }

        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = B[i];
            for (int k = 0; k < i; k++) {
                y[i] -= L[i][k] * y[k];
            }
            y[i] /= L[i][i];
        }

        double[] X = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            X[i] = y[i];
            for (int k = i + 1; k < n; k++) {
                X[i] -= U[i][k] * X[k];
            }
        }

        return X;
    }

    public static void main(String[] args) {
        double[][] A = { {2, 3}, {1, 2} };
        double[] B = { 5, 3 };
        double[] solution = solve(A, B);
        System.out.println("Solusi dengan metode dekomposisi Crout:");
        for (double x : solution) {
            System.out.println(x);
        }
    }
}
