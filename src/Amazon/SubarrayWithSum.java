package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class SubarrayWithSum {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(br.readLine());
        String output[] = new String[numberOfTests];
        for(int i = 0 ; i <  numberOfTests; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int sum = Integer.parseInt(st.nextToken());

            StringTokenizer arrayElements = new StringTokenizer(br.readLine());
            int array[] = new int[size];
            int index = 0;
            while(index < size && arrayElements.hasMoreTokens()) {
                array[index]=Integer.parseInt(arrayElements.nextToken());
                index++;
            }

            int start = 0;
            int temp = array[start];
            boolean found = false;
            for(int j = 1; j <= size ; j++) {

                while(temp > sum && start < j-1) {
                    temp -= array[start];
                    start++;
                }
                if(temp == sum) {
                    found = true;
                    output[i] =   (start+1) + " " + (j) ;
                    break;
                }
                if(temp < sum) {
                    temp += array[j];
                }
            }
        }

        for( int i =0 ; i < numberOfTests; i++) {
            System.out.println(output[i]);
        }
    }
}
