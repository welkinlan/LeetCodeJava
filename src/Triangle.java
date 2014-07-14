import java.util.List;

/**
 * Created by tianlan on 7/13/14.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        int[] sums = new int[triangle.size()];
        sums[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++)
        {
            sums[i] = sums[i-1]+triangle.get(i).get(i);
            for(int j=i-1;j>=1;j--)
            {
                sums[j] = (sums[j]<sums[j-1]?sums[j]:sums[j-1]) + triangle.get(i).get(j);
            }
            sums[0] = sums[0]+triangle.get(i).get(0);

        }
        int minimum = sums[0];
        for(int i=1;i<sums.length;i++)
        {
            if(sums[i]<minimum)
            {
                minimum = sums[i];
            }
        }
        return minimum;

    }
}
