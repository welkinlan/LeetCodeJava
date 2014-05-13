import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tianlan on 5/13/2014.
 */
public class ZigZagConversion {

    public static String convert(String s, int nRows) {
        HashMap<Integer, ArrayList<Character>> rowEntry = getRowEntry(s,nRows);
        String ss = "";
        for (int i=0; i<nRows; i++){
            for (char c : rowEntry.get(i)){
                ss += c;
            }
        }
        return ss;
    }

    public static HashMap<Integer, ArrayList<Character>> getRowEntry(String s, int nRows){
        int i = 0;
        boolean zig = true;
        HashMap<Integer, ArrayList<Character>> rowEntry = new HashMap<Integer, ArrayList<Character>>();
        for (int a=0; a<nRows; a++){ rowEntry.put(a,new ArrayList<Character>()); }
        while (i<s.length()){
            //zig
            if (zig){
                for (int a=0; a<nRows; a++){
                    try {
                        rowEntry.get(a).add(s.charAt(i));
                        ++i;
                    }
                    catch (Exception e){
                        return rowEntry;
                    }
                }
                //System.out.println(rowEntry);
                zig = false;
            }
            //zag
            else{
                for (int a=0; a<nRows-2; a++){
                    try {
                        rowEntry.get(nRows-2-a).add(s.charAt(i));
                        ++i;
                    }
                    catch (Exception e){
                        return rowEntry;
                    }
                }
                //System.out.println(rowEntry);
                zig = true;
            }
        }
        return rowEntry;
    }

    public static void main(String[] args){
        System.out.print(convert("PAYPALISHIRING", 4));
    }

}
