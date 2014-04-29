import java.util.*;

/**
 * Created by tianlan on 4/27/14.
 */
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return String.format("[" + x + "," + y + "]");
    }
}

public class MaxPointsOnALine {
    static int mp = 0;
    static Point[] pts;
    static int size = 0;
    static int visited[][] = new int[0][0];

    /*
    // recursive not successful

    public static int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        pts = points;
        size = points.length;
        visited = new int[size][size];
        for (int cur=0; cur<points.length; cur++){
            System.out.println("base---"+points[cur]);
            for (int nex=cur+1; nex<points.length; nex++){
                if (visited[cur][nex] == 1 || visited[nex][cur] == 1 ){ //already visited
                    continue;
                }

                else{
                    //System.out.println(cur);
                    visited[cur][nex] = 1;
                    visited[nex][cur] = 1;
                    float k = getK(pts[cur],pts[nex]);
                    System.out.println("out---"+points[nex]+":"+k+":"+1);
                    int tmp = findMates(nex, k, 1);
                    if (tmp>mp) {
                        mp = tmp;
                    }
                }
            }

        }

        return mp+1;
    }

    public static float getK(Point x, Point y){
        if (x.x == y.x) return Float.POSITIVE_INFINITY;
        else return (y.y-x.y)/(y.x-x.x);
    }

    public static int findMates(int cur, float k, int mp) {
        for (int nex=cur+1; nex<pts.length; nex++){
            //System.out.println(cur+","+nex);
            if (visited[cur][nex] == 1){ //already visited
                continue;
            }
            else if ((pts[cur].x == pts[nex].x) && (pts[cur].y == pts[nex].y)){
                visited[cur][nex] = 1;
                visited[nex][cur] = 1;
                findMates(nex, k, mp++);
            }
            else if (getK(pts[cur],pts[nex])==k){
                System.out.println("in---"+pts[nex]+":"+k+":"+(mp+1));
                visited[cur][nex] = 1;
                visited[nex][cur] = 1;
                findMates(nex, k, mp++);
            }
            else{
                continue;
            }
        }
        return mp;
    }
    */

    //full traversal of all points
    public static int maxPoints(Point[] points){
        if(points.length == 0)
            return 0;
        int max = 1;
        for(int i = 0; i < points.length - 1; i++){
            Map<Double, Integer> slope = new HashMap<Double, Integer>();
            Point p1 = points[i];
            int maxWithI = 0;
            for(int j = i + 1; j < points.length; j++){
                Point p2 = points[j];
                double d = 0;
                if(p1.x != p2.x){
                    d = (double)(p2.y - p1.y)/(double)(p2.x - p1.x);
                    if(d == -0.0)
                        d = 0.0;
                    int count = slope.get(d) == null ? 0 : slope.get(d);
                    count++;
                    slope.put(d, count);
                }else if(p1.y == p2.y){
                    maxWithI++;
                }else{
                    d = Double.MAX_VALUE;
                    int count = slope.get(d) == null ? 0 : slope.get(d);
                    count++;
                    slope.put(d, count);
                }

            }
            int sameSlope;
            if(slope.size() == 0){
                sameSlope = 0;
            }else{
                int maxSame = 0;
                for(Map.Entry<Double, Integer> entry : slope.entrySet()){
                    if(entry.getValue() > maxSame){
                        maxSame = entry.getValue();
                    }
                }
                sameSlope = maxSame;
            }
            maxWithI += sameSlope + 1;
            if(maxWithI > max){
                max = maxWithI;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Point pts[] = new Point[6];
        pts[0] = new Point(1,1);
        pts[1] = new Point(2,1);
        pts[2] = new Point(2,2);
        pts[3] = new Point(2,3);
        pts[4] = new Point(3,3);
        pts[5] = new Point(1,1);


        int mp = maxPoints(pts);
        System.out.println(mp);

    }
}
