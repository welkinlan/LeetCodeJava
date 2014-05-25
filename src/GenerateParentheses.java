import java.util.ArrayList;

/**
 * Created by tianlan on 5/25/14.
 */
public class GenerateParentheses {

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        char[] clause = new char[n+n];
        recursiveGeneration(result, 0, 0, n, clause);
        return result;
    }

    public static void recursiveGeneration(ArrayList<String> result, int left, int right, int n, char[] clause){
        if (left == right && left == n) {
            result.add(new String(clause));
            return;
        }

        if (left < n) {
            clause[left + right] = '(';
            recursiveGeneration(result, left + 1, right, n, clause);
        }

        if (right < left) {
            clause[left + right] = ')';
            recursiveGeneration(result, left, right + 1, n, clause);
        }
    }

    public static void main(String[] args){
        System.out.print(generateParenthesis(5));
    }

}
