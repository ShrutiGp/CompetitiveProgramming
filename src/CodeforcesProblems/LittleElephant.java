package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class LittleElephant{
    static int fact(int n ) {
        int c, fact = 1;
        if (n < 0)
            return 1;
        else
        {
            for (c = 1; c <= n; c++)
                fact = fact*c;

        }
        return fact;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for(int j = 0; j< t; j++) {
            int n = Integer.parseInt(sc.nextLine());
            int numbers[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int zeroes = 0, ones = 0, secondbit = 0;
            for(int i = 0 ; i < n; i++) {
                String bin = Integer.toBinaryString(numbers[i]);

                StringBuilder sb = new StringBuilder(bin);
                if(sb.length() < 2)
                    sb = sb.insert(0, '0');

                char secondLast = sb.charAt(sb.length()-2);
                sb.deleteCharAt(sb.length()-2);
                if(sb.indexOf(Character.toString(secondLast)) == -1) {
                    secondbit++;
                }
                if(bin.charAt(bin.length()-1) == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            System.out.println(Math.abs(fact(zeroes)/(2*fact(zeroes-2)) + fact(ones)/(2*fact(ones-2)) -  fact(secondbit)/(2*fact(secondbit-2))));
            }
        }
}
