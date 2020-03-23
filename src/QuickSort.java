import java.util.HashSet;
import java.util.Set;

public class QuickSort {

    static int merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int swaps = 0;
        int temp[] = new int[high + 1];
        int k = low;

        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                swaps = swaps + (mid - i + 1);
            }
        }
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= high) {
            temp[k++] = arr[j++];
        }

        for(int l = low; l <= high; l++) {
            arr[l] = temp[l];
        }

        return swaps;
    }

    static int mergeSort(int arr[], int low, int high) {
        int swaps = 0;
        if(low < high) {
            int mid = (low + high) / 2;
            swaps += mergeSort(arr, low, mid);
            swaps += mergeSort(arr, mid + 1, high);

            swaps += merge(arr, low, mid, high);
        }

        return swaps;
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int smallest = low - 1;
        for(int i = low ; i < high; i++) {
            if(arr[i] < pivot) {
                smallest++;
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }
        }

        int temp = arr[smallest + 1];
        arr[smallest + 1] = pivot;
        arr[high] = temp;

        return smallest + 1;
    }
    static void quickSort(int arr[], int low, int high, int k) {
        if(low < high) {
            int j = partition(arr, low, high);
            if(j == k) {
                System.out.println("kth smallest element : " + arr[j]);
            }

            quickSort(arr, low, j - 1, k );
            quickSort(arr, j + 1, high, k);
        }
    }

    static void removeDuplicatesFromSortedArray() {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};

        int lastNumber = arr[0];
        int index = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != lastNumber) {
                index++;
                lastNumber = arr[i];
                arr[index] = arr[i];
            }
        }

        for(int l = 0; l <= index; l++) {
            System.out.println("index elem : " + arr[l]);
        }
        System.out.println("Index of elems : " + index);
    }

    public static void main(String[] args) {

        int arr[] = {1,5,2,3,10,7,8,4};
        int k = 5;
      //  quickSort(arr, 0 , arr.length - 1, k - 1);
        mergeSort(arr, 0 , arr.length - 1);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(" : " + arr[i]);
        }

        int a[] = {1,2,1,3,4,5,6,7,2,5,6,7};

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < a.length; i++) {
            boolean added = set.add(a[i]);
            if(!added) {
                System.out.println("Duplicate : " + a[i]);
            }
        }

        //first repeating element
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < a.length; i++) {
            if(!hs.add(a[i])) {
                System.out.println("first repeating element" + a[i]);
                break;
            }
        }

        int a1[] = {1,2,2,3,4,5,5,6};

        for(int i = 0; i < a1.length - 1; i++) {
            if(a1[i] == a1[i+1]) {
                System.out.println("dup " + a[i]);

            }
        }

        removeDuplicatesFromSortedArray();

    }
}
