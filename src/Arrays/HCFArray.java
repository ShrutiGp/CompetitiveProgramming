package Arrays;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

class HCFArray {
    static BufferedReader br;
    static StringTokenizer st;
    public static int hcf(int a, int b) {


        if (b == 0)
            return a;
        else
            return hcf(b, a % b);
    }

    public static int hcf(int arr[]) {
        int temp = arr[0];
        for(int i =1; i<= arr.length-1; i++)
            temp = hcf(temp, arr[i]);
        return temp;

    }
    public static void main(String args[] ) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int n = Integer.parseInt(next());
        int a[] = new int[n];
        for(int j =0 ; j < n; j++) {
            a[j] = Integer.parseInt(next());
        }

        System.out.print(hcf(a));

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
