/**
 * Created by tianlan on 7/14/2014.
 */
public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)
            return 0;
        int idx = s.length()-1;
        while(idx>=0 && s.charAt(idx)==' ') idx--;
        int idx2 = idx;
        while(idx2>=0 && s.charAt(idx2)!=' ') idx2--;
        return idx-idx2;
    }
}
