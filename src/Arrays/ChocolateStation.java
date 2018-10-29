package Arrays;

import java.lang.*;
        import java.io.*;
        import java.util.*;

class ChocolateStation{
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());

        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];

            for(int j =0 ; j < size; j++) {
                arr[j] = Integer.parseInt(next());
            }
            int cost = Integer.parseInt(next());

            int a[] = new int[size];

            int chocBought = arr[0] ;
            int chocBalance = 0;

            for(int j=1; j<size; j++) {
                int res =arr[j-1] - arr[j];
                if(res > 0) {
                    chocBalance += res;
                } else if(res < 0) {
                    res = Math.abs(res);
                    chocBought += Math.abs(res > chocBalance ? (res-chocBalance) : 0);
                    chocBalance = chocBalance - Math.abs(res > chocBalance ? chocBalance : res);
                }
            }
            out.println(chocBought*cost);

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