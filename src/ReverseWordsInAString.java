/**
 * Created by tianlan on 6/11/2014.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        return helper(s,0).toString();
    }
    private StringBuilder helper(String s, int index)
    {
        //if end, add empty string
        if(index>=s.length())
            return new StringBuilder();
        StringBuilder cur = new StringBuilder();
        int lastIndex = index;
        while(index < s.length() && s.charAt(index)!=' ')
        {
            cur.append(s.charAt(index++));
        }
        while(index < s.length() && s.charAt(index)==' ')
            index++;
        //if it is the first word, it will be put in the end. We do not need the ' '
        if(lastIndex == 0)
            return helper(s,index).append(cur);
        //else we need to append a ' ' after this word
        return helper(s,index).append(cur).append(' ');
    }


}
