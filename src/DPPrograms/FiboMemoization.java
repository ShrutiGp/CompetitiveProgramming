package DPPrograms;

public class FiboMemoization {

    static final int MAX =100;
    static int arr[] = new int[MAX];
    static int fibo(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(arr[n] != -1)
            return arr[n];

        return arr[n] = fibo(n-1) + fibo(n-2);
    }
    public static void main(String... args) {
        //Initialize the array
        for(int i = 0 ; i < MAX; i++) {
            arr[i] = -1;
        }
        System.out.print(fibo(7));
    }
}
