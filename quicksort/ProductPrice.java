package quicksort;
import java.util.*;
public class ProductPrice {
    public static void main(String[] args) {
        double[] prices = {299.99, 99.50, 150.75, 89.99, 450.00, 200.25};
        quickSort(prices, 0, prices.length - 1);

        // display sorted price
        System.out.println("Sorted product prices: " + Arrays.toString(prices));
    }
    // method to quick sortb array
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);  // Sort left part
            quickSort(arr, pivotIndex + 1, high); // Sort right part
        }
    }

    // Partition function
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // Move pivot to correct position
        return i + 1;
    }
    //method to swap
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
