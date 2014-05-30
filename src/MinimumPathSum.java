/**
 * Created by tianlan on 5/29/2014.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int min[][] = new int[m][n];
        //init
        min[0][0] = grid[0][0];
        for (int r=1; r<m; r++) min[r][0] = min[r-1][0] + grid[r][0];
        for (int c=1; c<n; c++) min[0][c] = min[0][c-1] + grid[0][c];
        //DP
        for (int row=1; row<m; row++){
            for (int col=1; col<n; col++){
                min[row][col] = grid[row][col] + Math.min(min[row-1][col],min[row][col-1]);
            }
        }
        return min[m-1][n-1];
    }

    public static void main(String[] args){
        int grid[][] = {{1,2,3,4},{4,1,2,3},{4,2,1,3},{3,4,2,1}};
        System.out.print(minPathSum(grid));
    }
}
