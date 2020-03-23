package Amazon;

public class LIS
{
    /* lis() returns the length of the longest increasing
       subsequence in arr[] of size n */
    static int lis(int arr[],int n)
    {
        int lis[] = new int[n];
        int i,j,max = 0;

        /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ ) {
            System.out.println("Number  " + arr[i]);
            for (j = 0; j < i; j++) {
                System.out.println(j + " :  " + arr[j] + " => " + (arr[i] > arr[j] && lis[i] < lis[j] + 1));
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }
    public static void main(String args[])
    {
//        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
//        int n = arr.length;
//        System.out.println("Length of lis is " + lis( arr, n ) + "\n" );



        Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25),
                new Pair (27, 40), new Pair(50, 60)};

        int n = arr.length;
        int lis[] = new int[n];

        for(int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for(int i = 1; i < n; i++) {
            Pair higher = arr[i];
            for(int j = 0; j < i; j++) {
                Pair lower = arr[j];

                if(lower.b < higher.a && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;

                for(int  i = 0 ; i < n; i++) {
            max = Math.max(lis[i], max);
        }
        System.out.println(max);


        int b[] = {1,4,3,2,6,7};

        int index = b[0];
        int count = 0;
        while (index < b.length-1) {
            System.out.println(" b" + b[index] + " " + index);
            index += b[index];
            count++;
        }
        if(index >= b.length-1)
            count++;
        System.out.println("count " + count);
    }
}