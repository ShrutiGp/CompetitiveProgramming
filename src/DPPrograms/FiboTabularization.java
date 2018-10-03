package DPPrograms;

public class FiboTabularization {

    static int a[] = new int[100];
    public static void main(String... args) {
        a[0] = 0;
        a[1] = 1;
        int n = 6;
        for(int i = 2; i<=n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        System.out.print(a[n]);
    }
}
