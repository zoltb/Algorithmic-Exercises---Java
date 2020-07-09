import java.util.*;

public class GCD {

  static long calc(long b, long remainder) {

    return b % remainder;
  }

  private static long gcd_fast(long a, long b) {
    long current_gcd = 1;

    while (true) {
      long remainder = calc(a, b);
      if (remainder == 0) {
        current_gcd = b;
        break;
      } else {
        a = b;
        b = remainder;
      }
    }

    return current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_fast(a, b));
  }
}
