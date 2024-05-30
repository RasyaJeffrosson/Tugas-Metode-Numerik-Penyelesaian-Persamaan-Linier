import org.apache.commons.math3.linear.*;

public class LUDecompositionMethod {
    public static double[] solve(double[][] A, double[] B) {
        RealMatrix matrixA = new Array2DRowRealMatrix(A);
        DecompositionSolver solver = new LUDecomposition(matrixA).getSolver();
        RealVector vectorB = new ArrayRealVector(B);
        RealVector solution = solver.solve(vectorB);
        return solution.toArray();
    }

    public static void main(String[] args) {
        double[][] A = { {2, 3}, {1, 2} };
        double[] B = { 5, 3 };
        double[] solution = solve(A, B);
        System.out.println("Solusi dengan metode dekomposisi LU Gauss:");
        for (double x : solution) {
            System.out.println(x);
        }
    }
}
