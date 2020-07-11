import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        if (W == 0)
            return 0;
        if (w.length == 0)
            return 0;

        int availableWeight = W;
        int goldBarNumber = w.length;

        int[][] value = new int[goldBarNumber+1][availableWeight+1];

        int tempval = 0;
        for (int i = 0; i <= goldBarNumber; i++) {
            for (int j = 0; j <= availableWeight; j++) {

                if (i == 0) {
                    value[i][j] = 0;
                } else if (j == 0) {
                    value[i][j] = 0;
                }
                else if (i != w.length && w[i] <= j) {
                    tempval = Math.max(value[i-1][j - w[i]] + w[i], value[i-1][j]);
                    if (tempval > value[i][j]){
                        value[i][j] = tempval;
                    }
                } else
                    value[i][j] = value[i-1][j];
            }
        }
        return value[goldBarNumber][availableWeight];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

