package Sorting;

public class MergeSort {
    static void merge(int a[], int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int temp[] = new int[high+1];
        int k = low;

        while(i <= mid && j <= high) {
            if(a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = a[i++];
        }

        while(j <= high) {
            temp[k++] = a[j++];
        }

        for(int g = low; g<=high; g++) {
            a[g] = temp[g];
        }

    }

    static void mergeSort(int a[], int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    public static void main(String... s) {
        int a[] = {10,2,3,1, 14, 15, 16, 17};
        mergeSort(a, 0, a.length-1);
        for(int i =0 ; i<a.length; i++)
            System.out.print(a[i] + " ");
    }
}


//class MergeSort1 {
//
//    static void merge(int a[], int low, int mid, int high) {
//        int i = low;
//        int j = mid+1;
//        int temp[] = new int[high+1];
//        int k = 0;
//
//        while(i <= mid && j <= high) {
//            if(a[i] <= a[j]) {
//                temp[k++] = a[i++];
//            } else {
//                temp[k++] = a[j++];
//            }
//        }
//
//        while(i <= mid) {
//            temp[k++] = a[i++];
//        }
//
//        while(j <= high) {
//            temp[k++] = a[j++];
//        }
//
//        for(int m = 0 ; m < temp.length; m++) {
//            a[m] = temp[m];
//        }
//
//    }
//
//    static void mergeSort(int a[], int low, int high) {
//        if(low < high) {
//            int mid = (low+high)/2;
//            mergeSort(a, low, mid);
//            mergeSort(a, mid+1, high);
//            merge(a, low, mid, high);
//        }
//    }
//
//    public static void main(String... s) {
//        int a[] = {10,2,3,1};
//
//        mergeSort(a, 0, a.length-1);
//        for(int i =0 ; i<a.length; i++)
//            System.out.print(a[i] + " ");
//    }
//}