import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {

        int[] moneyToChange = new int[m + 1];
        Arrays.fill(moneyToChange,m+2);
        moneyToChange[0] = 0;
        int[] denominations = {1, 3, 4};

        for (int i = 0; i < moneyToChange.length; i++) {
            for (int change : denominations) {
                if (i >= change) {
                    moneyToChange[i] = Math.min(Math.min(moneyToChange[i - 1] + 1, moneyToChange[i - change] + 1), moneyToChange[i]);
                }
            }
        }
        return moneyToChange[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
