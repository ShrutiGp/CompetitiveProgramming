package Amazon;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class RainWater {

    static int findWaterUnits(int a[],int n) {

        int i = 0, j = n-1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while(i <= j) {
            if(a[i] < a[j]) {
                if (a[i] > leftMax)
                    leftMax = a[i];
                else {
                    result += (leftMax - a[i]);
                }
                i++;
            } else {
                if(a[j] > rightMax)
                    rightMax = a[j];
                else {
                    result += (rightMax - a[j]);
                }
                j--;
            }
        }
        return result;
    }

    static char flip(char f) {
        return f == '0' ? '1' : '0';
    }
    static int modif(String str, char expectedChar) {
        char ch[] = str.toCharArray();
        int count = 0;
        for(int i = 0 ; i < ch.length; i++) {
            if(ch[i] != expectedChar) {
                count++;
            }
            expectedChar = flip(expectedChar);
        }
        return count;
    }

    static boolean getAns(int arr[], int start, int end, int num) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            if (sum < num) {
                sum = sum + arr[i];
            } else {
                while (sum > num && start < i) {
                    sum = sum - arr[start];
                    start++;
                }
                if (sum == num) {
                    System.out.println("sum nu found " + sum + " " + num );
                    return true;
                }
            }
        }
        return false;
    }

    static int getVal(int arr[]) {
        Arrays.sort(arr);

        for(int i = arr.length - 1; i > 0 ; i--) {
            int num = arr[i];
            int start = 0;
            boolean exists = false;
            System.out.println("exists : " + num);
            int sum = 0;
            int end = i - 1;
            boolean ans = getAns(arr, start, end, num);
            if(!ans) {
                System.out.println("not exist " + num);
                return 0;
            }
        }

        System.out.println("all exist");
        return 1;
    }

    static int findSmallest(int arr[], int n)
    {
        int res = 1; // Initialize result

        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < n && arr[i] <= res; i++)
            res = res + arr[i];

        return res;
    }

    static void smallestPositiveInt(int arr[]) {
        boolean found = true;
        int num = 1;
        while(found) {
            int start = 0;
            int end = arr.length;
            System.out.println("start with num " + num);
            int sum = 0;
            boolean f = false;
            for(int i = start ; i < end; i++) {
                if(sum < num) {
                    System.out.println("sum < num + " + sum + " : " + num);
                    sum = sum + arr[i];
                }
                else if(sum > num) {
                    while(sum > num && start < i) {
                        sum = sum - arr[start];
                        start++;
                    }
                }

                if(sum == num) {
                    System.out.println("FOUND + " + num);
                    f = true;
                    break;
                }
            }
            if(!f) {
                System.out.println("NOT FOUND : !!!  "+ num);
                break;
            }
            num++;
        }
    }

    static int findSmall(int arr[], int n) {
        int res = 1;

        for(int i = 0 ; i < n && arr[i] <= res; i++) {

            res = res + arr[i];
        }

        return res;
    }

    static int cal_log(int n)
    {
        System.out.println("log of " + n) ;
        int ans = 0;

        while (n > 0)
        {
            n /= 2;
            ans++;
        }

        return ans;
    }


    static int rodCutting(int n, int arr[]) {
        int dp[][] = new int[n+1][n+1];

        for(int i = 0 ; i <= n; i++) {
            for(int j = 0 ; j <=n; j++) {
                if(i ==0 || j== 0 )
                    dp[i][j] = 0;
                else {
                    if(i > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], arr[i-1] + dp[i][j - i]);
                    }
                }
            }
        }

        return dp[n][n];
    }


    // Function to return the maximum
// height of the tree
    static int maximumHeight(int n, int arr[])
    {
        System.out.println("n " + n + "  with " + (n/2) + " & " + ((n%2) )+" .. " + (n / 2 + n % 2));
        int level = cal_log(n / 2 + n % 2);
        return (level - 1);
    }

    public static void main(String[] args)
    {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1,
                3, 2, 1, 2, 1 };
        int n = arr.length;
        System.out.println("Maximum water that "
                + "can be accumulated is "
                + findWaterUnits(arr, n));

        String str = "001";
        System.out.println(modif(str, '0'));
        System.out.println(modif(str, '1'));
        System.out.println(Math.min(modif(str, '0'), modif(str, '1')));

        int a[] = {1, 2,3,4,5};
        System.out.println("VAL " + getVal(a));
        int arr2[] = {1, 1, 1, 1};
        smallestPositiveInt(arr2);
        System.out.println("hi" + findSmall(a, a.length));



        int ar11[] = { 1, 2, 3, 4, 6 };
        System.out.print( "height " + maximumHeight(ar11.length, ar11));


    }
}
