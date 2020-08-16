import java.util.*;

public class Reachability {

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here

        int[] visited = new int[adj.length];
        return explore(adj, x, y, visited);
    }

    private static int explore(ArrayList<Integer>[] adj, int x, int y, int[] visited) {



        if (x == y) {
            return 1;
        }
        visited[x] = 1;



        for (int i = 0; i < adj[x].size(); i++) {
            int exploringNode = adj[x].get(i);
            if (visited[exploringNode] == 0) {
                int check = explore(adj, exploringNode, y, visited);
                if (check == 1) {
                    return check;
                }
            }
        }
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

