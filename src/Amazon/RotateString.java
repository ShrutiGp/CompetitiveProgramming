package Amazon;

import java.util.Arrays;
import java.util.Scanner;

public class RotateString {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String[][]  str= new String[T][2];
        for(int i = 0 ; i < T; i++) {
            str[i][0] = sc.nextLine();
            str[i][1] = sc.nextLine();
        }

        for(int j = 0; j< str.length; j++) {
            String from = str[j][0];
            String to = str[j][1];
            String anticlock = from.substring(from.length() -2) + from.substring(0, from.length()-2);
            String clock = from.substring(2) + from.substring(0,2);

            System.out.println(anticlock.equals(to) || clock.equals(to) ? "Yes" : "No");

        }
    }
}
