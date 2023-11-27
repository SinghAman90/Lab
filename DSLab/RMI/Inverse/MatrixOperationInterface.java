import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixOperationInterface extends Remote {
    public double[][] inverseMatrix(double[][] matrix) throws RemoteException;
}
