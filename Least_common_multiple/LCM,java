import java.util.*;

public class LCM {

  private static long lcm_better(int a, int b) {

    long minLCM = a > b ? a : b;

    for (long l = minLCM; minLCM <= (long) a * b; l +=minLCM)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_better(a, b));
  }
}
