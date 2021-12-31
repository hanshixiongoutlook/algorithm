package hans.leetcode.dp.string;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class M_0091_DecodeWays {

    @Test
    public void test() {
        int result = numDecodings("123123");
        /*
        1 2 3 1 2 3
        1 2 3 1 23
        1 2 3 12 3
        1 23 1 2 3
        1 23 1 23
        1 23 12 3
        12 3 1 2 3
        12 3 1 23
        12 3 12 3
         */
        Logger.log(result);
    }

    /**
     * 			Runtime:8 ms, faster than 8.87% of Java online submissions.
     * 			Memory Usage:38.9 MB, less than 5.02% of Java online submissions.
     * 0  开头，无解
     * 00 结尾，无解
     * 0结尾，前一位>2，无解
     *
     * f(s) = f(s[i+1,n])+f(s[i+2,n])(s[i,i+2]<=26)
     * f(s1) = 1
     * f(s2) = 1 s2=10;s2=20;s2>26
     * f(s2) = 2
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s==null||s.startsWith("0")||s.length()==0||s.endsWith("00")) {
            return 0;
        }
        if (s.length()==1) {
            return 1;
        }
        if (s.charAt(s.length()-1)=='0'&&Integer.valueOf(s.substring(s.length()-2))>20) {
            return 0;
        }
        String[] chars = s.split("");
        int n0 = s.endsWith("0")?0:1;
        int n1;
        int iv = Integer.valueOf(chars[s.length()-2]+chars[s.length()-1]);
        if (iv<10) {
            n1 = 0;
        } else if (iv>26||iv==20||iv==10) {
            n1 = 1;
        } else {
            n1 = 2;
        }
        int cur = n1;
        for (int i=2; i<s.length(); i++) {
            if (chars[s.length()-i-1].equals("0")) {
                cur=0;
            } else {
                cur = n1;
                String sub = chars[s.length()-1-i]+chars[s.length()-i];
                if (Integer.valueOf(sub)<=26) {
                    cur = n1+n0;
                }
            }
            n0 = n1;
            n1 = cur;
        }
        return cur;
    }

    /**
     * 0  开头，无解
     * 00 结尾，无解
     * 0结尾，前一位>2，无解
     * f(s) = f(s[i+1,n])+f(s[i+2,n])
     *
     * @param s
     * @return
     */
    public int dfs(String s) {
        if (s.length()==1) {
            if (Integer.valueOf(s)>0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (s.startsWith("0")) {
            return 0;
        }
        if (s.endsWith("00")) {
            return 0;
        }
        if (s.charAt(s.length()-1)=='0'&&Integer.valueOf(s.substring(s.length()-2))>20) {
            return 0;
        }
        if (s.length()==2) {
            int iv = Integer.valueOf(s);
            if (iv<10) {
                return 0;
            }
            if (iv>26||iv==20||iv==10) {
                return 1;
            }
            return 2;
        }
        int n1 = dfs(s.substring(1));
        int n2 = 0;
        if (Integer.valueOf(s.substring(0,2))<=26) {
            n2 = dfs(s.substring(2));
        }
        return n1+n2;
    }
}
