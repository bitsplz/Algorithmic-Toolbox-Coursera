import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int coins[]={10,5,1};
        int count=0;//number of minimum coins required
        int result;
        for (int i=0; i<3;i++){
            result = m / coins[i];//number of these coins required
            if (result>0){
                count+=result;//update number of coins
            }
            m= m-(result*coins[i]);//remaining amount
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}