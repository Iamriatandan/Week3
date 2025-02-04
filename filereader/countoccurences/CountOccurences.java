package filereader.countoccurences;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CountOccurences {
    public static void main(String[] args) {

        //declaring file path
        String filepath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week3\\Day4\\src\\filereader\\countoccurences\\file.txt";

        //word to search
        String word = "the";
        int result = occurence(filepath, word);
        System.out.println("occurences of the word : " + result);
    }

    //method to calculate occurences of a word
    public static int occurence(String file , String word){
        int count =0;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine())!= null){
                String[] words = line.split("\\s+");
                for (String i : words) {
                    if(i.equalsIgnoreCase(word)){
                        count++;
                    }
                }
            }
        }

        catch(IOException e){
            System.out.println("Cannot read line." + e.getMessage());
        }
        return count;
    }
}
