package CodeforcesProblems;

import java.util.Arrays;
        import java.util.Scanner;

public class Drinks {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String str[] = sc.nextLine().split("\\s+");

        int heights[] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        Double sum = Arrays.stream(str).map(h -> Double.parseDouble(h)/size).mapToDouble(h->h).sum();
        System.out.print(sum);
    }
}

