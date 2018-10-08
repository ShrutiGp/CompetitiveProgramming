package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class Parallelepiped {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int a[]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double b1 = Math.sqrt(a[0]*a[1]/a[2]);
        double a1 = Math.sqrt(a[0]*a[2]/a[1]);
        double c1 = Math.sqrt(a[2]*a[1]/a[0]);

        System.out.println((int)(4*(b1+a1+c1)));
    }
}