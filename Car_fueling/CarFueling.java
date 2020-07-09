import java.util.Arrays;
import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {

        //ha eleg nagy a tank nem kell szamolni semmit
        if (dist <= tank) {
            return 0;
        }

        int[] everyPos = new int[stops.length + 2];
        everyPos[0] = 0;
        everyPos[stops.length + 1] = dist;

        for (int i = 0; i < stops.length; i++) {
            everyPos[i + 1] = stops[i];
        }

        int numRefills = 0;
        int currRefill = 0;
        int i = 1;
        while (currRefill <= stops.length) {


            int lastRefill = currRefill;

            while (currRefill <= stops.length && (everyPos[currRefill + 1] - everyPos[lastRefill]) <= tank) {
                currRefill = currRefill + 1;
            }

            if (currRefill == lastRefill) {
                return -1;
            }
            if (currRefill <= stops.length) {
                numRefills = numRefills + 1;
            }
            i++;
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
