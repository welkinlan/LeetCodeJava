import java.util.ArrayList;
import java.util.List;

/**
 * Created by tian on 2/19/2015.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        ArrayList<Integer> al1 = s2a(version1);
        ArrayList<Integer> al2 = s2a(version2);
        int l = Math.min(al1.size(), al2.size());
        for(int i=0; i<l; i++) {
            if(al1.get(i)>al2.get(i)) return 1;
            else if(al1.get(i)<al2.get(i)) return -1;
        }
        if(al1.size()>al2.size() && !all0(al1.subList(l, al1.size()))) return 1;
        else if(al1.size()<al2.size() && !all0(al2.subList(l, al2.size()))) return -1;
        else return 0;
    }

    static private ArrayList<Integer> s2a(String version) {
        ArrayList<Integer> retval = new ArrayList<Integer>();
        for(String s : version.split("\\.")) {
            retval.add(Integer.valueOf(s));
        }
        //if no "."
        if (retval.size()==0){
            retval.add(Integer.valueOf(version));
        }
        return retval;
    }

    static boolean all0(List<Integer> al){
        for (int n: al){
            if (n!=0) return false;
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(compareVersion("1","1.0"));
    }
}
