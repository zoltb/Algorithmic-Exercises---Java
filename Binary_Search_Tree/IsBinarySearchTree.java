import java.util.*;
import java.io.*;

public class IsBinarySearchTree {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        int[] kArray;
        int[] lArray;
        int[] rArray;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        void forInorder(LinkedList<Integer> linkedList, int key) {

            while (key != -1) {
                linkedList.addFirst(key);
                key = lArray[key];
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            ArrayList<Integer> falsy = new ArrayList<Integer>();
            LinkedList<Integer> linkedList = new LinkedList<>();

            forInorder(linkedList, 0);

            for (int i = 0; i < nodes; i++) {

                try{
                    int nextArrayPos = linkedList.removeFirst();
                    result.add(kArray[nextArrayPos]);
                    nextArrayPos = rArray[nextArrayPos];

                    if (nextArrayPos != -1)
                        forInorder(linkedList, nextArrayPos);
                } catch (NoSuchElementException e) {
                    return falsy;
                }
            }

            return result;
        }

        boolean isBinarySearchTree() {
          // Implement correct algorithm here

            if(nodes < 1){
                return true;
            }

            kArray = new int[nodes];
            lArray = new int[nodes];
            rArray = new int[nodes];

            for (int i = 0; i < nodes; i++) {

                kArray[i] = tree[i].key;
                lArray[i] = tree[i].left;
                rArray[i] = tree[i].right;
            }
            List<Integer> result = inOrder();
            List<Integer> checking = new ArrayList<>(result);

            if (result.isEmpty()){
                return false;
            }
            Collections.sort(checking);

            if (checking.equals(result)) {
                return true;
            }
            return false;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new IsBinarySearchTree().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
