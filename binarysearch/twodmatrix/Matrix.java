package binarysearch.twodmatrix;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,4} , {2,5,6},{7,8,9}};
        int target =9;
        boolean found = searchMatrix(matrix,target);
        System.out.println("Target found : " + found);

    }

    //method to search matrix
    public static boolean searchMatrix(int [] [] matrix ,int target){
        int rows = matrix.length;;
        int columns = matrix[0].length;

        int left =0 , right = rows*columns-1;

        while (left<=right){
            int mid = (right+left)/2;

            //convert mid to row and column to indexes
            int row = mid/columns;
            int col = mid% columns;

            if(matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] < target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return false;
    }
}
