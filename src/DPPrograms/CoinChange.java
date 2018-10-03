package DPPrograms;

import java.util.*;
import java.lang.*;
import java.io.*;

//GeeksForGeeks
class CoinChange {
    static BufferedReader br;
    static StringTokenizer st;


    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int k = 0 ; k < T;k++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }
            int sum = Integer.parseInt(next());

            int arrayOfSums[][] = new int[size][sum+1];

            for(int i = 0; i < size; i++ ) {
                for(int j=1; j<=sum; j++) {
                    if(i==0) {
                        arrayOfSums[i][j] = (j%arr[i]==0 ? 1 : 0);
                    }else {
                        if(j<arr[i]) {
                            arrayOfSums[i][j] = arrayOfSums[i-1][j];
                        } else if(j==arr[i]) {
                            arrayOfSums[i][j] = 1+arrayOfSums[i-1][j];
                        } else {
                            arrayOfSums[i][j] = arrayOfSums[i-1][j] + arrayOfSums[i][j-arr[i]];
                        }
                    }
                }
            }


            out.println(arrayOfSums[size-1][sum]);

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