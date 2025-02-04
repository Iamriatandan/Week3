package stringbuffer.comparison;

public class CompareConcatenation {
    public static void main(String[] args) {
        //printing results after comparison
        System.out.println("Time taken is : ");
        comapareStrings();

    }

    //method to compare both strings
    public static void comapareStrings(){
        //time stamps
        long startTime, endTime;
        startTime = System.nanoTime();
        //testing performance
        StringBuilder sb = new StringBuilder("Hello");
        for(int i =0;i<1000000;i++){
            sb.append("Comparison");
        }
        endTime = System.nanoTime();
        System.out.println(" Time is : " + (endTime -startTime) + "ns" );

        // testing stringbuffer performance
        startTime = System.nanoTime();
        StringBuffer st = new StringBuffer("Hello");
        for(int i =0;i<1000000;i++){
            st.append("Comparison");
        }
        endTime = System.nanoTime();
        System.out.println(" Time is : " + (endTime -startTime) + "ns" );

    }
}
