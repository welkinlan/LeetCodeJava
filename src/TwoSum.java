import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tianlan on 5/13/2014.
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length != 0){
            //int and position
            HashMap<Integer, ArrayList<Integer>> smallHM = new HashMap<Integer, ArrayList<Integer>>();
            HashMap<Integer, ArrayList<Integer>> largeHM = new HashMap<Integer, ArrayList<Integer>>();
            for (int i=0; i<numbers.length; i++){
                if (numbers[i] <= target/2) {
                    if (!smallHM.containsKey(numbers[i])){
                        smallHM.put(numbers[i], new ArrayList<Integer>(Arrays.asList(i+1)));
                    }
                    else{
                        //System.out.print(smallHM.get(numbers[i]));
                        smallHM.get(numbers[i]).add(i+1);
                    }
                }
                else if (numbers[i] > target/2 ){
                    if (!largeHM.containsKey(numbers[i])){
                        largeHM.put(numbers[i], new ArrayList<Integer>(Arrays.asList(i+1)));
                    }
                    else{
                        //System.out.print(largeHM.get(numbers[i]));
                        largeHM.get(numbers[i]).add(i+1);
                    }
                }
            }
            //1. solution in one partition
            //1.1 target = 0 and two 0s
            if (target == 0){
                if (smallHM.containsKey(0) && smallHM.get(0).size()>1) {
                    return new int[]{smallHM.get(0).get(0), smallHM.get(0).get(1)};
                }
            }
            //1.2 two target/2 numbers
            if (smallHM.containsKey(target/2) && smallHM.get(target/2).size()>1) {
                return new int[]{Math.min(smallHM.get(target/2).get(0),smallHM.get(target/2).get(1)),
                                 Math.max(smallHM.get(target/2).get(0),smallHM.get(target/2).get(1))};
            }
            //2. solution in two partition
            for (int si : smallHM.keySet()){
                for (int li : largeHM.keySet()){
                    //System.out.println(si+","+li);
                    if ((si+li) == target){
                        return new int[]{Math.min(smallHM.get(si).get(0),largeHM.get(li).get(0)),
                                         Math.max(smallHM.get(si).get(0),largeHM.get(li).get(0))};
                    }
                }
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args){
        int numbers[] = new int[]{-3,4,3,90};
        int target = 0;
        int result[] = twoSum(numbers,target);
        System.out.print(result[0] +","+result[1]);
    }
}
