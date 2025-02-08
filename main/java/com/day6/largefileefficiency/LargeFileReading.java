package com.day6.largefileefficiency;
import java.io.*;
public class LargeFileReading {

        public static void main(String[] args) {
            String filePath = "C:\\Users\\tanda\\OneDrive\\Documents\\Desktop\\Training\\Week3\\Day6\\src\\main\\java\\com\\day6\\largefileefficiency\\testfile.txt"; // Specify your large file path here

            System.out.printf("%-10s %-20s %-20s\n", "File Size", "FileReader Time (s)", "InputStreamReader Time (s)");
            System.out.println("--------------------------------------------------------------");

            // Measure FileReader performance
            long fileReaderTime = measureTime(() -> readUsingFileReader(filePath));

            // Measure InputStreamReader performance
            long inputStreamReaderTime = measureTime(() -> readUsingInputStreamReader(filePath));

            // Print results
            System.out.printf("%-10s %-20.3f %-20.3f\n", "500MB", fileReaderTime / 1_000_000_000.0, inputStreamReaderTime / 1_000_000_000.0);
        }

        // Method to read file using FileReader (Character Stream)
        public static void readUsingFileReader(String filePath) {
            try (FileReader fileReader = new FileReader(filePath)) {
                while (fileReader.read() != -1) {
                    // Reading character by character
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to read file using InputStreamReader (Byte Stream)
        public static void readUsingInputStreamReader(String filePath) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
                while (inputStreamReader.read() != -1) {
                    // Reading byte by byte and converting to character
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to measure execution time
        public static long measureTime(Runnable method) {
            long startTime = System.nanoTime();
            method.run();
            return System.nanoTime() - startTime;
        }
    }