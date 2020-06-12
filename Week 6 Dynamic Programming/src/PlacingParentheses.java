import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        //write your code here
        int digits=(exp.length()+1)/2;//total number of digits
        long min[][]= new long[digits][digits];
        long max[][]= new long[digits][digits];
        for (int i = 0; i < digits; i++){//initialise diagonal with number
            int num = Integer.parseInt(exp.substring(2*i,2*i+1));//extract number from expression
            //System.out.println(num);
            min[i][i] = num;
            max[i][i] = num;
        }
        for(int s = 1; s < digits; s++){//update the min and max arrays
            for(int i = 0; i < (digits-s); i++){
                long MinMax[];
                int j = i + s;
                MinMax = MinAndMax(i, j, min, max, exp);
                min[i][i+s] = MinMax[0];
                max[i][i+s] = MinMax[1];
            }
        }
        return max[0][digits-1];//return max result
    }

    private static long[] MinAndMax(int i, int j, long[][] m, long[][] M, String exp){
        long min=Long.MAX_VALUE;
        //System.out.println(max);
        long max= Long.MIN_VALUE;
        //System.out.println(min);
        for (int k = i; k < j; k++) {
            char op= exp.charAt(2*k+1);//get operator from expression
            //compute all possible results
            long a= eval(M[i][k], M[k+1][j], op);
            long b= eval(M[i][k], m[k+1][j], op);
            long c= eval(m[i][k], M[k+1][j], op);
            long d= eval(m[i][k], m[k+1][j], op);
            max=Math.max(max, Math.max(a,Math.max(b,Math.max(c,d))));
            min=Math.min(min, Math.min(a,Math.min(b,Math.min(c,d))));
        }
        long[] minmax ={min,max};
        return minmax;
    }
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

