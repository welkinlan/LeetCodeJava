/**
 * Created by tianlan on 5/15/2014.
 */
public class RotateImageInPlace {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int round = 0; round < n/2; round++){
            int start = round;
            int end = n-round-1; //the last element for each row/col does not need to be swapped
            for (int i = start; i < end; i++){
                int temp = matrix[i][end];
                //top row to rightmost col
                matrix[i][end];
            }
        }

    }

    public static void main(String[] args){

    }

}
