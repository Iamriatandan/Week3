package binarysearch.peekpoint;

public class PeekPoint {
    public static void main(String[] args) {
        int [] numbers = {3,5,2,8,0,1,4,2,7};

        int peakElement = peakElement(numbers);
        System.out.println("Peak element is : " + peakElement);
    }

    //method to find peak element
    public static int peakElement(int [] numbers){
        int left =0 , right = numbers.length-1;

        while (left < right) {
            int mid = (right + left) / 2;

            // Boundary condition check (avoid accessing numbers[-1] or numbers[length])
            if (mid > 0 && numbers[mid] < numbers[mid - 1]) {
                right = mid - 1;
            } else if (mid < numbers.length - 1 && numbers[mid] < numbers[mid + 1]) {
                left = mid + 1;
            } else {
                return numbers[mid]; // Found a peak
            }
        }

        return numbers[left]; // Return peak element
    }
}
