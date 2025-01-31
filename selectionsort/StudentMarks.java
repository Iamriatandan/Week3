package selectionsort;
import java.util.*;
public class StudentMarks {
    public static void main(String[] args) {
        int []marks ={12,55,87,45,66,9};
        selectionSort(marks);
        for(int mark:marks){
            System.out.print(mark + " ");
        }
    }

    //method by selection sort
    public static void selectionSort(int []marks){

        for(int i =0;i<marks.length -1;i++){
            int lowest =i;//starting at index 0
            for(int j =i+1;j<marks.length;j++){
             if(marks[lowest]>marks[j]){
                 lowest = j;//update lowest with j
                }
            }
            int temp = marks[lowest];//swapping
            marks[lowest] = marks[i];
            marks[i] = temp;
        }
    }
}
