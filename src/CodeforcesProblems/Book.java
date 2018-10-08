package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;
public class Book{

    static int countDays(int n ,int arr[], int i, int sum) {
        sum = sum + arr[i];
        if(sum >= n){
            System.out.print(i+1);
            return 1;
        }
        if(i < arr.length-1)
            i++;
        else
            i = 0;
        countDays(n, arr, i, sum);

        return 0;
    }

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int arr[]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        countDays(n, arr, 0, 0);

    }
}
