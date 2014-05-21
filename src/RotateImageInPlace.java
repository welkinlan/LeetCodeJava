/**
 * Created by tianlan on 5/15/2014.
 */
public class RotateImageInPlace {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int round = 0; round < n/2; round++){
            //the start and end of the new round (circle)
            int start = round;
            int end = n-round-1;
            //the last element for each row/col does not need to be swapped, so "<"
            for (int i = 0; i < end-start; i++){
                //store top row value as temp
                int temp = matrix[start][start+i];
                //leftmost col -> top row
                matrix[start][start+i] = matrix[end-i][start];
                //bottom row -> leftmost col
                matrix[end-i][start] = matrix[end][end-i];
                //rightmost col -> bottom row
                matrix[end][end-i] =  matrix[start+i][end];
                //top row -> rightmost col
                matrix[start+i][end] = temp;
            }
        }
    }

    public static void main(String[] args){
        //int a[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int a[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for (int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                System.out.print(a[i][j]+",");
            }
            System.out.print("\n");
        }
        rotate(a);
        for (int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                System.out.print(a[i][j]+",");
            }
            System.out.print("\n");
        }

    }

}
