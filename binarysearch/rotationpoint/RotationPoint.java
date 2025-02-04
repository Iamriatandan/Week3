package binarysearch.rotationpoint;

public class RotationPoint {
    public static void main(String[] args) {
        int [] arr = {1,2,4,5,6,7,8};

        int rotationIndex = rotationPoint(arr);
        System.out.println("The rotation index is : " + rotationIndex);
    }

    //method to find rotation point i.e. smallest element in array
    public static int rotationPoint(int [] arr ){
        int left =0 , right = arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]>arr[right]){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
