import java.io.*;

class Hi {

    // Utility functions to get minimum of two integers
    static int min(int x, int y) { return x < y ? x : y; }

    // Utility functions to get maximum of two integers
    static int max(int x, int y) { return x > y ? x : y; }

    /* Returns the product of max product subarray.
    Assumes that the given array always has a subarray
    with product more than 1 */
    static int maxSubarrayProduct(int arr[])
    {
        int n = arr.length;
        int maxValue = 1;
        int count = 0;
        int min_ending_here = 1;

        int max_so_far = 1;
        int flag = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] > 0) {
                count++;
                maxValue = maxValue * arr[i];
                System.out.println("max val is : " + maxValue);
                min_ending_here = min(min_ending_here * arr[i], 1);
                flag = 1;
            }
            else if (arr[i] == 0) {
                count=0;
                maxValue = 1;
                min_ending_here = 1;
            }
            else {
                int temp = maxValue;
                System.out.println("min ending : " + min_ending_here);
                if(min_ending_here * arr[i] > 1) {
                    System.out.println("YES");
                    if(min_ending_here < 0) {
                        count++;
                    }
                    count++;
                }
                maxValue = max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
            System.out.println(max_so_far + " " + maxValue + " : " + min_ending_here);
            if (max_so_far < maxValue) {
                max_so_far = maxValue;
            }

            System.out.println("MAX SO FAR " + max_so_far);
        }

        if (flag == 0 && max_so_far == 1)
            return 0;
        return count;
    }

    public static void main(String[] args)
    {

        int arr[] = { -3,5};
        System.out.println("Maximum Sub array product is "
                + maxSubarrayProduct(arr));
    }
} 