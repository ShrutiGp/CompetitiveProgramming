package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CountTriplets {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(br.readLine());
        String output[] = new String[numberOfTests];

        for(int i = 0 ; i <  numberOfTests; i++) {
            int size = Integer.parseInt(br.readLine());

            StringTokenizer arrayElements = new StringTokenizer(br.readLine());
            int array[] = new int[size];
            int index = 0;
            while(index < size && arrayElements.hasMoreTokens()) {
                array[index]=Integer.parseInt(arrayElements.nextToken());
                index++;
            }
            Arrays.sort(array);
            int count = 0;
            for(int k = size -1; k >=0; k--) {
                int start = 0;
                int end = k-1;
                while (start < end) {
                    if((array[start] + array[end])  == array[k]) {
                        count++;
                        start++;
                    } else if((array[start] + array[end])  < array[k]) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }

            if(count > 0) {
                output[i] = String.valueOf(count);
            } else {
                output[i] = "-1";
            }
        }

        for( int i =0 ; i < numberOfTests; i++) {
            System.out.println(output[i]);
        }
    }
}
