import java.util.Scanner;

public class Change {
    private static int getChange(int m) {

        int count = 0;

        while (m > 0) {
            int temp = m;

            if (temp / 10 > 0) {
                temp -= 10;
                count++;
            } else if (temp / 5 == 1) {
                temp -= 5;
                count++;
            } else if (m < 5) {
                temp -= 1;
                count++;
            }
            m = temp;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

