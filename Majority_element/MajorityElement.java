import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int length) {
        if (0 == length) {
            return -1;
        }
        if (1 == length) {
            return 1;
        }

        Arrays.sort(a);

        if (length % 2 != 0) {
            for (int i = 0; i <= length / 2; i++) {

                if (a[i] != a[i + 1]) {
                    continue;
                }

                if (a[i] == a[i + length / 2]) {
                    return 1;
                }
            }
        } else {
            for (int i = 0; i <= length / 2-1; i++) {

                if (a[i] != a[i + 1]) {
                    continue;
                }

                if (a[i] == a[i + length / 2]) {
                    return 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
