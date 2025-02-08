package com.day6.sortingstoreddata;

import java.util.Random;
import java.util.*;

public class SortingStoredData {
    public static void main(String[] args)
    {
        int[] dataset = {1000,10000,1000000};
        for(int n : dataset)
        {
            SortingStoredData.measureSortingTime(n);
        }
    }
    public static void bubbleSort(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {
            boolean flag = false;
            for(int j=0; j<arr.length-i-1;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
                if(!flag)
                    return;
            }
        }

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void quickSort(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, arr.length - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int low = range[0];
            int high = range[1];

            if (low < high) {
                int partitionIndex = partition(arr, low, high);

                if (partitionIndex + 1 < high) {
                    stack.push(new int[]{partitionIndex + 1, high});
                }
                if (low < partitionIndex - 1) {
                    stack.push(new int[]{low, partitionIndex - 1});
                }
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1, j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) i++;
            while (i <= j && arr[j] > pivot) j--;

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void measureSortingTime(int n)
    {
        int[] data = new int[n];
        for(int i=0; i<data.length; i++)
        {
            data[i] = i;
        }
        int[] dataCopy;
        dataCopy = Arrays.copyOf(data,data.length);
        long startTime = System.nanoTime();
        bubbleSort(dataCopy);
        long bubbleTime = System.nanoTime() - startTime;
        System.out.println("Time required by bubble sort is: " + (double)bubbleTime/1000000);

        dataCopy = Arrays.copyOf(data, data.length);
        startTime = System.nanoTime();
        mergeSort(dataCopy, 0, data.length - 1);
        long mergeTime = System.nanoTime() - startTime;
        System.out.println("Time required by merge sort is: " + (double)mergeTime/1000000);

        dataCopy = Arrays.copyOf(data, data.length);
        startTime = System.nanoTime();
        quickSort(dataCopy);
        long quickTime = System.nanoTime() - startTime;
        System.out.println("Time required by quick sort is: " + (double)quickTime/1000000);
        System.out.println();
    }
}
