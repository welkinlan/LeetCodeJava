import java.util.HashMap;

/**
 * Created by tianlan on 4/29/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        int lLength = 0;

        if (s == null || s.equals("") || s.length() == 0) {
            return 0;
        }

        int sLength = s.length();
        int counter = 0;
        int i = 0;
        while (i < sLength) {
            //System.out.println(i);
            char ch = s.charAt(i);
            if (chars.containsKey(ch)) {
                lLength = Math.max(counter, lLength);
                //System.out.print(lLength);
                int j = chars.get(ch);
                chars.clear();
                i = j+1;
                System.out.println(s.charAt(i));
                counter = 0;
            } else {
                chars.put(ch, i);
                counter++;
                i ++;
            }

        }
        // updating max length
        lLength = Math.max(counter, lLength);
        return lLength;
    }
    */
    static int lengthOfLongestSubstring(String s) {
        int arr[] = new int[256];
        int k = s.length();
        int start = 0, count = 0, max = 0, i;
        for (i = 0; i < s.length(); i++) {
            if (arr[(int)s.charAt(i)]!=0 && arr[(int)s.charAt(i)] >= start) {
                start = arr[(int)s.charAt(i)];
                count = i - start + 1;
                arr[(int)s.charAt(i)] = i + 1;
            } else {
                arr[(int)s.charAt(i)] = i + 1;
                ++count;
            }
            if (count > max)
                max = count;

        }
        return max;
    }

    public static void main(String[] args) {
        String a = "abcdegfesdfg";
        System.out.print(lengthOfLongestSubstring(a));

    }
}
