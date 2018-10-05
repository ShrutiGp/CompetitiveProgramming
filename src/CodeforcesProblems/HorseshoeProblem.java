package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class HorseshoeProblem {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        System.out.print(4-Arrays.stream(str).distinct().count());
    }
}
