package StringPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ReverseWords {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int k = 0 ; k < T; k++) {
            String str = next();
            String arr[] = str.split("\\.");
            for(String s  : arr) {
                System.out.println("----" + s);
            }
            String newArray[] = new String[arr.length];
            System.out.println(str);
            for(int j =0; j < arr.length; j++) {
                newArray[(arr.length - j- 1)] = arr[j];
            }
            for(int l = 0; l < newArray.length; l++) {
                System.out.println("new array " +newArray[l]);
            }

        }
        out.flush();
    }

    public static String next() {
        if (st.hasMoreTokens()) {
            return st.nextToken();
        } else {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
}
