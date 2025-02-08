package com.day6.searchatarget;
import java.util.*;
public class SearchATarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //array to be worked on based on sizes
        int[] sizes = {1000, 10000, 1000000};

        System.out.printf("%-15s %-15s %-15s\n", "Dataset Size", "Linear Search (ns)", "Binary Search (ns)");
        System.out.println("------------------------------------------------------");

        //enter target to search
        System.out.println("Enter target to search ");
        int target = sc.nextInt();

        //looping through sizes array to run the loop for each dataset size
        for(int size : sizes){
            int [] dataset = new int [size]; //new array to be worked internally
            for(int i =0;i<size;i++){
                dataset[i] = i ;//filling values in new array
            }

            //searching linear search time
            long linearSearchTime = searchTime(() -> linearSearch(dataset,target));

            //searching binary search time
            long binarySearchTime = searchTime(() -> binarySearch(dataset,target));

            // Print results
            System.out.printf("%-15d %-15d %-15d\n", size, linearSearchTime, binarySearchTime);

        }

        sc.close();
    }

    //method to search element using linear search
    public static int linearSearch(int []dataset , int target){
        for(int i =0;i<dataset.length;i++){
            if(dataset[i] == target){
                return dataset[i];
            }
        }
        return -1; // if not found
    }

    //method to search element using binary search
    public static int binarySearch(int[]dataset,int target){
        int left =0 , right = dataset.length -1 ;

        while (left<=right){
            //finding middle index
            int mid = left + (right - left)/2;
            if(dataset[mid] == target){
                return mid;
            }

            //search in left half
            else if (dataset[mid]<target) {
                left = mid+1;
            }

            else {
                right = mid-1;
            }
        }
        return -1;
    }

    //method to return the searching time
    public static long searchTime(Runnable searchMethod){
        long start = System.nanoTime();
        searchMethod.run();
        return System.nanoTime() - start;
    }

}
