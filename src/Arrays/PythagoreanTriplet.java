package Arrays;

import java.lang.*;
        import java.io.*;
        import java.util.*;

class PythagoreanTriplet{
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out);

    static boolean getRes(Integer arr[], int size) {

        for(int i=(size-1); i>=2; i--) {
            int sum = arr[i];

            int l = 0;
            int r = i-1;

            while(l<r) {
                if(arr[l] + arr[r] == sum) {
                    out.println("Yes");
                    return true;
                }
                if(arr[l]+ arr[r] < sum)
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());

        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            Integer arr[] = new Integer[size];


            for(int j =0 ; j < size; j++) {
                int num = Integer.parseInt(next());
                arr[j]=(num*num);
            }
            Arrays.sort(arr);
            boolean found = getRes(arr, size);
            if(!found)
                out.println("No");


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
