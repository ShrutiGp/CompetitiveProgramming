package Amazon;

public class KsmalletsUsingQuickSort {

    static int partition(int a[], int low, int high) {

        int pivot = a[high];
        int index = low-1; //correct index of next smallest element in the array. Find this and put the desired element here
        for(int j = low; j< high; j++) {
            if(a[j] <= pivot) {
                index++;
                int temp = a[index];
                a[index] = a[j];
                a[j] = temp;
            }
        }
        System.out.println("partition values " + pivot + " " + a[index + 1]);
        int temp = a[high];
        a[high] = a[index + 1];
        a[index + 1] = temp;
        return index+1;
    }

    static int quickSortAndFind(int a[], int low, int high, int k) {

        if(low < high) {
            int j = partition(a, low, high);
            if(j == k) {
                System.out.println("Found the smallest elem partition : " + j +"  :  " + a[j]);
                return a[j];
            }

            if(k<j) {
                return quickSortAndFind(a, low, j-1, k);
            } else {
                return quickSortAndFind(a, j+1, high, k);
            }
        }

        if(low == high && low == k)
            return a[low];
        return -1;
    }

    public static void main(String... s) {
        int arr[] = {9,4,5,2,3,19,10};
        int k = 3; //second smallest elem
        int elem = quickSortAndFind(arr, 0, arr.length - 1, (k-1));
        System.out.println("FOUND " + elem);
    }
}
