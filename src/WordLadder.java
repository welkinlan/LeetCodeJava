import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by tianlan on 5/13/2014.
 */

public class WordLadder {
    static HashMap <String, HashSet<String>> stringCandidates = new HashMap <String, HashSet<String>>();
    //static HashMap <String, String> stringDad = new HashMap <String, String>();
    static HashMap <String, Integer> stringVisited = new HashMap <String, Integer>();
    static int best = 0;

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0)
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);

        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

            if(currWord.equals(end)){
                return currDistance;
            }

            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    //TLE
    public static int myladderLength(String start, String end, HashSet<String> dict) {
        //add start and end string to dict
        dict.add(start);
        dict.add(end);
        //get candidates for each string
        for (String s : dict){ stringCandidates.put(s, new HashSet<String>());}
        for (String s : dict){
            for (String ss: dict){
                int count = 0;
                //count identical
                for (int i=0; i<s.length(); i++){
                    if (s.charAt(i) == ss.charAt(i)){
                        count ++;
                    }
                }
                if (count == 2){
                    stringCandidates.get(s).add(ss);
                }
            }
        }
        //DFS
        for (String s : dict) {stringVisited.put(s,0);}
        stringVisited.put(start,1);
        //for (String s : dict) {stringDad.put(s,"");}
        best = dict.size();
        for (String s : stringCandidates.get(start)) {
            dfsCount(s, end, stringVisited, 2);
        }
        System.out.print(stringCandidates);
        return best;
    }

    //DFS
    public static void dfsCount(String now, String end, HashMap <String, Integer> stringVisited, int count){
        stringVisited.put(now,1);
        if (now.equals(end)){
            best = Math.min(count,best);
        }
        else{
            for (String s : stringCandidates.get(now)){
                if (stringVisited.get(s) != 1){
                    dfsCount(s, end, stringVisited, count + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        HashSet<String> dict = new HashSet<String>(Arrays.asList("rat","pen","pan","pet","pan","pat","ran"));
        System.out.print(ladderLength("rat","pat",dict));
    }



}
