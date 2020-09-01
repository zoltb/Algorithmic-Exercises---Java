import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
  private static BigInteger calc_fib(int n) {
    BigInteger[] fibArray = new BigInteger[n+1];

    BigInteger result;

    if (n >= 2) {
      fibArray[0] = BigInteger.valueOf(0);
      fibArray[1] = BigInteger.valueOf(1);

      for (int i = 2; i <= n; i++) {

        fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
      }
      result = fibArray[n];
    } else {
      result = BigInteger.valueOf(n);
    }

    return result;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
