import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        if(tank>dist){
            return 0;
        }
        int count=0;
        int currentStop=0,lastRefill=0;
        int stations=stops.length;
        while(stops[lastRefill]+tank<dist){
            lastRefill=currentStop;
            while((currentStop<stops.length -1) && stops[currentStop+1] <= stops[lastRefill]+tank){
                currentStop++;
            }
            if(stops[lastRefill]+tank<dist){
                count++;
            }
            if(currentStop==lastRefill){
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
        stops[0]=0;
        for (int i = 1; i < n+1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n]=dist;
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}

