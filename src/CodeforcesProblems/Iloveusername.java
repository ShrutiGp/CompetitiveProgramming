package CodeforcesProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Iloveusername {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int noOfContests = Integer.parseInt(sc.nextLine());
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int count = 0;
        for(int i = 1;  i< list.size(); i++) {
            List<Integer> sublist = list.subList(0, i);
            int max = sublist.stream().mapToInt(rank -> rank).max().getAsInt();
            int min = sublist.stream().mapToInt(rank -> rank).min().getAsInt();
            if(list.get(i) > max || list.get(i) < min) {
                count++;
            }
        }
        System.out.print(count);
    }
}