package Amazon;

public class KthMissingSortedArray {

    public static void main(String... s){
        int a[] = {2,4,7,10};
        int k = 5;
        int sum = 0;
        for(int i = 0; i < a.length-1; i++) {
            int diff = a[i+1] - a[i] - 1;
            System.out.println("Diff " + diff + " " + sum);
            if((sum+diff) >= k) {
                int result =  a[i] + (k-sum);
                System.out.println("Answer " + result);
                break;
            } else {
                sum += diff;
            }

        }
    }
}
