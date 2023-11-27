//Client program
import java.rmi.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class AddClient {
    public static void main(String arges[]) {
        String host = "localhost";
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter first parameter");
        // int a = sc.nextInt();
        // System.out.println("Enter second parameter");
        // int b = sc.nextInt();
	int a[][] = { {1,2,3}, {4,5,6}, {7,8,9}}, b[][] = { {1,2,3} , {4,5,6} , {7,8,9} };
	
        try {
            AddRem remobj = (AddRem) Naming.lookup("rmi://" + host + "/AddRem");
            int[][] res = remobj.addNum(a, b);
            for(int[] num : res){
                for(int n : num){
			System.out.println(n + " ");
		}
            }
        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (NotBoundException nbe) {
            nbe.printStackTrace();
        } catch (MalformedURLException mfe) {
            mfe.printStackTrace();
        }
    }
}