import java.util.*;
import java.util.stream.Collectors;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int m) {

        List<Integer> res = new ArrayList<>();

        if( m == 1){
            res.add(1);
            return res;
        }

        if (m == 2) {
            res.add(1);
            res.add(2);
            return res;
        }

        int[] stepsToTaken = new int[m + 1];
        stepsToTaken[0] = 0;

        for (int i = 1; i < stepsToTaken.length; i++) {

            stepsToTaken[i] = stepsToTaken[i - 1] + 1;
            if (i % 2 == 0) {
                stepsToTaken[i] = Math.min(Math.min(stepsToTaken[i], stepsToTaken[i / 2] + 1), stepsToTaken[i]);
            }
            if (i % 3 == 0) {
                stepsToTaken[i] = Math.min(Math.min(stepsToTaken[i], stepsToTaken[i / 3] + 1), stepsToTaken[i]);
            }

        }

        int[] eachOfTheSteps = new int[m + 1];



        for (int i = m; i > 1; i--) {

            eachOfTheSteps[i] = m;

            if (m - 1 < 0) break;

            if (stepsToTaken[m - 1] == stepsToTaken[m] - 1) {
                m -= 1;
            } else if (m % 2 == 0 && (stepsToTaken[m / 2] == stepsToTaken[m] - 1)) {
                m /= 2;
            } else if (m % 3 == 0 && (stepsToTaken[m / 3] == stepsToTaken[m] - 1)) {
                m /= 3;
            }
        }

        res = Arrays.stream(eachOfTheSteps).filter(num -> num != 0).boxed().collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
