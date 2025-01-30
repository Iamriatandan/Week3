package stacksandqueues.circulartour;

public class CircularTour {
    // Function to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0; // Tracks total fuel balance
        int currentSurplus = 0; // Tracks fuel balance while iterating
        int startIndex = 0; // Stores the possible starting pump index

        for (int i = 0; i < petrol.length; i++) {
            int netFuel = petrol[i] - distance[i]; // Petrol gain/loss at pump i
            totalSurplus += netFuel;
            currentSurplus += netFuel;

            // If fuel balance goes negative, reset startIndex
            if (currentSurplus < 0) {
                startIndex = i + 1; // Move to next pump as potential start
                currentSurplus = 0; // Reset current surplus
            }
        }

        // If total surplus fuel is negative, no tour is possible
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("Circular tour is not possible.");
        }
    }
}
