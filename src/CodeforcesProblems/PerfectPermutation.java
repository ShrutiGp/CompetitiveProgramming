package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class PerfectPermutation {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean possible = true;
        int finalArray[] = new int[size];

        for (int i = 0; i < size; i++) {
            if (finalArray[i] == 0) {
                finalArray[i] = i + 2;
                if(i+1 < finalArray.length) {
                    finalArray[i + 1] = i + 1;
                } else {
                    possible = false;
                    break;
                }
            }
        }
        if(possible) {
            Arrays.stream(finalArray).forEach(num -> {
                System.out.print(num + " ");
            });
        } else {
            System.out.println("-1");
        }
    }

}
