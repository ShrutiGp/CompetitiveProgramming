package Amazon;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Scanner;
        import java.util.StringTokenizer;


public class MergeWithoutExtraSpace {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(br.readLine());
        String output[] = new String[numberOfTests];
        for(int i = 0 ; i <  numberOfTests; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size1 = Integer.parseInt(st.nextToken());
            int size2 = Integer.parseInt(st.nextToken());

            StringTokenizer arrayElements = new StringTokenizer(br.readLine());
            int a1[] = new int[size1];
            int index = 0;
            while (index < size1 && arrayElements.hasMoreTokens()) {
                a1[index] = Integer.parseInt(arrayElements.nextToken());
                index++;
            }
            StringTokenizer arrayElements2 = new StringTokenizer(br.readLine());
            int a2[] = new int[size2];
            int index1 = 0;
            while (index1 < size2 && arrayElements2.hasMoreTokens()) {
                a2[index1] = Integer.parseInt(arrayElements2.nextToken());
                index1++;
            }

            for (int j = size2 - 1; j >= 0; j--) {
                int temp = a2[j];
                if (temp < a1[size1 - 1]) {
                    a2[j] = a1[size1 - 1];
                    int index2 = size1 - 2;
                    while (index2 > -1 && temp < a1[index2]) {
                        a1[index2 + 1] = a1[index2];
                        index2--;
                    }
                    if ((index2 + 1) > -1) {
                        a1[index2 + 1] = temp;
                    }
                }
            }

            String str = a1[0] + " ";
            for (int m = 1; m < size1; m++) {
                str += (a1[m] + " ");
            }
            for (int m = 0; m < size2; m++) {
                str += (a2[m] + " ");
            }
            output[i] = str;
        }

        for( int i =0 ; i < numberOfTests; i++) {
            System.out.println(output[i]);
        }
    }
}
