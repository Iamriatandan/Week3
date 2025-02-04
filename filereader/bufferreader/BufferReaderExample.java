package filereader.bufferreader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferReaderExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week3\\Day4\\src\\filereader\\bufferreader\\example.txt";

        System.out.println("Manual choosing reading");
        readFile(filePath);
    }

    //method to input file and read it
    public static void readFile(String example) {
        try{
            FileReader fr = new FileReader(example);
            BufferedReader br = new BufferedReader(fr);

            String line ;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error  reading file. " + e.getMessage());
        }
    }
}