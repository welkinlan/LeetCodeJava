/**
 * Created by tianlan on 5/31/14.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        if (b=="") return a;
        if (a=="") return b;
        char ac[] = a.toCharArray();
        char bc[] = b.toCharArray();
        int la = ac.length;
        int lb = bc.length;
        char largerArray[] = la>lb?ac:bc;
        int largerLength = largerArray.length;
        StringBuilder res = new StringBuilder();
        int pos = 0;
        char carry = '0';
        //first add two arrays bit by bit
        while (pos < Math.min(la,lb)){
            if (ac[la-pos-1] == '1' && bc[lb-pos-1] == '1'){
                res.insert(0, carry);
                carry = '1';
            }
            else if(ac[la-pos-1] == '0' && bc[lb-pos-1] == '0'){
                res.insert(0, carry);
                carry = '0';
            }
            else{
                if (carry == '0') res.insert(0, '1');
                else {
                    res.insert(0, '0');
                    carry = '1';
                }
            }
            pos++;
        }
        //then add carry to the rest of the longer string
        while (pos < largerLength && carry=='1'){
            if (largerArray[largerLength-pos-1] == '1'){
                res.insert(0, '0');
                pos++;
            }
            else{
                res.insert(0, '1');
                pos++;
                break;
            }
        }
        //then copy the rest of longer string to the result
        //System.out.println(res);
        //System.out.println(pos);
        if (pos < largerLength) {
            res.insert(0, largerArray, 0, largerLength-pos);
        }
        else if (carry=='1') res.insert(0, '1');
        return res.toString();
    }

    public static void main(String[] args){
        System.out.print(addBinary("11","1"));
    }
}
