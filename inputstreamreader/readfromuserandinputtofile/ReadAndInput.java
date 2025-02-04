package inputstreamreader.readfromuserandinputtofile;

import java.io.*;

public class ReadAndInput {
    public static void main(String[] args) {

        String filepath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week3\\Day4\\src\\inputstreamreader\\readfromuserandinputtofile\\output.txt";

        readAndInput(filepath);

    }

    //method to read from console and write to file
    public static void readAndInput(String filepath){
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Enter text to write in the file.(Write stop to stop)" );
            String text;

            while((!(text = br.readLine()).equalsIgnoreCase("stop"))){
                bw.write(text);
                bw.newLine();
                bw.flush();//immediately writes the data
            }
            System.out.println("Text saved to : " + filepath);
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }
}
