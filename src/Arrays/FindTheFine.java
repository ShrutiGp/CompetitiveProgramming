package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

//GFG
class FindTheFine {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int k = 0 ; k < T;k++) {
            int size = Integer.parseInt(next());
            int date = Integer.parseInt(next());

            long map[][] = new long[size][2];
            for(int j =0 ; j<size; j++) {
                map[j][0] = Long.parseLong(next());
            }
            for(int j =0 ; j<size; j++) {
                map[j][1] = Long.parseLong(next());;
            }

            long fine = 0;
            if(date%2 == 0) {
                for(int j = 0; j < size; j++) {
                    if(map[j][0] % 2 != 0) {
                        fine+= map[j][1];
                    }
                }
            } else {
                for(int j = 0; j < size; j++) {
                    if(map[j][0] % 2 == 0) {
                        fine+= map[j][1];
                    }
                }
            }
            out.println(fine);

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