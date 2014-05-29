import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tianlan on 5/13/2014.
 */
public class LetterCombinationsOfAPhoneNumber {

    static HashMap<Character, List<Character>> digitChar = null;
    static char[] chars = null;
    static ArrayList<String> result = null;

    public static ArrayList<String> letterCombinations(String digits) {
        result =  new ArrayList<String>();
        if (digits.equals("")){
            result.add("");
            return result;
        }

        digitChar = new HashMap<Character, List<Character>>();
        digitChar.put('2', Arrays.asList('a', 'b', 'c'));
        digitChar.put('3', Arrays.asList('d', 'e', 'f'));
        digitChar.put('4', Arrays.asList('g', 'h', 'i'));
        digitChar.put('5', Arrays.asList('j', 'k', 'l'));
        digitChar.put('6', Arrays.asList('m', 'n', 'o'));
        digitChar.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitChar.put('8', Arrays.asList('t', 'u', 'v'));
        digitChar.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        chars = digits.toCharArray();
        recursiveOutput(0, "");
        result.remove("");
        return result;
    }

    public static void recursiveOutput(int i, String s){
        if (i == chars.length){
            result.add(s);
        }
        else{
            List<Character> options = digitChar.get(chars[i]);
            for (char c : options){
                recursiveOutput(i+1, s+c);
            }
        }
    }

    public static void main(String[] args){
        System.out.print(letterCombinations("345"));
    }

}
