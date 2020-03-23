package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayPendulum
{

    static PrintWriter out = new PrintWriter(System.out);

    static void nextGreatestUsingStack(int a[]) {
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.push(a[0]);

        for(int i = 1; i < a.length; i++) {
            if(st.peek() < a[i]) {
                st.pop();
                list.add(a[i]);
            }

            st.push(a[i]);
        }

        while(!st.isEmpty()) {
            st.pop();
            list.add(-1);
        }

        out.println(list.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));


    }

    static int minimumJumps(int arr[], int n) {
        int jumps[] = new int[n];

        if(arr[0] == 0 || n == 0) {
            return Integer.MAX_VALUE;
        }
        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for(int j = 0 ; j < i ; j++) {
                if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }

        return jumps[n-1];

    }


    public static void main(String[] args)
    {
        int arr[] = {1,2,3,7,5};
        getSubArray(arr, 0, 0, 0);
        subArrayWithSum();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine()); //reads integer
//
//        while(t-- > 0) {
//
//            int size = Integer.parseInt(br.readLine());
//
//            int b[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//
//            out.println(minimumJumps(b, b.length));
//
//
//        }
//
//        out.flush();
//        out.close();
    }

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
}