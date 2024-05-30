import org.apache.commons.math3.linear.*;

    public class InverseMatrixMethod {
    public static double[] solve(double[][] A, double[] B) {
        RealMatrix matrixA = new Array2DRowRealMatrix(A);
        RealVector vectorB = new ArrayRealVector(B);
        RealMatrix inverseA = new LUDecomposition(matrixA).getSolver().getInverse();
        RealVector solution = inverseA.operate(vectorB);
        return solution.toArray();
    }

    public static void main(String[] args) {
        double[][] A = { {2, 3}, {1, 2} };
        double[] B = { 5, 3 };
        double[] solution = solve(A, B);
        System.out.println("Solusi dengan metode matriks balikan:");
        for (double x : solution) {
            System.out.println(x);
        }
    }
}
