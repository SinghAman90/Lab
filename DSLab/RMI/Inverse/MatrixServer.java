import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MatrixServer {
    public static void main(String[] args) {
        try {
            MatrixOperationInterface matrixOperation = new MatrixOperationImpl();

            // Create a registry on the default port (1099)
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry
            Naming.rebind("MatrixOperationService", matrixOperation);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
