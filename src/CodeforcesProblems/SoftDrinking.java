package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class SoftDrinking {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int array[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int noOfToasts = (array[1]*array[2]) / array[6];
        int limes = (array[3]*array[4]);
        int salt = array[5]/array[7];

        System.out.print(Arrays.asList(noOfToasts, limes, salt).stream().mapToInt(i -> i).min().getAsInt() / array[0]);

    }
}