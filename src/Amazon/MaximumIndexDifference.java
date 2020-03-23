
package Amazon;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;
        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.StringTokenizer;
        import java.util.stream.Collector;
        import java.util.stream.Collectors;

public class MaximumIndexDifference {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(br.readLine());
        String output[] = new String[numberOfTests];
        for(int i = 0 ; i <  numberOfTests; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
           // int sum = Integer.parseInt(st.nextToken());

            StringTokenizer arrayElements = new StringTokenizer(br.readLine());
            int array[] = new int[2*size + 2];
            String str = new String();
            int index = 0;
            HashSet<Integer> hashSet = new HashSet<>();
            while( arrayElements.hasMoreTokens()) {
                int value =Integer.parseInt(arrayElements.nextToken());
                array[index]= value;
                index++;
            }
            Arrays.sort(array);
            List<String> ls = new ArrayList<>();
            for(int num : array) {
                boolean added = hashSet.add(num);
                System.out.println("num " + num + "  : " + added);
                if(added) {
                    ls.add(String.valueOf(num));
                } else  {
                    hashSet.remove(num);
                    ls.remove(String.valueOf(num));
                }
                System.out.println("check " + ls.toString());
            }
           output[i] = String.join(" ", ls);
        }

        for( int i =0 ; i < numberOfTests; i++) {
            System.out.println(output[i]);
        }
    }
}
