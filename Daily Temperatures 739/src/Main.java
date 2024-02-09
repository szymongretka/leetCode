import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);
        System.out.println("Result: " + Arrays.toString(result));
    }

    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> monotonicIncreasingStackIndexes = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            popUntil(monotonicIncreasingStackIndexes, temperatures, i);

            if (monotonicIncreasingStackIndexes.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = monotonicIncreasingStackIndexes.peek() - i;
            }

            monotonicIncreasingStackIndexes.push(i);
        }

        return result;
    }

    private static void popUntil(Deque<Integer> monotonicIncreasingStack, int[] temperatures, int i) {
        while (!monotonicIncreasingStack.isEmpty()
                && temperatures[i] >= temperatures[monotonicIncreasingStack.peek()]) {
            monotonicIncreasingStack.pop();
        }
    }

}