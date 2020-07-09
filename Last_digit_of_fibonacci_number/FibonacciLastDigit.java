import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigit(int n) {
        int[] fibArray = new int[n+1];

        int result = 0;

        if (n >= 2) {
            fibArray[0] = 0;
            fibArray[1] = 1;

            for (int i = 2; i <= n; i++) {

                fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % 10;
            }
            result = fibArray[n];
        } else {
            result = n;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}
