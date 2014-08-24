/**
 * Created by tianlan on 8/23/14.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)
            return word2.length();
        if(word2.length()==0)
            return word1.length();
        String minWord = word1.length()>word2.length()?word2:word1;
        String maxWord = word1.length()>word2.length()?word1:word2;
        int[] res = new int[minWord.length()+1]; //index from 0 to n+1/m+1
        //first row initialize
        for(int i=0;i<=minWord.length();i++)
        {
            res[i] = i;
        }
        //second to last row
        for(int i=0;i<maxWord.length();i++)
        {
            int[] newRes = new int[minWord.length()+1];
            //init first element in this row
            newRes[0] = i+1;
            //fill in 2 to last element for this row
            for(int j=0;j<minWord.length();j++)
            {
                if(minWord.charAt(j)==maxWord.charAt(i))
                {
                    newRes[j+1]=res[j];
                }
                else
                {
                    //need to understand this
                    newRes[j+1] = Math.min(res[j],Math.min(res[j+1],newRes[j]))+1;
                }
            }
            res = newRes;
        }
        //return res[m][n]
        return res[minWord.length()];
    }
}
