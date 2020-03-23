package Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class numbersWithUniqueDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int resultArray[][] = new int[T][2];
        for(int i = 0 ; i < T; i++) {
            resultArray[i] =  Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < T; i++) {
            int from = resultArray[i][0];
            int to = resultArray[i][1];

            for(int j = from; j <= to; j++) {
                HashSet<Integer> hs=  new HashSet<>();
                int num = j;
                boolean unique = true;
                while(num != 0) {
                    int digit = num % 10;
                    if(hs.contains(digit)) {
                       unique = false;
                       break;
                    }
                    hs.add(digit);
                    num = num / 10;
                }
                if(unique) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
