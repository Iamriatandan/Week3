package insertionsort;
import java.util.*;
public class EmployeeId {
    public static void main(String[] args) {
        //employee ids
        int [] id = {121,666,831,231,932,111};
        insertionSort(id);
        for (int i:id) {
            System.out.print(i + " ");
        }
    }

    //sort employee ids by insertion sort
    public static void insertionSort(int[]id){
        for(int i =1;i< id.length;i++){ //1 because 0 is considered on sorted part
            int current = id[i];
            int j =i-1;
            while(j>=0&& current<id[j]){
                id[j+1] = id[j];
                j--;
            }
            //placement
            id[j+1] = current;
        }
    }
}
