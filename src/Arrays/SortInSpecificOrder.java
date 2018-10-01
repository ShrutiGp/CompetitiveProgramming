package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class SortInSpecificOrder {
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
            List<Integer> evenList = new ArrayList<>();
            List<Integer> oddList = new ArrayList<>();
            for(int j = 0; j < size; j++) {
                if(arr[j] % 2  == 0) {
                    evenList.add(arr[j]);

                } else {
                    oddList.add(arr[j]);
                }
            }
            evenList = evenList.stream().sorted().collect(Collectors.toList());
            oddList = oddList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            oddList.addAll(evenList);
            oddList.stream().forEach(num-> {
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
