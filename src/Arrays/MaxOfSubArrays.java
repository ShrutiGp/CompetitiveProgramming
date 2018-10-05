package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxOfSubArrays{
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int w = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }
            for(int j =0 ;j < size-w; j++) {
                int max = 0;
                for(int k = j; k < j+(w-1); k++) {
                    out.println(k);
                    if(arr[k] > max)
                        max = arr[k];
                }
                out.print(max + " ");
            }
            out.println();
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
