import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassForAll {

    // Question 1 Arrays Start
    static int finalSum = 12;
    static void getSubArray(int arr[], int currentIndex, int startIndex, int currentSum) {

        if(currentIndex >= arr.length) {
            System.out.println("NO subarray");
            return;
        }
        if(currentSum == finalSum) {
            System.out.println("OUTPUT " + startIndex + " to " + currentIndex);
            return;
        }
        currentSum = currentSum + arr[currentIndex];
        if(currentSum > finalSum) {
            getSubArray(arr, currentIndex, startIndex + 1, currentSum-arr[startIndex]);
        }

        if(currentSum < finalSum) {
            getSubArray(arr, currentIndex + 1, startIndex, currentSum);
        }

    }

    static void subArrayWithSum() {
        int arr[] = {1,2,3,7,5};
        int sum = 12;
        int currentSum = 0;
        int startIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if(currentSum > sum) {
                while(currentSum > sum && startIndex < i) {
                    currentSum = currentSum - arr[startIndex];
                    startIndex++;
                }
            }

            if(currentSum == sum) {
                System.out.println("My result is : " + startIndex + " to "+ i);
                break;
            }
        }
    }

    // Question 1 Arrays End


    static void mergeTwoArraysInOne(int arr1[], int arr2[]) {

        int start1 = 0;
        int start2 = 0;

        for(int i = 0 ; i < arr1.length; i++) {
            int temp = arr1[i];
            if(temp > arr2[0]) {
                arr1[i] = arr2[0];
                int index = 1;
                while(index < arr2.length && arr2[index] < temp) {
                    arr2[index - 1] = arr2[index];
                    index++;
                }
                arr2[index - 1] = temp;
            }
        }

        for(int i = 0 ; i < arr1.length; i++) {
            System.out.println(" i : " + arr1[i]);
        }

        for(int i = 0 ; i < arr2.length; i++) {
            System.out.println(" i : " + arr2[i]);
        }
    }

    static void getAlternateByMax(int arr1[]) {
        int temp[] = new int[arr1.length];

        int min = 0;
        int max = arr1.length - 1;
        for(int i = 0; i < arr1.length; i++) {
            if(i % 2 == 0) {
                temp[i] = arr1[max];
                max--;
            } else {
                temp[i] = arr1[min];
                min++;
            }
        }

        for(int i = 0 ; i < temp.length; i++) {
            System.out.println(" i : " + temp[i]);
        }
    }

    static void getAlternateByNegativePositive(int arr1[]) {
        int temp[] = new int[arr1.length];

        int i = -1;
        int j = arr1.length;
        while(i < j) {
            while(arr1[++i] > 0);
            while(arr1[--j] < 0);
            if(i < j) {
                int temp1 = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] = temp1;
            }
        }

        int k = 0;
        while(k < arr1.length && i < arr1.length) {
            int temp1 = arr1[k];
            arr1[k] = arr1[i];
            arr1[i] = temp1;

            k = k + 2;
            i++;
        }

        for(int l = 0 ; l < temp.length; l++) {
            System.out.println(" i : " + temp[l]);
        }
    }

    static int getEquilibriumPoint(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i)
            sum += arr[i];

        int leftSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum = sum - arr[i];
            if(leftSum == sum) {
                return  i;
            }
            leftSum = leftSum + arr[i];
        }

        return -1;

    }

    static void printLeaders(int arr[]) {

        int maxTillNow = arr[arr.length - 1];
        System.out.println(" Leader : " + maxTillNow);
        for(int i = arr.length - 2; i >= 0; i--) {

            if(arr[i] > maxTillNow) {
                System.out.println("Leader : " +  arr[i]);
                maxTillNow = arr[i];
            }
        }
    }


    static void reverseArray(int arr[], int size) {

        int startIndex = 0;
        while (startIndex <= (arr.length - size)) {
            int endIndex = startIndex + size - 1;
            int s = startIndex;
            while(s < endIndex) {
                int temp = arr[endIndex];
                arr[endIndex] = arr[s];
                arr[s] = temp;

                endIndex--;
                s++;
            }
            startIndex = startIndex + size;
        }
        System.out.print("reverseArray : ");
        for(int l = 0 ; l < arr.length; l++) {
            System.out.print(arr[l] + " ");
        }
    }

    static void reverseByRecursion(int arr[], int start, int size) {
        if(start > arr.length - size) {
            System.out.print("reverseByRecursion");
            for(int l = 0 ; l < arr.length; l++) {
                System.out.print(arr[l] + " ");
            }
            return;
        }
        int s = start;
        int e = start + size - 1;
        while(s < e) {
            int temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;

            e--;
            s++;
        }

        reverseByRecursion(arr, start + size, size);
    }

    static boolean isTriplet(int arr[]) {

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        for(int i = arr.length - 1; i >= 2; i--) {

            int start = 0;
            int end = i-1;
            int sum = arr[i];
            while (start < end) {
                if(arr[start] + arr[end] < sum) {
                    start++;
                } else if(arr[start] + arr[end] == sum) {
                    System.out.println("Found triplet : "+  sum + " : " + arr[start] + " : " + arr[end]);
                    return true;
                } else {
                    end--;
                }
            }
        }

        return false;

    }

    static int lcsustring(String s1, String s2, int start1, int start2, int count) {
        if(start1 == s1.length() || start2 == s2.length()) {
            return count;
        }

        if(s1.charAt(start1) == s2.charAt(start2)) {
            return lcsustring(s1, s2, start1 + 1, start2 + 1, count + 1);
        }

        return Math.max(lcsustring(s1, s2, start1 +1, start2, 0), lcsustring(s1, s2, start1, start2 + 1, 0));
    }

    static int longestSubseq(String s1, String s2, int start1, int start2) {
        if(start1 == s1.length() || start2 == s2.length()) {
            return 0;
        }
        if(s1.charAt(start1) == s2.charAt(start2)) {
            return 1 + longestSubseq(s1, s2, start1 + 1, start2 + 1);
        }

        return Math.max(longestSubseq(s1, s2, start1 + 1, start2), longestSubseq(s1, s2, start1, start2 + 1));

    }

    static int longestIncreasingSubsequence(int arr[], int n) {
        int[] lis = new int[n];

        for(int i = 0 ; i < n ; i++) {
            lis[i] = 1;
        }

        for(int i = 1; i < n ; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++) {
            if(lis[i] > max)
                max = lis[i];
        }

        return max;
    }

    static int maxValueKnapSack(int W, int weights[], int values[], int n) {
        int dp[][] = new int[n+1][W+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0 ; j <= W; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], values[i - 1] + dp[i][j - weights[i-1]]);
                }
            }
        }

        return dp[n][W];
    }

    static int numberOfWays(int coins[], int size, int num) {
        int dp[][] = new int[size + 1][num + 1];

        for(int i = 0 ; i <= size; i++) {
            for(int j = 0 ; j <= num ; j ++) {
                if(i == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if(j == 0) {
                    dp[i][j] = 1;
                } else {
                    if(j < coins[ i -1]) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                    }
                }
            }
        }

        return dp[size][num];
    }

