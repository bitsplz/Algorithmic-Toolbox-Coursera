import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        String str = "";
        for (String temp:a)
            str+= temp;
        String[] newStr = str.split("(?!^)");
        Arrays.sort(newStr, Collections.reverseOrder());
        String result = "";
        for (int i = 0; i < newStr.length; i++) {
            result += newStr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

