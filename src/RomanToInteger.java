/**
 * Created by tianlan on 7/10/14.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        int res = 0;
        for(int i=0;i<s.length();i++)
        {
            switch(s.charAt(i))
            {
                case 'I':
                    if(i<s.length()-1 && (s.charAt(i+1)=='V'||s.charAt(i+1)=='X'))
                    {
                        res -= 1;
                    }
                    else
                    {
                        res += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if(i<s.length()-1 && (s.charAt(i+1)=='L'||s.charAt(i+1)=='C'))
                    {
                        res -= 10;
                    }
                    else
                    {
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if(i<s.length()-1 && (s.charAt(i+1)=='D'||s.charAt(i+1)=='M'))
                    {
                        res -= 100;
                    }
                    else
                    {
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
                default:
                    return 0;
            }
        }
        return res;
    }
}
