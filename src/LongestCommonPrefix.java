/**
 * Created by tianlan on 9/7/14.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0) return "";
        StringBuilder sb = new StringBuilder();
        int lowBound = strs[0].length();
        for (int i=1; i<strs.length; i++){
            if (lowBound > strs[i].length()){
                lowBound = strs[i].length();
            }
        }
        int cur = 0;
        while (cur<lowBound){
            char c = strs[0].charAt(cur);
            int i;
            for (i=1; i<strs.length && strs[i].charAt(cur)==c; i++);
            if (i==strs.length) {
                cur++;
                sb.append(c);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}
