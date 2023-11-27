import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixOperationImpl extends UnicastRemoteObject implements MatrixOperationInterface {
    public MatrixOperationImpl() throws RemoteException {
        super();
    }

    @Override
    public double[][] inverseMatrix(double[][] matrix) throws RemoteException {
        int n = matrix.length;
        double[][] adjugateMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjugateMatrix[i][j] = cofactor(matrix, i, j) / determinant(matrix);
            }
        }

        return adjugateMatrix;
    }

    private double determinant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        double det = 0;
        int sign = 1;

        for (int i = 0; i < n; i++) {
            double[][] subMatrix = new double[n - 1][n - 1];
            getCofactor(matrix, subMatrix, 0, i);
            det += sign * matrix[0][i] * determinant(subMatrix);
            sign = -sign;
        }

        return det;
    }

    private double cofactor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];
        getCofactor(matrix, subMatrix, row, col);
        return determinant(subMatrix);
    }

    private void getCofactor(double[][] matrix, double[][] subMatrix, int row, int col) {
        int n = matrix.length;
        int subMatrixRow = 0, subMatrixCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != row && j != col) {
                    subMatrix[subMatrixRow][subMatrixCol++] = matrix[i][j];
                    if (subMatrixCol == n - 1) {
                        subMatrixCol = 0;
                        subMatrixRow++;
                    }
                }
            }
        }
    }
}
