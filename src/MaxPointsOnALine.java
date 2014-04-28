import java.util.ArrayList;
import java.util.Collections;

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
}

public class MaxPointsOnALine {
    static int mp = 0;
    static Point[] pts;
    static int size = 0;
    static int visited[][] = new int[0][0];


    public static int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        pts = points;
        size = points.length;
        visited = new int[size][size];
        for (int cur=0; cur<points.length; cur++){
            System.out.println("base---"+"["+pts[cur].x+","+pts[cur].y+"]");
            for (int nex=cur+1; nex<points.length; nex++){
                if (visited[cur][nex] == 1){ //already visited
                    continue;
                }
                else{
                    //System.out.println(cur);
                    visited[cur][nex] = 1;
                    visited[nex][cur] = 1;
                    float k = getK(pts[cur],pts[nex]);
                    System.out.println("out---"+"["+pts[nex].x+","+pts[nex].y+"]"+":"+k+":"+mp);
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
                findMates(cur, k, mp++);
            }
            else if (getK(pts[cur],pts[nex])==k){
                System.out.println("in---"+"["+pts[nex].x+","+pts[nex].y+"]"+":"+k+":"+mp);
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
