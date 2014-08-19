import java.util.*;

/**
 * Created by tianlan on 7/16/2014.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s==null || s.length()==0 || s.length()>12) return res;
        helper(s,0,1,"",res);
        return res;
    }
    //index-current index
    //segment-level
    //item-all strs so far
    private void helper(String s, int index, int segment, String item, List<String> res){
        if(index>=s.length())
            return;
        if(segment == 4)
        {
            String str = s.substring(index); //from index(inclusive) to end
            if(isValid(str))
            {
                res.add(item+"."+str);
            }
            return;
        }
        for(int i=1;i<4&&(i+index<=s.length());i++)
        {
            String str = s.substring(index, index+i);
            if(isValid(str))
            {
                if(segment==1)
                    helper(s,index+i,segment+1,str,res);
                else
                    helper(s,index+i,segment+1,item+"."+str,res);
            }
        }

    }

    private boolean isValid(String str){
        if(str==null || str.length()>3)
            return false;
        int num = Integer.parseInt(str);
        if(str.charAt(0)=='0' && str.length()>1)
            return false;
        if(num>=0 && num<=255)
            return true;
        return false;
    }
}
