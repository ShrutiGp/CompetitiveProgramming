package Amazon.DP;

import java.lang.reflect.Array;

public class CoinChange {

    static int merge(int a1[], int a2[], int s1, int s2) {
        if(a1.length == (s1+1) || a2.length == (s2 + 1))
            return 0;
        if(a1[s1] < a2[s2]) {
            merge(a1, a2, s1 + 1, s2);
        } else {
            int temp = a1[s1];
            a1[s1] = a2[s2];
            a2[s2] = temp;
            merge(a1, a2, s1 + 1, s2);
        }

        return 0;
    }


    static int coinChange1(int coins[], int size, int num) {
        int dp[][] = new int[size + 1][num + 1];

        for(int i = 0 ; i <= size; i++) {
            for(int j = 0 ; j <= num; j++) {
                if(i==0){
                    dp[i][j]=0;
                    continue;
                }
                if(j==0)
                    dp[i][j]=1;
                else {
                    if (coins[i - 1] <= j) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        for(int i = 1 ; i <= size; i++) {
            for(int j = 1 ; j <= num; j++) {
                System.out.print(dp[i][j] +  " ");
            }
            System.out.println();
        }

        System.out.println("retirn");

        return dp[size][num];
    }



    static int coinChange(int coins[], int size, int num) {

        int result[][] = new int[size+1][num + 1];

        for(int i = 0; i <= size; i++) {
            for (int j = 0; j <= num; j++) {
                if(i == 0 || j == 0)
                    result[i][j] = 1;
                else if(coins[i-1] <= j) {
                    result[i][j] = Math.min(result[i][j - i] + 1, result[i-1][j]);
                } else {
                    result[i][j] = result[i-1][j];
                }

                System.out.println(i + " " + j + " : " + result[i][j]);
            }
        }

        return result[size][num];
    }
    static int coinChangeNumbrOfWays(int coins[], int size, int num) {

        int result[][] = new int[size][num + 1];

        for(int i = 0; i < size; i++) {
            for (int j = 0; j <= num; j++) {
                if(i == 0) {
                    result[i][j] = j % coins[i] == 0 ? 1 : 0;
                }
                else if(coins[i] > j) {
                    result[i][j] = result[i-1][j];
                }
                else {
                    result[i][j] = result[i-1][j] + result[i][j-coins[i]];
                }
            }
        }

        return result[size-1][num];
    }



    static int intcoinChangeNumbrOfWays(int[] a, int n){
        int[][] dp=new int[a.length+1][n+1];
        for(int i=0; i<a.length+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0){
                    dp[i][j]=0;
                    continue;
                }
                if(j==0)
                    dp[i][j]=1;
                else{
                    if(j >= a[i-1])
                        dp[i][j] = dp[i-1][j] + dp[i][j-a[i-1]];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[a.length][n];
    }


    static int getWays(int coins[], int size, int num) {
        int dp[][] = new int[size + 1][num + 1];

        for(int i = 0; i <= size; i ++) {
            for(int j = 0 ; j <= num; j++) {
                if(i==0){
                    dp[i][j]=0;
                    continue;
                }
                if(j==0)
                    dp[i][j]=1;
                else {
                    if (coins[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
         }

        return dp[size][num];
    }

    static boolean subsetSumProblem(int set[], int n, int sum) {

        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for(int i =1  ; i < n; i++) {
            for(int j = 1; j<= sum; j++) {
                if(set[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
                }
            }
        }

        return dp[n][sum];

    }


    public static void main(String[] args) {
        int arr1[] = {1, 5, 9, 10, 15, 20};
        int arr2[] = {2, 3, 8, 13};
        merge(arr1, arr2, 0, 0);
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
//        int arr[] = {2,5,3,6};
//        int m = arr.length;
//        int n = 10;
//        System.out.println(coinChangeNumbrOfWays(arr, m, n));

        int coins[] = {1,2,3};

        int m = coins.length;
        int V = 4;
        System.out.println ( "Minimum coins required is "
                + getWays(coins, m,  V));

        int coins1[] = {1,5,6,9};
        int m1 = coins.length;
        int V1 = 12;
        System.out.println ( "Minimum coins required is "
                + coinChange1(coins1, m1, V1));
    }
}
