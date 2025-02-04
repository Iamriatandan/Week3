package stringbuffer.concatenate;
import java.util.Scanner;
import  java.util.Arrays;
public class Concatenate {
    public static void main(String[] args) {

        //Creating Scanner class object
        Scanner sc = new Scanner(System.in);

        //enter words in string array
        String [] words = new String[6];
        for(int i =0;i< words.length;i++){
            System.out.print("Enter word : " );
            words[i] = sc.nextLine();
        }

        String result = concatenate(words);

        //printing result
        System.out.println("Elements of String array : " );
        for ( String i  :words){
            System.out.println(i + " ");
        }

        System.out.println(" After concatenation : " + result);
    }
    //Method to concatenate Arrays elements into string
    public static String concatenate( String [] words){

        //creating string buffer object
        StringBuffer sb = new StringBuffer();

        //looping through words in array
        for(int i =0;i< words.length;i++){
            sb.append(words[i]);
        }

        return sb.toString();
    }

}
