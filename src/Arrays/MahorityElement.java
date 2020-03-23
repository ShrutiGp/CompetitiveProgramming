package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class MahorityElement
{
    static PrintWriter out = new PrintWriter(System.out);

    static int getMajorityElement(int a[], int n) {
       int count = 0, max_count = 0, curr_value = -1;
        Arrays.sort(a);
       for(int i = 0; i < n - 1; i++) {
            if(a[i] == a[i+1]) {
                count++;
            } else {
                count = 0;
            }
            if (max_count < count && count >= n/2) {
                    max_count = count;
                    curr_value = a[i];
            }

        }
        return curr_value;
    }

    public static void main(String[] args)throws IOException
    {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //reads integer

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] l2 = br.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(l2[i]);
            }
            out.println(getMajorityElement(a,n));
        }
        out.flush();
        out.close();
    }
}