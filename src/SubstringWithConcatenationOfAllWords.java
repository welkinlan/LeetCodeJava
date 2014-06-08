/**
 * Created by tianlan on 6/3/2014.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (S == null || L == null || S.length() == 0 || L.length == 0)
            return result;
        int n = S.length(), m = L.length, l = L[0].length();
        // Use a HashMap for word counting in L
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            if (expected.containsKey(L[i]))     // Duplicate string
                expected.put(L[i], expected.get(L[i])+1);
            else        // New string
                expected.put(L[i], 1);
        }
        // For each i, we work on S[i..i+l-1], S[i+l..i+2l-1], ...
        for (int i = 0; i < l; i++) {
            HashMap<String, Integer> actual = new HashMap<String, Integer>();
            int count = 0;          // The number of consecutive matches
            int windowLeft = i;     // The index of the left of the sliding window
            // For each j, we work on S[j..j+l-1]
            for (int j = i; j <= n-l; j += l) {
                String current = S.substring(j, j+l);   // S[j..j+1-1]
                if (expected.containsKey(current)) {    // A valid string in L
                    // Update the word counting and the number of matches within the window
                    count++;
                    if (actual.containsKey(current))
                        actual.put(current, actual.get(current)+1);
                    else
                        actual.put(current, 1);
                    // If there is more appearance of "current" than expected
                    if (actual.get(current) > expected.get(current)) {
                        // Take out all words before its first appearance (inclusive)
                        // within the window
                        String temp;
                        do {
                            temp = S.substring(windowLeft, windowLeft+l);
                            actual.put(temp, actual.get(temp)-1);
                            count--;
                            windowLeft += l;
                        } while (!temp.equals(current));
                    }
                    // Each word appears exactly once within the window;
                    // a substring that meets the requirements has been found
                    if (count == m) {
                        result.add(windowLeft);
                        // Take out the first word within the window
                        String temp = S.substring(windowLeft, windowLeft+l);
                        actual.put(temp, actual.get(temp) - 1);
                        count--;
                        windowLeft += l;
                    }
                } else {        // An invalid string in L
                    // Start a new window at j+l
                    actual.clear();
                    count = 0;
                    windowLeft = j + l;
                }
            }
        }

        return result;
    }
}