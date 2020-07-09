import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        Map<Double, Double> mapOfItems = new TreeMap<>(Collections.reverseOrder());

        //sorting
        for (int i = 0; i < values.length; i++) {
            mapOfItems.put((double) values[i] / weights[i], (double) weights[i]);
        }

        for (int i = 0; i < values.length; i++) {

            if (capacity == 0) {
                return value;
            }

            //get key and value from current iteration
            double currentValue = (double) mapOfItems.keySet().toArray()[i];
            double currentWeight = mapOfItems.get(currentValue);

            //ha nincs teli mindet hozzaadjuk amugy csak annyit a valuebol ami a capacitybe belefer
            if (currentWeight <= capacity) {
                value += currentValue * currentWeight;
                capacity -= currentWeight;
            } else {
                value += currentValue * capacity;
                capacity = 0;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
