
package Amazon;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;


public class Parenthesis {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(br.readLine());
        String output[] = new String[numberOfTests];
        for(int i = 0 ; i <  numberOfTests; i++) {

            StringTokenizer arrayElements = new StringTokenizer(br.readLine());
            List<String> ls = new ArrayList<>();
            while(arrayElements.hasMoreTokens()) {
                ls.add(arrayElements.nextToken());
            }
            String st[] = ls.toArray(new String[0]);
            int length = st.length;

        }

        for( int i =0 ; i < numberOfTests; i++) {
            System.out.println(output[i]);
        }
    }
}
