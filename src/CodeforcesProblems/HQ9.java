package CodeforcesProblems;

import java.util.Scanner;

public class HQ9 {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();

        String check = "CodeforcesProblems.HQ9";
        boolean res = false;
        for(int i  = 0; i < ch.length; i++) {
            if(check.indexOf(ch[i]) != -1) {
                res = true;
                break;
            }
        }

        if(res) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}