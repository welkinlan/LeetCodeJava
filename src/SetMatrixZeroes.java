/**
 * Created by tianlan on 8/23/14.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        //clear flag for first row
        boolean rowFlag = false;
        boolean colFlag = false;
        //first row and col act as clear counter for all rows/cols
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
            {
                colFlag = true;
                break;
            }
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[0][i]==0)
            {
                rowFlag = true;
                break;
            }
        }
        //use clear counter for second to last rows/cols
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //set 0 for second to last rows/cols
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        //set 0 for first row/col
        if(colFlag)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
        }
        if(rowFlag)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                matrix[0][i] = 0;
            }
        }
    }
}

