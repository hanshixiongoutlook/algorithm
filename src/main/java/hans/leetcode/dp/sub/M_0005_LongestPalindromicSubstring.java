package hans.leetcode.dp.sub;

import hans.common.utils.Logger;
import org.junit.Test;

public class M_0005_LongestPalindromicSubstring {
    @Test
    public void test() {
        String num = longestPalindrome("abbv");
        Logger.log(num);
    }

    /**
     * f(i,i+1) =
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s==null||s.length()==0) {
            return s;
        }
        String res = s.substring(0,1);
        for (int i=0; i<s.length()-1; i++) {
            if (res.length()>(s.length()-i)*2) {
                break;
            }
            int radius = Math.min(i, s.length()-i-1);
            for (int j=1; j<=radius; j++) {
                String sub = s.substring(i-j,i+j+1);
                if (isPalindrome(sub)) {
                    if (res.length()<sub.length()) {
                        res = sub;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i=0; i<s.length()-1; i++) {
            if (res.length()>(s.length()-i)*2) {
                break;
            }
            // abcdef
            if (s.charAt(i)!=s.charAt(i+1)) {
                continue;
            }
            if (res.length()<2) {
                res = s.substring(i, i+2);
            }
            int radius = Math.min(i, s.length()-i-2);
            for (int j=1; j<=radius; j++) {
                String sub = s.substring(i-j,i+j+2);
                if (isPalindrome(sub)) {
                    if (res.length()<sub.length()) {
                        res = sub;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length/2; i++) {
            if (chars[i]!=chars[chars.length-i-1]) {
                return false;
            }
        }
        return true;
    }


}
