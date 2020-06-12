import java.util.*;
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] predecessor = new int[n + 1];
        int[] step = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            step[i] = step[i - 1] + 1;
            predecessor[i] = i - 1;
            if (i % 2 == 0) {
                if (step[i / 2] < step[i]) {
                    step[i] = step[i / 2] + 1;
                    predecessor[i] = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (step[i / 3] < step[i]) {
                    step[i] = step[i / 3] + 1;
                    predecessor[i] = i / 3;
                }
            }
        }
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        for (int i = n; i != 0; i = predecessor[i]) {
            sequence.add(i);
        }
        Collections.reverse(sequence);
        return sequence;
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

