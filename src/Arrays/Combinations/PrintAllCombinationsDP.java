package Arrays.Combinations;


// Java program to print all combination of size r in an array of size n
import java.io.*;

class PrintAllCombinationsDP {

    /*
    currPos -  current position in array arr (used to check if we are not at the end of array
    dataIndex - index in data array of size r
    */
    static void printCombinations(int arr[], int n, int r, int data[], int currPos, int dataIndex) {

        if(dataIndex == r) {
            //we have got our combination here to print
            for(int i = 0; i < r; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }

        if(currPos >= n)
            return;

        data[dataIndex] = arr[currPos];
        // case 1: when we have to include element from arr and increment the index of data
        printCombinations(arr, n, r, data, currPos+1, dataIndex+1);

        // case 2: when we have to exclude element from arr, index of data remains same.. only arr index increases
        printCombinations(arr, n, r, data, currPos+1, dataIndex);

    }

    public static void main(String...args) {
        int arr[] = {1,2,3,4,5};
        int r = 3;
        int n = arr.length;
        int data[] = new int[r];
        printCombinations(arr, n, r, data, 0, 0);
    }
}
