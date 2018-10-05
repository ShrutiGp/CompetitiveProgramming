package CodeforcesProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoyOrGirl {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        List<Character> charray = new ArrayList<>();
        for(char c: ch) {
            charray.add(c);
        }
        if(charray.stream().distinct().count()%2 == 0)
            System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
    }
}
