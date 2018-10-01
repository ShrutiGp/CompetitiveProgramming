package Arrays;

import java.util.*;
        import java.lang.*;
        import java.io.*;

class ChocolateDistribution{
    static BufferedReader br;
    static StringTokenizer st;

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
            int m = Integer.parseInt(next());
            Arrays.sort(arr);
            int min = Math.abs(arr[0]-arr[m-1]);
            for(int j=1; j <size; j++) {
                if(j+m-1 < size) {
                    if(Math.abs(arr[j] - arr[j+m-1]) < min) {
                        min = Math.abs(arr[j] - arr[j+m-1]);

                    }
                }
            }
            out.println(min);
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
