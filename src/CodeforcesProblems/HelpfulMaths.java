package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelpfulMaths {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int numbers[] = Arrays.stream(sc.nextLine().split("\\+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        System.out.print(Arrays.stream(numbers)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining("+")));

    }
}