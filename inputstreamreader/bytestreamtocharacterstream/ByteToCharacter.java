package inputstreamreader.bytestreamtocharacterstream;
import java.io.*;

public class ByteToCharacter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week3\\Day4\\src\\inputstreamreader\\bytestreamtocharacterstream\\file.txt";
        System.out.println("Converting Byte to character stream");
        convertByteToStream(filePath);
    }

    //method to convert byte stream to character stream
    public static void convertByteToStream(String file){
        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line ;
            while(((line = br.readLine())!= null)){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
