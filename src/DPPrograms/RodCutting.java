package DPPrograms;

import java.util.*;
import java.lang.*;
import java.io.*;

//GeeksForGeeks
class RodCutting {
    static BufferedReader br;
    static StringTokenizer st;


    static int result(int price[], int n) {
        int maxPrice[] = new int[n+1];
        maxPrice[0]=0;
        for(int i = 1; i<=n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                max= Math.max(max, price[j]+maxPrice[i-j-1]);
            }
            maxPrice[i] = max;
        }
        return maxPrice[n];
    }


    /* ROD CUTTING PROBLEM
    https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
     */
    static int maxProfit(int price[], int n) {
        int dp[][] = new int[n+1][n+1];

        for(int i = 0; i <= n ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if(j < i) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], price[i-1] + dp[i][j - i]);
                    }
                }
            }
        }

        return dp[n][n];
    }

    // ROD CUTTING PROBLEM ANOTHER VERSION -  https://practice.geeksforgeeks.org/problems/cutted-segments/0 for this one method is below
    /* Submissions
    https://practice.geeksforgeeks.org/viewSol.php?subId=3ebf3c015e19ddf7689792721b15cefa&pid=998&user=zoravar
    https://practice.geeksforgeeks.org/viewSol.php?subId=76790344309767&pid=998&user=Shefali%20Sonker
    */
    static int maxNumberOfSegments(int len, int numbers[]) {
        int max[] = new int[len + 1];
        Arrays.fill(max, -1);
        max[0] = 0;
        for (int i = 1; i <= len; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(numbers[j] <= i) {
                    if(max[i - numbers[j]] != -1) {
                        max[i] = Math.max(max[i], max[i - numbers[j]] + 1);

                    }
                }
            }

        }
        return max[len];

    }

    static int minimumSumPartition(int arr[], int n, int sumCalculated, int sumTotal) {
        if(n == 0) {
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }

        return Math.min(minimumSumPartition(arr, n-1, sumCalculated + arr[n-1], sumTotal), minimumSumPartition(arr, n-1, sumCalculated, sumTotal));

    }


    static int longestCommonSubsequence(char ch1[], char ch2[], int m, int n) {
        if(m == 0 || n == 0)
            return 0;

        if(ch1[m-1] == ch2[n-1]) {
            return 1 + longestCommonSubsequence(ch1, ch2, m-1, n-1);
        }

        return Math.max(longestCommonSubsequence(ch1, ch2, m-1, n), longestCommonSubsequence(ch1, ch2, m, n-1));
    }



    public static void main (String[] args) {

        char ch1[] = "gefekr".toCharArray();
        char ch2[] = "geerks".toCharArray();
        System.out.println("LCS" + longestCommonSubsequence(ch1, ch2, ch1.length, ch2.length));
        int arr1[] = {3, 1, 4, 2, 2, 1};
        int n = arr1.length;
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr1[i];
        System.out.print("The minimum difference"+
                " between two sets is " +
                minimumSumPartition(arr1, n, 0 , sumTotal));


        int len = 4;
        int numbers[] = {2,1,1};
        System.out.println("Answer " + maxNumberOfSegments(len, numbers));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }

            out.print(maxProfit(arr, size));
            out.println();

        }
        out.flush();
    }

    public static String next() {
        if(st.hasMoreTokens()) {
            return st.nextToken();
        } else {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
}