import java.util.Scanner;
import java.lang.*;
public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, double[] weights) {
        double amount = 0;
        for(int i=0; i<weights.length; i++){
            if (capacity==0){
                return amount;
            }
            double maxPerUnit=0;
            int index=-1;
            for(int j=0; j<weights.length; j++){
                double perUnit=values[j]/weights[j];
                if((weights[j]>0) & (maxPerUnit<perUnit)){
                    maxPerUnit= perUnit;
                    index=j;
                }
            }
            double qty=Math.min(weights[index], capacity);
            amount+= maxPerUnit*qty;
            weights[index]-=qty;
            capacity-=qty;
        }
        return amount;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}

