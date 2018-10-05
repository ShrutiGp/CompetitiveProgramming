package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class Bits {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        int i = 0;
        int count = 0;
        while( i < num) {
            String str[] = sc.nextLine().split(" ");
            count += Arrays.stream(str).filter(n -> n.equals("1")).count() >= 2 ? 1 : 0;
            i++;
        }
        System.out.print(count);
    }
}
