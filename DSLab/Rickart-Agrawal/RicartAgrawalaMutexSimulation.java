import java.util.*;

public class RicartAgrawalaMutexSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of sites: ");
        int ns = scanner.nextInt();

        System.out.print("Enter number of sites which want to enter critical section: ");
        int ncs = scanner.nextInt();

        List<Integer> ts = new ArrayList<>(Collections.nCopies(ns, 0));
        List<Integer> request = new ArrayList<>();
        Map<Integer, Integer> mp = new TreeMap<>();

        for (int i = 0; i < ncs; i++) {
            System.out.print("\nEnter timestamp: ");
            int timestamp = scanner.nextInt();

            System.out.print("Enter site number: ");
            int site = scanner.nextInt();

            if (site < 1 || site > ns) {
                System.out.println("Invalid site number. Exiting.");
                return;
            }

            ts.set(site - 1, timestamp);
            request.add(site);
            mp.put(timestamp, site);
        }

        System.out.println("\nSites and Timestamps:\n");
        for (int i = 0; i < ts.size(); i++) {
            System.out.println((i + 1) + " " + ts.get(i));
        }

        handleRequests(ns, ncs, ts, request, mp);

        System.out.println("\nSites Entered Critical Section:\n");
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println("Site " + entry.getValue() + " entered Critical Section");
        }
    }

    private static void handleRequests(int ns, int ncs, List<Integer> ts, List<Integer> request, Map<Integer, Integer> mp) {
        System.out.println("\nRequests Handling:\n");
        for (int i = 0; i < request.size(); i++) {
            System.out.println("\nRequest from site: " + request.get(i));
            for (int j = 0; j < ts.size(); j++) {
                if (request.get(i) != (j + 1)) {
                    if (ts.get(j) > ts.get(request.get(i) - 1) || ts.get(j) == 0)
                        System.out.println((j + 1) + " Replied");
                    else
                        System.out.println((j + 1) + " Deferred");
                }
            }
        }
    }
}
