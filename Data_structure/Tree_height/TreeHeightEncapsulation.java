import java.util.*;
import java.io.*;

public class TreeHeightEncapsulation {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int calculate(int[] everyNodesHeight, int vertex) {

			if (parent[vertex] == -1) {
				everyNodesHeight[vertex] = 1;
				return 1;
			}
			if(everyNodesHeight[vertex] !=0 ){
				return everyNodesHeight[vertex];
			}
			everyNodesHeight[vertex] = calculate(everyNodesHeight, parent[vertex]) + 1;
			return everyNodesHeight[vertex];
		}

		int computeHeight() {
			// Replace this code with a faster implementation

			int maxHeight = 0;

			int[] everyNodesHeight = new int[n];
			for (int vertex = 0; vertex < n; vertex++) {
				maxHeight = Math.max(maxHeight, calculate(everyNodesHeight, vertex));
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new TreeHeightEncapsulation().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
