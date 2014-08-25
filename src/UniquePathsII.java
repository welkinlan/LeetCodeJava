/**
 * Created by tianlan on 8/24/14.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        //int min = Math.min(obstacleGrid.length,obstacleGrid[0].length);
        //int max = Math.max(obstacleGrid.length,obstacleGrid[0].length);
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int array[] = new int[n];
        array[0] = 1;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (obstacleGrid[i][j]==1) array[j]=0;
                else{
                    if (j>0){
                        array[j] += array[j-1];
                    }
                }
            }
        }
        return array[n-1];
    }
}
