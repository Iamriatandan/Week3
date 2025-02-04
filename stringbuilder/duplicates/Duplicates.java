package stringbuilder.duplicates;
import java.util.Scanner;
import java.util.HashSet;

public class Duplicates {
    public static void main(String[] args) {
        //creating Scanner class object
        Scanner sc  = new Scanner(System.in);

        //Enter the string
        System.out.println("Enter String");
        String str = sc.nextLine();

        String result = removeDuplicates(str);

        //comparing the results
        System.out.println("Original String : " + str);
        System.out.println("After Removing duplicates : " +  result);
    }

    //creating method to remove duplicates
    public static String removeDuplicates(String str){

        //creating string builder object
        StringBuilder sb = new StringBuilder();

        //creating hashset
        HashSet<Character> check = new HashSet<>();

        //loop to check if character is already present in hashset or not
        for( char ch : str.toCharArray()){
            if(!check.contains(ch)){
                sb.append(ch);
                check.add(ch);
            }
        }
        return sb.toString();

    }
}
