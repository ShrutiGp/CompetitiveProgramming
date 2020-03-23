package Amazon;

import java.util.Arrays;
import java.util.Scanner;

class Result {
    int length;
    int num;
    int array[];

    public Result(int length, int num, int array[]) {
        this.length = length;
        this.num = num;
        this.array = array;
    }
}

public class NumberOfOccurences {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        Result resultArray[] = new Result[T];
        for(int i = 0 ; i < T; i++) {
            int details[]  =  Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int array[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            resultArray[i] = new Result(details[0], details[1], array);
        }

        for(int i = 0; i < T; i++) {
            Result r = resultArray[i];
            int count = 0;
            for(int j = 0; j < r.length; j++) {
                if(r.array[j] == r.num)
                    count++;
            }
            if(count == 0)
            {
                System.out.println("-1");
            } else {
                System.out.println(count);
            }
        }
    }
}
