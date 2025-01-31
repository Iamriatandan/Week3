package bubblesort;
import java.util.*;
public class Marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //enter no of students
        System.out.println("Enter total number of students");
        int n = sc.nextInt();
        //enter student marks
        int [] marks = new int [n];
        for(int i =0;i<marks.length;i++){
            System.out.println("Enter marks for " + (i+1));
            marks[i] = sc.nextInt();
        }
bubbleSort(marks);
        //display marks
        for(int mark : marks){
            System.out.println( " marks in sorted fashion are :" + mark);
        }

    }
    //method to sort marks using bubble sort
    public static void bubbleSort(int [] marks){
        boolean swapped = false;
        int x = marks.length;
        for(int i =0;i<x -1 ;i++){// i counter j index
            for(int j =0;j<x-i-1;j++){//according to loop running last element gets sorted
                if(marks[j]>marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
}
