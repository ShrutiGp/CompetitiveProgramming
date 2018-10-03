package DPPrograms;

import java.util.*;
import java.lang.*;
import java.io.*;

//GeeksForGeeks
class RodCutting {
    static BufferedReader br;
    static StringTokenizer st;


    static int result(int price[], int n) {
        int maxPrice[] = new int[n+1];
        maxPrice[0]=0;
        for(int i = 1; i<=n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                max= Math.max(max, price[j]+maxPrice[i-j-1]);
            }
            maxPrice[i] = max;
        }
        return maxPrice[n];
    }

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }

            out.print(result(arr, size));
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