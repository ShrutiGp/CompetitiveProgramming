package CodeforcesProblems;

import java.util.Scanner;

public class WordGame {

    public static void main(String... s) {

        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        int lowerCase = 0, upperCase = 0;

        for(int i=0; i<ch.length; i++) {
            if(Character.isUpperCase(ch[i]))
                upperCase++;
            else
                lowerCase++;
        }
        System.out.println(upperCase > lowerCase ? String.valueOf(ch).toUpperCase() : String.valueOf(ch).toLowerCase());
    }

}
