package Amazon;

import java.util.*;
import java.util.stream.Collectors;

public class ElementInMiddle {

    static void ElementInMiddle(int a[], int n) {
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];

        leftMax[0] = Integer.MIN_VALUE;
        rightMin[n-1] = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], a[i-1]);
        }
        for(int j = n-2; j >= 0; j--) {
            rightMin[j] = Math.min(a[j+1], rightMin[j+1]);
        }

        for(int k = 0; k < n; k++) {
            if(leftMax[k] < a[k] && rightMin[k] > a[k]) {
                System.out.println("Answer found " + a[k]);
                return;
            }
        }
    }

    static void elementCompare(String arr[]) {
        List<String> myList = Arrays.stream(arr).collect(Collectors.toList());
        Collections.sort(myList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String XY = o1+o2;
                String YX = o2+o1;
                System.out.println(XY + " " + YX + " " + XY.compareTo(YX));
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        System.out.println(myList);
    }

    static int maxDifference(int a[]) {
        int maxDiff = 0;
        int minNumber = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] - minNumber > maxDiff) {
                maxDiff = a[i] - minNumber;
            }
            if(a[i] < minNumber) {
                minNumber = a[i];
            }
        }
        return maxDiff;
    }

    static int maxDifferencd(int arr[]) {
        int maxDiff = 0;
        int minimumNumber = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int diff = arr[i] - minimumNumber;
            if(diff > maxDiff) {
                maxDiff = diff;
            }
            if(arr[i] < minimumNumber) {
                minimumNumber = arr[i];
            }
        }

        return maxDiff;
    }

    static int maxProfitStockBuy(int price[], int start, int end) {
        // If the stocks can't be bought
        if (end <= start)
            return 0;
        System.out.println("Start and End : " + price[start] + "  " + price[end]);
        // Initialise the profit
        int profit = 0;

        // The day at which the stock
        // must be bought
        for (int i = start; i < end; i++) {
            // The day at which the
            // stock must be sold
            for (int j = i + 1; j <= end; j++) {
                // If byuing the stock at ith day and
                // selling it at jth day is profitable
                if (price[j] > price[i]) {
                    System.out.println("Calling " + start + " , " + (i-1) + " : " + (j+1) + " , " + end);
                    // Update the current profit
                    int curr_profit = price[j] - price[i] + maxProfitStockBuy(price, start, i - 1) + maxProfitStockBuy(price, j + 1, end);
                    System.out.println("Current Profit" + curr_profit + " : " + profit);
                    // Update the maximum profit so far
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    static void printMatrixSpirally(int arr[][], int row, int col, int m , int n) {

        if(row >= m || col >= n) {
            return;
        }
        for(int i = col; i< n; i++) {
            System.out.println(arr[row][i]);
        }

        for(int i = row + 1; i < m; i++) {
            System.out.println(arr[i][n-1]);
        }

        if(row != (m-1)) {
            for (int i = n - 2; i >= col; i--) {
                System.out.println(arr[m - 1][i]);
            }
        }

        if(col != (n-1)) {
            for (int i = m - 2; i >= row + 1; i--) {
                System.out.println(arr[i][col]);
            }
        }
        System.out.println("ONE ROUND DONE");
        printMatrixSpirally(arr, row+1, col+1, m-1, n-1);
    }

    public static void main(String... s) {
        int a[] = {4,2,5,7};
        String str[] = { "9", "34", "30", "3", "5"};
        elementCompare(str);  //https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
        ElementInMiddle(a, a.length); //

        int arr[] = {2, 3, 10, 6, 4, 8, 1};
        System.out.println("Max Difference " + maxDifference(arr) );


        int price[] = { 100, 180, 260, 310,
                40, 535, 695 };
        System.out.println(maxProfitStockBuy(price, 0, price.length-1));

        int a1[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printMatrixSpirally(a1, 0, 0, a1.length, a1[0].length);
    }
}
