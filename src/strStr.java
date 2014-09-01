/**
 * Created by tianlan on 9/1/14.
 */
public class strStr {
    public String strStr(String haystack, String needle) {
        if(haystack==null || needle == null || needle.length()==0)
            return haystack;
        if(needle.length()>haystack.length())
            return null;
        for(int i=0;i<=haystack.length()-needle.length();i++)
        {
            boolean successFlag = true;
            for(int j=0;j<needle.length();j++)
            {
                if(haystack.charAt(i+j)!=needle.charAt(j))
                {
                    successFlag = false;
                    break;
                }
            }
            if(successFlag)
                return haystack.substring(i);
        }
        return null;
    }
}
