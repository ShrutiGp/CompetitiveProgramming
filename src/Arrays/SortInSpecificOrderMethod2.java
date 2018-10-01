package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class SortInSpecificOrderMethod2 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T ;i++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j] = Integer.parseInt(next());
            }
            Comparator<Integer> comp = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1%2 == 0 && o2%2 != 0)
                        return 1;
                    else if(o1%2 != 0 && o2%2 == 0)
                        return -1;
                    else if(o1%2 == 0 && o2%2 ==0) {
                        return Integer.compare(o1,o2);
                    }
                    else if(o1%2 != 0 && o2%2 != 0)
                        return Integer.compare(o2,o1);

                    return 0;
                }
            };
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < size; j++) {
                list.add(arr[j]);
            }
            Collections.sort(list, comp);
            list.stream().forEach(num -> {
                out.print(num + " ");
            });
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
