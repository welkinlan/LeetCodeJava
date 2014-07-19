import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 7/18/14.
 */
public class NQueensII {
    public int totalNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        helper(n,0,new int[n], res);
        return res.size();
    }
    private void helper(int n, int row, int[] columnForRow, List<String[]> res)
    {
        //add result
        if(row == n)
        {
            String[] item = new String[n];
            for(int i=0;i<n;i++)
            {
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(columnForRow[i]==j)
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                item[i] = strRow.toString();
            }
            res.add(item);
            return;
        }
        //consider all possibilities for current row
        for(int i=0;i<n;i++)
        {
            columnForRow[row] = i;
            if(check(row,columnForRow))
            {
                helper(n,row+1,columnForRow,res);
            }
        }
    }
    private boolean check(int row, int[] columnForRow)
    {
        for(int i=0;i<row;i++)
        {
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
                return false;
        }
        return true;
    }
}
