package Arrays.Combinations;


import java.util.*;
import java.lang.*;
import java.io.*;

/*Example:
Input:
1
3
2 3 4

Output:
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi */

class PhoneNumbers{
    static BufferedReader br;
    static StringTokenizer st;

    static void printCombinations(int arr[], List<List<Character>> list,char combo[], int size, int number ) {

        if(number == size) {
            for(int i=0; i < size; i++) {
                System.out.print(combo[i]);
            }
            System.out.print(" ");
            return;
        }
        List<Character> currChars = list.get(arr[number]);

        for(int i=0; i < currChars.size(); i++) {
            combo[number] = currChars.get(i);
            printCombinations(arr, list, combo, size, number+1);
            if(arr[number] == 0 || arr[number] == 1) {
                return;
            }
        }

    }
    public static void main (String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int T = Integer.parseInt(next());
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0 ; i < T;i++) {
            int size = Integer.parseInt(next());
            int arr[] = new int[size];
            for(int j =0 ; j < size; j++) {
                arr[j]=Integer.parseInt(next());
            }
            char combo[] = new char[size];
            List<List<Character>> list = Arrays.asList(
                    Arrays.asList(),
                    Arrays.asList(),
                    Arrays.asList('a', 'b', 'c'),
                    Arrays.asList('d', 'e', 'f'),
                    Arrays.asList('g', 'h', 'i'),
                    Arrays.asList('j', 'k', 'l'),
                    Arrays.asList('m', 'n', 'o'),
                    Arrays.asList('p', 'q', 'r', 's'),
                    Arrays.asList('t', 'u', 'v'),
                    Arrays.asList('w', 'x', 'y', 'z')
            );

            printCombinations(arr, list, combo, size, 0);
            System.out.println();

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
