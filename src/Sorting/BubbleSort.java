package Sorting;

public class BubbleSort {

    public static void main(String... args) {

        int a[] = {2,5,6,7,1,3,2,7};
        int temp = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j=0; j<a.length-i-1; j++) {
                if(a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
