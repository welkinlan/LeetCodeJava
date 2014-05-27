import java.util.*;

/**
 * Created by tianlan on 5/13/2014.
 */

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();

        dict.add(start);
        dict.add(end);

        // init adjacent graph
        for(String str : dict){
            calcNeighbours(neighbours, str, dict);
        }

        List<List<String>> result = new ArrayList<List<String>>();

        // BFS search queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(null, start, 1));

        // BFS level
        int previousLevel = 0;

        // mark which nodes have been visited, to break infinite loop
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();
            if(end.equals(n.str)){
                // find one path, check its length, if longer than previous path it's valid
                // otherwise all possible short path have been found, should stop
                if(previousLevel == 0 || n.level == previousLevel){
                    previousLevel = n.level;
                    findPath(n, result);
                }else {
                    // all path with length *previousLevel* have been found
                    break;
                }
            }else {
                HashSet<String> set = neighbours.get(n.str);

                if(set == null || set.isEmpty()) continue;
                // note: I'm not using simple for(String s: set) here. This is to avoid hashset's
                // current modification exception.
                ArrayList<String> toRemove = new ArrayList<String>();
                for (String s : set) {

                    // if s has been visited before at a smaller level, there is already a shorter
                    // path from start to s thus we should ignore s so as to break infinite loop; if
                    // on the same level, we still need to put it into queue.
                    if(visited.containsKey(s)){
                        Integer occurLevel = visited.get(s);
                        if(n.level+1 > occurLevel){
                            neighbours.get(s).remove(n.str);
                            toRemove.add(s);
                            continue;
                        }
                    }
                    visited.put(s,  n.level+1);
                    queue.add(new Node(n, s, n.level + 1));
                    if(neighbours.containsKey(s))
                        neighbours.get(s).remove(n.str);
                }
                for(String s: toRemove){
                    set.remove(s);
                }
            }
        }

        return result;
    }

    public void findPath(Node n, List<List<String>> result){
        ArrayList<String> path = new ArrayList<String>();
        Node p = n;
        while(p != null){
            path.add(0, p.str);
            p = p.parent;
        }
        result.add(path);
    }

    /*
     * complexity: O(26*str.length*dict.size)=O(L*N)
     */
    void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, Set<String> dict) {
        int length = str.length();
        char [] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {

            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {

                if (c == old)  continue;
                chars[i] = c;
                String newStr = new String(chars);

                if (dict.contains(newStr)) {
                    HashSet<String> set = neighbours.get(str);
                    if (set != null) {
                        set.add(newStr);
                    } else {
                        HashSet<String> newSet = new HashSet<String>();
                        newSet.add(newStr);
                        neighbours.put(str, newSet);
                    }
                }
            }
            chars[i] = old;
        }
    }

    private class Node {
        public Node parent;
        public String str;
        public int level;
        public Node(Node p, String s, int l){
            parent = p;
            str = s;
            level = l;
        }
    }
}
/*
//my method : TLE
public class WordLadderII {
    static String END;
    static int MIN_LEN;
    static List<List<String>> result;

    public static List<List<String>> ladderLength(String start, String end, Set<String> dict) {
        END = end;
        MIN_LEN = 2 + dict.size();
        if (dict.size() == 0)
            return null;

        result = new ArrayList<List<String>>();

        ArrayList<String> myList = new ArrayList<String>();
        myList.add(start);
        dict.add(end);
        recursiveSearch(start, 1, myList, dict);
        return result;
    }

    public static void recursiveSearch(String currWord, int length, ArrayList<String> myList, Set<String> myDict) {
        System.out.println(currWord + "," + myList + "," + length);
        if(currWord.equals(END)){
            //check if is the min length or not
            if (length < MIN_LEN) {
                MIN_LEN = length;
                result = new ArrayList<List<String>>();
                result.add(myList);
            }
            else if (length == MIN_LEN)
                result.add((myList));
            return;
        }
        if(length >= MIN_LEN){
            return;
        }
        for(int i=0; i<currWord.length(); i++){
            char[] currCharArr = currWord.toCharArray();
            for(char c='a'; c<='z'; c++){
                currCharArr[i] = c;
                String newWord = new String(currCharArr);
                if(myDict.contains(newWord) && !myList.contains(newWord)){
                    //initialize a new list and dict for each heap
                    ArrayList<String> newList = new ArrayList<String>(myList);
                    HashSet<String> newDict = new HashSet<String>(myDict);
                    newList.add(newWord);
                    newDict.remove(newWord);
                    recursiveSearch(newWord, length+1, newList, newDict);
                }
            }
        }
    }

    public static void main(String[] args){
        HashSet<String> dict = new HashSet<String>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        System.out.print(ladderLength("cet","ism",dict));
    }

}
*/
