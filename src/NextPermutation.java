/**
 * Created by tianlan on 8/31/14.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num==null || num.length==0)
            return;
        int i = num.length-2;
        while(i>=0 && num[i]>=num[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            int j=i+1;
            while(j<num.length && num[j]>num[i])
            {
                j++;
            }
            j--;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        reverse(num, i+1);
    }
    private void reverse(int[] num, int index)
    {
        int l = index;
        int r = num.length-1;
        while(l<r)
        {
            int temp = num[l];
            num[l] = num[r];
            num[r] = temp;
            l++;
            r--;
        }
    }
}
