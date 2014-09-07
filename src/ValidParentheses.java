import java.util.LinkedList;

/**
 * Created by tianlan on 9/6/14.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s==null || s.length()==0) return false;
        LinkedList<Character> existing = new LinkedList<Character>();
        for (int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '{':
                case '[':
                case '(':
                    existing.push(s.charAt(i));
                    break;
                case ')':
                    if (!existing.isEmpty() && existing.peek()=='(') existing.pop();
                    else return false;
                    break;
                case ']':
                    if (!existing.isEmpty() && existing.peek()=='[') existing.pop();
                    else return false;
                    break;
                case '}':
                    if (!existing.isEmpty() && existing.peek()=='{') existing.pop();
                    else return false;
                    break;
                default:return false;
            }
        }
        if (existing.isEmpty()) return true;
        return false;
    }
}
