import java.util.LinkedList;

/**
 * Created by tianlan on 8/20/2014.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height==null||height.length==0) return 0;
        int max=0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i=0; i<height.length; i++){
            while (!stack.isEmpty() && height[i]<=height[stack.peek()]){
                int index = stack.pop();
                int curArea = stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index]; //the max area before i
                max = Math.max(max,curArea);
            }
            stack.push(i);
        }
        //take care of
        while (!stack.isEmpty()){
            int index = stack.pop();
            int curArea = stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
            max = Math.max(max,curArea);
        }
        return max;
    }

}
