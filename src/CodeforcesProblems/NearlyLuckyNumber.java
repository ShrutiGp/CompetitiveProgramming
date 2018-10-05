package CodeforcesProblems;

import java.util.Scanner;

public class NearlyLuckyNumber {

    public static void main(String... s) {

        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        int count = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '4' || ch[i] =='7')
                count++;
        }
        System.out.println((count == 4 || count == 7) ? "YES" : "NO");
    }

}