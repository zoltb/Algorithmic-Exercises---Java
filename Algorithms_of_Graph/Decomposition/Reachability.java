import java.util.*;

public class Reachability {

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        
        HashSet<Integer> listOfNeighbours = new HashSet<>();

        for (int i = 0; i < adj.length; i++) {
            if (!adj[i].isEmpty()) {
                listOfNeighbours.add(adj[i].get(0));

                if (adj[i].size() == 2) {
                    listOfNeighbours.add(adj[i].get(1));
                }
            }
        }
        if (listOfNeighbours.contains(x) && listOfNeighbours.contains(y)) {
            return 1;
        } else
            return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}
