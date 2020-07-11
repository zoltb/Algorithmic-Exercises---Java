import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write you code here

        int lengthOfTheArray = A.length;

        int sumOfTheElements = Arrays.stream(A).sum();

        if (sumOfTheElements % 3 != 0 || lengthOfTheArray < 3)
            return 0;

        int[][] value = new int[lengthOfTheArray][sumOfTheElements / 3 + 1];

        for (int i = 0; i < lengthOfTheArray; i++) {
            for (int j = 0; j <= sumOfTheElements / 3; j++) {
                if (j == 0) {
                    value[i][j] = 1;
                    continue;
                }
                if (i != 0) {
                    if (value[i - 1][j] == 1) {
                        value[i][j] = value[i - 1][j];
                    } else if (j >= A[i]) {
                        value[i][j] = value[i - 1][j - A[i]];
                    }
                }


            }
        }
        return value[lengthOfTheArray - 1][sumOfTheElements / 3];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
