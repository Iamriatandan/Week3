package stringbuilder.stringreverse;
import java.util.Scanner;
public class StringReverse {
    public static void main(String[] args) {

        //Creating Scanner class object
        Scanner sc = new Scanner(System.in);

        //Enter string
        System.out.println("Enter String to reverse");
        String str = sc.nextLine();

        String result = reverse(str);

        //comparing results
        System.out.println("Original String : " + str);
        System.out.println("Reverse String : " + result);

    }

    //method to reverse string
    public static String reverse(String str){
        // String builder object
        StringBuilder sb = new StringBuilder();

        //append string to string builder

        sb.append("Hello");

        //using inbuilt reverse method
        sb.reverse();

        return sb.toString();
    }

}
