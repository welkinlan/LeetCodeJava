import java.util.LinkedList;

/**
 * Created by tianlan on 5/26/14.
 */
public class LongestValidParenthses {

    public static int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0;
        int max = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push(i);
            }
            else
            {
                if(stack.isEmpty())
                {
                    start = i+1;
                }
                else
                {
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max,i-start+1); //most
                    else
                        max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;

    }

    public static void main(String[] args){
        System.out.print(longestValidParentheses(")(())()"));
    }

}
