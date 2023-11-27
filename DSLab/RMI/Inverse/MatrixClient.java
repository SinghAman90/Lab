import java.rmi.Naming;

public class MatrixClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object from the registry
            MatrixOperationInterface matrixOperation = (MatrixOperationInterface) Naming.lookup("rmi://localhost/MatrixOperationService");

            // Example matrix for testing
            double[][] matrix = {
                {2, -1, 0},
                {-1, 2, -1},
                {0, -1, 2}
            };

            // Call the remote method for matrix inversion
            double[][] invertedMatrix = matrixOperation.inverseMatrix(matrix);

            // Print the result
            System.out.println("Original Matrix:");
            printMatrix(matrix);

            System.out.println("\nInverted Matrix:");
            printMatrix(invertedMatrix);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to print a matrix
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
