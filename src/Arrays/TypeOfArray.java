package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

//GeeksForGeeks
class TypeofArray {
    static BufferedReader br;
    static StringTokenizer st;

    static boolean checkAsc(int arr[], int pos) {
        for(int i = pos; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    static boolean checkDsc(int arr[], int pos) {
        for(int i = pos; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    static int findType(int arr[]) {
        int j = 0;
        int pos =0;
        for(int i = 0; i < arr.length-2; i++){

            if(arr[i] >= arr[i+1] && arr[i+1] < arr[i+2]) {
                j = 3;
                pos = i+2;
                break;
            }  else if(arr[i] <= arr[i+1] && arr[i+1] > arr[i+2]) {
                j = 4;
                pos = i+2;
                break;
            } else if(arr[i] >= arr[i+1]) {
                j = 2;
            } else if(arr[i] <= arr[i+1]) {
                j=1;
            }
        }

        boolean isAsc = checkAsc(arr, pos);
        boolean isDsc = checkDsc(arr, pos);

        if(pos == 2) {
            if(j == 3 && isAsc) {
                j = 4;
            }
            if(j == 4 && isDsc) {
                j=3;
            }
        }
        return j;
    }
    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int k = 0 ; k < T;k++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];
            int max = Integer.MIN_VALUE;
            for(int j =0 ; j<size; j++) {
                arr[j]=Integer.parseInt(next());
                if(arr[j] > max)
                    max = arr[j];
            }
            out.println( max + " " + findType(arr));
        }
        out.flush();
    }

    public static String next() {
        if(st.hasMoreTokens()) {
            return st.nextToken();
        } else {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
}