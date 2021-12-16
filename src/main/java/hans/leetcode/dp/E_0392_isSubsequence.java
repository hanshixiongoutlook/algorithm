package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_0392_isSubsequence {
    @Test
    public void test() {
        boolean num = isSubsequence("", "bacd");
        Logger.log(num);
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:36.5 MB, less than 31.35% of Java online submissions.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length()>t.length()) {
            return false;
        }
        char[] ts = t.toCharArray();
        char[] ss = s.toCharArray();
        int i=0;
        for (int j=0;j<ts.length; j++) {
            if (i==ss.length) {
                break;
            }
            if (ss[i]==ts[j]) {
                i++;
            }
        }
        return i==ss.length;
    }

}
