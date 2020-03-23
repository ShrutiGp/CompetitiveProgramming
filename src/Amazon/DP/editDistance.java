

package Amazon.DP;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.util.*;
        import java.util.stream.Collectors;

public class editDistance
{

    static PrintWriter out = new PrintWriter(System.out);


    static int minimumOperationByRecursion(char X[], char Y[], int m, int n) {

        if(m == 0)
            return n;

        if(n == 0)
            return m;

        if(X[m-1] == Y[n-1])
            return minimumOperationByRecursion(X, Y, m-1, n-1);

        return 1 + Math.min(Math.min(minimumOperationByRecursion(X, Y, m-1, n), minimumOperationByRecursion(X, Y, m, n-1)), minimumOperationByRecursion(X, Y, m-1, n-1));
    }

    static int minimumOperationsByDP(char X[], char Y[], int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                }
                else if(j == 0)
                    dp[i][j] = i;

                else if(X[i-1] == Y[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }

        return dp[m][n];

    }


    public static void main(String[] args)throws IOException
    {

        String str1 = "sunday";
        String str2 = "saturday";

        char X[] = str1.toCharArray();
        char Y[] = str2.toCharArray();


       System.out.println(minimumOperationByRecursion(X, Y, X.length, Y.length));
        System.out.println(minimumOperationsByDP(X, Y, X.length, Y.length));
    }
}