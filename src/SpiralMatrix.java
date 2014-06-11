import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 6/10/2014.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> re = new ArrayList<Integer>();
        int m = matrix.length;
        if (m==0) return re;
        int n = matrix[0].length;
        if (n==0) return re;
        int min_c = 0, min_r = 0, max_c = n-1, max_r = m-1;
        while (true){
            //right
            for (int c=min_c; c<=max_c; c++){
                re.add(matrix[min_r][c]);
            }
            min_r ++;
            if (min_r>max_r) break;
            //down
            for (int r=min_r; r<=max_r; r++){
                re.add(matrix[r][max_c]);
            }
            max_c --;
            if (max_c<min_c) break;
            //left
            for (int c=max_c; c>=min_c; c--){
                re.add(matrix[max_r][c]);
            }
            max_r --;
            if (min_r>max_r) break;
            //up
            for (int r=max_r; r>=min_r; r--){
                re.add(matrix[r][min_c]);
            }
            min_c ++;
            if (max_c<min_c) break;
        }
        return re;
    }
}
