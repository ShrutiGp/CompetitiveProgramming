package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class Reconnaissance{

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        long a[]= Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Long n = a[0];
        Long k = a[1];
        Long result = 0l;
        long mid = (long) Math.ceil(n/2.0);
        if(k <= mid) {
            result = (2*k)-1;
        } else {
            result = 2*(k-mid);
        }
        System.out.print(result);
    }
}
