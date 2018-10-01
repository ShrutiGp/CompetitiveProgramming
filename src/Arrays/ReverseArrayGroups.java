package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class ReverseArrayGroups {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int k = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }

            for(int l = 0; l < size; l++) {
                int var = l+(k-1) > size-1 ? size-1: l+(k-1);
                for(int m = var; m >= l ; m--) {
                    out.print(arr[m] + " ");
                }
                l = var;
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

