import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianlan on 10/3/14.
 */
public class LongestCommonElements {
    public static int longestCommonList(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<String>();
        int [][] array = new int[list1.size()+1][list2.size()+1];
        for (int j=0; j<array[0].length; j++) array[0][j]=0;
        for (int i=0; i<array.length; i++) array[i][0]=0;
        for (int i=1; i<array.length; i++){
            for (int j=1; j<array[0].length; j++){
                if (list1.get(i-1).equals(list2.get(j-1))){
                    array[i][j] = array[i-1][j-1] + 1;
                }
                else{
                    array[i][j] = Math.max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        return array[list1.size()][list2.size()];
    }

    public static void main(String args[]){
        List<String> l1 = Arrays.asList("aa","bb","cc","dd");
        List<String> l2 = Arrays.asList("aa","bb","dd","gg");
        System.out.print(longestCommonList(l1,l2));
    }
}
