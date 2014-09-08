/**
 * Created by tianlan on 9/7/14.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int re=n-1,rs=0,ce=n-1,cs=0;
        int c=1;
        while (cs<ce){
            for (int i=cs; i<=ce; i++){
                res[rs][i] = c;
                c++;
            }
            for (int i=rs+1; i<=re; i++){
                res[i][ce] = c;
                c++;
            }
            for (int i=ce-1; i>=cs; i--){
                res[re][i] = c;
                c++;
            }
            for (int i=re-1; i>=rs+1; i--){
                res[i][cs] = c;
                c++;
            }
            cs++;
            ce--;
            rs++;
            re--;
        }
        //n odd
        if (cs==ce){
            res[rs][cs] = n*n;
        }
        return res;
    }
}
