package heapsort;
import java.util.*;
public class Salary {
    public static void main(String[] args) {
        double[] salaries = {50000, 75000, 60000, 90000, 45000, 80000};
        heapSort(salaries);
        // display sorted salaries
        System.out.println("Sorted salary demands: " + Arrays.toString(salaries));
    }
    //method to do heap sort
    public static void heapSort(double[] arr) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);  // Move root to end
            heapify(arr, i, 0); // Reheapify reduced heap
        }
    }

    // Heapify function
    public static void heapify(double[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // Swap function
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
