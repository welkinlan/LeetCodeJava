import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Interval {
 int start;
 int end;
 Interval() { start = 0; end = 0; }
 Interval(int s, int e) { start = s; end = e; }
 @Override
 public String toString() {
     return String.format("["+start + "," + end+"]");
 }
}

class StartComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval i1, Interval i2){
        int s1 = i1.start;
        int s2 = i2.start;

        if(s1>s2){
            return 1;
        }
        else if (s1<s2){
            return -1;
        }
        else{
            return 0;
        }
    }
}

public class MergeIntervals {
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> resultArray = new ArrayList<Interval>();
        int size = intervals.size();
        Collections.sort(intervals, new StartComparator());

        int now = 0;
        while (now < (intervals.size()-1)) {
            //System.out.println(now+":"+intervals.size());
            if (intervals.get(now).end >= intervals.get(now+1).start) {
                int end = Math.max(intervals.get(now).end,intervals.get(now+1).end);
                Interval add = new Interval(intervals.get(now).start, end);
                //System.out.println(add);
                intervals.remove(now);
                //System.out.println(intervals);
                intervals.remove(now);
                //System.out.println(intervals);
                intervals.add(now,add);
                //System.out.println(intervals);
            }
            else{
                now += 1;
            }
        }

        return intervals;
    }
	
	public static void main(String[] args) {
		ArrayList<Interval> al = new ArrayList<Interval>();
		al.add(new Interval(1,3));
        al.add(new Interval(15,18));
		al.add(new Interval(8,10));
        al.add(new Interval(2,6));
        al.add(new Interval(5,8));

		merge(al);
        System.out.println(al);

    }

}
