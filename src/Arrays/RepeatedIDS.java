package Arrays;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class RepeatedIDS {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T ;i++) {
            int size = Integer.parseInt(next());
            StringBuilder sb = new StringBuilder();
            for(int j =0 ; j < size; j++) {
                String str = next();
                if(sb.indexOf(str) == -1)
                    sb.append(str).append(" ");
            }
            List<Integer> l= new ArrayList<>();
            l = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            out.println(sb);
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
