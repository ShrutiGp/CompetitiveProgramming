package Arrays;
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;

class MaxValueAftermRangeOps
{

    static PrintWriter out = new PrintWriter(System.out);

    static String subArraySum(int a[], int n, int s) {
        int start = 0, curr_sum = a[0], i;
        for(i = 1; i <= n; i++) {
            while(curr_sum > s && start < i -1) {
                curr_sum -= a[start];
                start++;
            }
            if(curr_sum == s) {
                return (start + 1) + " " + i;
            }
            if(i < n) {
                curr_sum += a[i];
            }
        }
        return "-1";
    }

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //reads integer

        while(t-- > 0) {
            String[] l1 = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(l1[0]);
            int s = Integer.parseInt(l1[1]);
            int[] a = new int[n];
            String[] l2 = br.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(l2[i]);
            }
            out.println(subArraySum(a,n,s));
        }
        out.flush();
        out.close();
    }
}