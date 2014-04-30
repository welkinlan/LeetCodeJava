import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by tianlan on 4/29/14.
 */
public class PlusOne {
    static int[] plusOne(int[] digits) {
        int i=digits.length;
        for (i=digits.length-1; i>-1; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            }
            else{
                digits[i] += 1;
                return digits;
            }
        }
        if (i==-1){
            int[] array = new int[digits.length+1];
            System.arraycopy(digits,0, array, 1, digits.length);
            array[0] = 1;
            return array;
        }
        else {
            return digits;
        }


    }

    public static void main(String[] args) {
        int digits[] = {9, 6, 9, 9, 9};

        int result[] = plusOne(digits);
        for (int i : result){
            System.out.println(i);

        }

    }
}
