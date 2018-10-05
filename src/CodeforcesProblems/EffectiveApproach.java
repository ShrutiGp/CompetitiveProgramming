package CodeforcesProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class EffectiveApproach {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        int array[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int search = Integer.parseInt(sc.nextLine());
        int searchArray[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;  i< num; i++) {
            map.put(array[i], i+1);
        }

        long a1 = 0, b1 =0;
        for (int i = 0;  i < search; i++) {
            a1 += map.get(searchArray[i]);
            b1 += (num - map.get(searchArray[i]) + 1);
        }
        System.out.println(a1+" "+b1);
    }
}
