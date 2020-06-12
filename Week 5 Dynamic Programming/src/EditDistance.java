import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        char a[]=s.toCharArray();
        char b[]=t.toCharArray();
        int D[][]=new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            D[i][0]=i;
            D[0][i]=i;
            for (int j = 1; j < t.length(); j++) {
                for (int k = 1; k < s.length(); k++) {
                    int insert = D[k][j - 1] + 1;
                    int delete = D[k - 1][j] + 1;
                    int match = D[k - 1][j - 1];
                    int mismatch = D[k - 1][j - 1] + 1;
                    if (a[k]==b[j]){
                        D[k][j]=Math.min(insert,Math.min(delete,match));
                    }
                    else{
                        D[k][j]=Math.min(insert,Math.min(delete,mismatch));
                    }
                }
            }
        }
        return D[s.length()-1][t.length()-1];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
