package linearsearch.firstnegativenumber;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int [] numbers = {1,3,4,5,-1,-3,4,8};

       int index =  firstNegativeNumber(numbers);
        System.out.println("The first negative number in the array is at index : " + index);
    }

    //method to find first negative number
    public static int firstNegativeNumber(int[] numbers){
        for(int i =0;i<numbers.length;i++){
            if(numbers[i]<0){
                 return i;

            }
        }
        return -1;
    }
}
