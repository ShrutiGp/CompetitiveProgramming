package Arrays;


import java.util.*;
import java.lang.*;
import java.io.*;

class SubarrayWithGivenSum{
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int sum = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }


            boolean found = false;
            for(int j=0; j<size; j++) {
                int store = 0;
                for(int k=0; k<size; k++) {
                    if(k <= j)
                        store = 0;
                    else {
                        if(store == 0) {
                            store = arr[j] + arr[k];
                        }
                        else {
                            store += (arr[k]);
                    }
                        if(store == sum) {
                            out.println(j+1 + " " + (k+1));
                            found = true;
                            break;
                        }
                    }
                    if(found)
                        break;
                }
            }
            if(!found)
                out.println("-1");
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
