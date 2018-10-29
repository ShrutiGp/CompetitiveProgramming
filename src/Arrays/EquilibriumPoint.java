package Arrays;

import java.lang.*;
        import java.io.*;
        import java.util.*;

class EquilibriumPoint{
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());

        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            Integer arr[] = new Integer[size];

            for(int j =0 ; j < size; j++) {
                arr[j] = Integer.parseInt(next());
            }
            boolean found = false;
            if(size == 1) {
                out.println(arr[0]);
                found=true;
            } else {
                int start = 1, prevsum = arr[0];
                int sum = Arrays.stream(arr).mapToInt(l -> l).sum();

                int afterSum = sum - arr[0] - arr[1];
                for (int j = 1; j < size - 1; j++) {
                    if (prevsum == afterSum) {
                        out.println(j+1); //eq
                        found=true;
                        break;
                    }
                    prevsum += arr[start];
                    start++;
                    afterSum -= arr[start];
                }
            }
            if(!found) {
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