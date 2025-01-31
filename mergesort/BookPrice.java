package mergesort;
import java.util.*;
public class BookPrice {
    public static void main(String[] args) {
        double[] prices = {399.99, 150.50, 200.75, 89.99, 500.00, 300.25};
        mergeSort(prices ,0, prices.length-1);
        //display prices
            System.out.println("Prices in sorted order : " + Arrays.toString(prices));
    }

    //method to do merge sort the array separately
    public static void mergeSort(double[] prices , int start, int end){
        if (start < end) {
            int mid = start + (end - start) / 2;

            // Recursively sort left and right halves
            mergeSort(prices, start, mid);
            mergeSort(prices, mid + 1, end);

            // Merge the sorted halves
            merge(prices, start, mid, end);
        }
    }
    //method to conquer sorted elements
    public static void merge(double[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end- mid;

        double[] startArr = new double[n1];
        double[] endArr = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            startArr[i] = arr[start + i];
        for (int j = 0; j < n2; j++)
            endArr[j] = arr[mid + 1 + j];

        // Merge the two halves
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (startArr[i] <= endArr[j]) {
                arr[k] = startArr[i];
                i++;
            } else {
                arr[k] = endArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements, if any
        while (i < n1) {
            arr[k] = startArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = endArr[j];
            j++;
            k++;
        }
    }
}
