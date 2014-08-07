import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 8/5/2014.
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> lastRow = null;
        for (int i=0; i<numRows; i++){
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            if (lastRow != null){
                newRow.add(1);
                for (int j=1; j<lastRow.size(); j++){
                    newRow.add(lastRow.get(j-1)+lastRow.get(j));
                }
                newRow.add(1);
            }
            else{
                newRow.add(1);
            }
            lastRow = newRow;
            result.add(newRow);
        }
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> result = generate(3);
        for (int i=0; i<result.size(); i++){
            for (int j=0; j<result.get(i).size(); j++){
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
