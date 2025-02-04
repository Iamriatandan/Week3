package challengeproblem;
import java.io.*;

public class ChallengeProblem {
    public static void main(String[] args) {

        compareStringBuilderVsStringBuffer();

        compareFileReaderVsInputStreamReader("C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week3\\Day4\\src\\challengeproblem\\file.txt"); // Change to your actual file path
    }

    //method to compare time using string builder and string buffer
    private static void compareStringBuilderVsStringBuffer() {

        int iterations = 1000000;

        String text = "hello";

        // Measure time for StringBuilder
        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();

        System.out.println("StringBuilder time: " + (endTime - startTime) / 1000000 + " ms");

        // Measure time for StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();

        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();

        System.out.println("StringBuffer time: " + (endTime - startTime) / 1000000 + " ms");
    }

    //method to compare reading time using file reader and input stream reader
    private static void compareFileReaderVsInputStreamReader(String filePath) {
        try {
            // Measure time for FileReader
            long startTime = System.nanoTime();

            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);

            int wordCountFR = countWords(br);
            fileReader.close();

            long endTime = System.nanoTime();

            System.out.println("FileReader word count: " + wordCountFR);

            System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");

            // Measure time for InputStreamReader
            startTime = System.nanoTime();

            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            br = new BufferedReader(isr);

            int wordCountISR = countWords(br);
            isr.close();

            endTime = System.nanoTime();

            System.out.println("InputStreamReader word count: " + wordCountISR);

            System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;

        String line;

        while ((line = br.readLine()) != null) {

            wordCount += line.split("\\s+").length;
        }
        return wordCount;
    }
}
