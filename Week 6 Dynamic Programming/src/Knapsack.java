import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int n=w.length;
        int sol[][]= new int[n+1][W+1];//declare solution array
        for (int i = 0; i <= n; i++) {//initialize first column by 0
            sol[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {//initialize first row by 0
            sol[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int remainingSpace= j - w[i - 1];
                if (remainingSpace>= 0){
                    int used= sol[i - 1][j - w[i - 1]] + w[i - 1];//value if bar used
                    int notUsed= sol[i - 1][j];//value if bar not used
                    sol[i][j] = Math.max(notUsed, used);
                }
                else{
                    sol[i][j] = sol[i - 1][j];
                }
            }
        }
        return sol[n][W];

        //write you code here
        /*int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;*/
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

