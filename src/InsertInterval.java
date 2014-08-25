import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 8/24/14.
 */

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals==null) return null;
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size()==0) {
            res.add(newInterval);
            return res;
        }
        int i = 0;
        //for interval before
        while(i<intervals.size() && intervals.get(i).end<newInterval.start)
        {
            res.add(intervals.get(i));
            i++;
        }
        if(i<intervals.size()){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        res.add(newInterval);
        //update end
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end)
        {
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        //add interval after
        while(i<intervals.size())
        {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }

}
