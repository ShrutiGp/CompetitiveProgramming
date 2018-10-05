package CodeforcesProblems;

import java.util.Scanner;

public class WordCapitalization {

    public static void main(String... s) {

        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        ch[0] = Character.toUpperCase(ch[0]);
        System.out.println(String.valueOf(ch));
    }

}