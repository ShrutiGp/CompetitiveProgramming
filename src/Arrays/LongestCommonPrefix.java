package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

//GFG
class LongestCommonPrefix {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int k = 0 ; k < T;k++) {
            int size = Integer.parseInt(next());
            String arr[] = new String[size];
            int min = Integer.MAX_VALUE;
            String minString = null;
            for(int j =0 ; j<size; j++) {
                arr[j]=next();

                if(arr[j].length() < min) {
                    min = arr[j].length();
                    minString = arr[j];
                }
            }

            int length = minString.length();
            String check = minString.substring(0, length);
            boolean found = true;
            for(int j = 0; j < size; j++) {
                if(arr[j].indexOf(check) == -1) {
                    found = false;
                }
                if(j == size-1 && found) {
                    out.println(check);
                    break;
                }
                if(arr[j].indexOf(check) == -1 && length > 2) {
                    j = 0;
                    check = minString.substring(0, --length);
                    found = true;
                }
            }
            if(found == false) {
                out.println("-1");
            }
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