import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int minNumCoins[]= new int[m];
        int coins[]={1,3,4};
        int value=-1;
        minNumCoins[0]=0;
        if(m==1){
            return 1;
        }
        for (int j = 1; j < m; j++) {
            minNumCoins[j]=1000000;
            for (int i = 0; i < coins.length; i++) {
                if(j>=coins[i]){
                    value=minNumCoins[j-coins[i]]+1;
                    if(value<minNumCoins[j]){
                        //System.out.println(value);
                        minNumCoins[j]=value;
                    }
                }
            }
        }
        return minNumCoins[m-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
