package Amazon;

import java.io.PrintWriter;
import java.util.Scanner;

public class GFG {
    static PrintWriter out = new PrintWriter(System.out);

    static int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    static int findMinimum(int num) {
        int res = 1;
        for(int i = coins.length - 1; i >= 0; i--) {
            if(coins[i] <= num) {
                res = coins[i];
                break;
            }
        }
        return res;
    }

    static int getMinimumCoins(int num) {
        if (num == 0)
            return 0;

        int coin = findMinimum(num);
        int n1 = num / coin;
        for(int i = 0; i < n1; i++)
            out.print(coin + " ");
        return n1 + getMinimumCoins(num % coin);
    }



    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i;
        n=sc.nextInt();
        for(i=0;i<n;i++)
        {
            int num =sc.nextInt();
            getMinimumCoins(num);
            out.println();
           // out.println(getMinimumCoins(num));
        }

        out.flush();
        out.close();
    }
}
