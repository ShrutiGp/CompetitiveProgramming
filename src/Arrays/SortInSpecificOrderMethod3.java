package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

//Execution Time:2.85 sec
class SortInSpecificOrderMethod3 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T ;i++) {
            int size = Integer.parseInt(next());
            Integer arr[] = new Integer[size];
            int oddCount = 0;
            for(int j =0 ; j < size; j++) {
                arr[j] = Integer.parseInt(next());
                if(arr[j]%2 !=0)
                    oddCount++;
            }

            int l =0, r = size-1, temp = 0;
            while(l < r) {
                if(arr[l]%2 == 0 && arr[r]%2 !=0) {
                    temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++;
                    r--;
                } else {
                    if(arr[l]%2 != 0) {
                        l++;
                    }
                    if(arr[r]%2 == 0 && l<r) {
                        r--;
                    }
                }
            }

            Arrays.sort(arr, 0, oddCount, Collections.reverseOrder());
            Arrays.sort(arr, oddCount, size);

            for(int k = 0 ; k < size; k++) {
                out.print(arr[k] + " ");
            }
            out.println();
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