//    boolean subsetSum(int arr[], int n, int sum) {
//        boolean dp[][] = new boolean[][][n + 1][sum + 1];
//
//        for(int i = 0 ; i <= n; i++) {
//            for(int j = 0 ; j <= sum; j++) {
//                if(i == 0 ) {
//                    dp[i][j] = false;
//                    continue;
//                }
//                if(j == 0) {
//                    dp[i][j] = true;
//                } else {
//                    if( j < arr[i - 1]) {
//                        dp[i][j] = dp[i-1][j];
//                    } else {
//                        dp[i][j] = dp[i-1][j] || dp[i][j - arr[i-1]];
//                    }
//                }
//
//            }
//        }
//
//        return dp[n][sum];
//    }

    static int maxValueByRodCutting(int value[], int n) {
        int dp[][] = new int[n+1][n+1];


        for(int i = 0 ; i <= n; i++) {
            for(int j = 0 ; j <= n; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else {
                    if(j < i) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i][j - i]);
                    }
                }
            }

        }

        return dp[n][n];
    }

    public static void main(String[] args) {
        int rods[] = {1, 5, 8, 9, 10, 17, 17, 20};

        int rodCutting= maxValueByRodCutting(rods, rods.length);
        System.out.println("ROD CUTTING : "+ rodCutting);
        int arrd[] = { 6, 2, 5 };
        int sum = 1;

        System.out.println("isSubsetSum " + numberOfWays(arrd, arrd.length, sum));


        int val[] = {4,5,6};
        int wt[] = {1,2,3};
        int  W = 3;
        int knapsack = maxValueKnapSack(W, wt, val, 3);
        System.out.println("knapsack : " + knapsack);


        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int count = lcsustring(s1, s2, 0, 0 ,0);
        System.out.println("LONGEST SUBSTRING " + count);

        String st1 = "ABCDGH";
        String st2 = "AEDFHR";
        int count2 =  longestSubseq(st1, st2, 0, 0);
        System.out.println("longest subseq " + count2);
        //Question 1 arrays
        int arr[] = {1,2,3,7,5};
        getSubArray(arr, 0, 0, 0);
        subArrayWithSum();




        // Question 5
        int arr1[] = {1, 3,5,7};
        int arr2[] = {0,2,6,8,9};
       // mergeTwoArraysInOne(arr1, arr2);

        //Question 6
        getAlternateByMax(arr1);

        int arr3[] = { -7, 1, 5, 2, -4, 3, 0 };
        int res = getEquilibriumPoint(arr3);
        System.out.println("Eq point : " + res);

        int arr4[]= {1,2,3,4,0};
        printLeaders(arr4);

        reverseArray(arr3, 2);
        reverseByRecursion(arr3, 0, 2);

        int a[] = {3,2,4,6,5};
        isTriplet(a);


        List<String> s = new ArrayList<>();
        s.add("54");
        s.add("04");

        Collections.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String XY = o1 + o2;
                String YX = o2 + o1;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
    }
}
