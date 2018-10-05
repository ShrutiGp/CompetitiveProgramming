package CodeforcesProblems;

import java.util.Scanner;

public class PetyaAndStrings {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);

        String str  = sc.nextLine().toLowerCase();
        String str2 = sc.nextLine().toLowerCase();

        if(str.compareTo(str2) < 0) {
            System.out.print("-1");
        } else if(str.compareTo(str2) == 0) {
            System.out.print("0");
        } else {
            System.out.print("1");
        }
    }
}
