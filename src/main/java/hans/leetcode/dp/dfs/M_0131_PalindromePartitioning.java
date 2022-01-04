package hans.leetcode.dp.dfs;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M_0131_PalindromePartitioning {
    @Test
    public void test() {
        List<List<String>> num = partition("a");
        Logger.log(num);
    }


    /**
     * 			Runtime:15 ms, faster than 8.97% of Java online submissions.
     * 			Memory Usage:61.6 MB, less than 4.99% of Java online submissions.
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if (s==null||s.length()==0) {
            return list;
        }
        dfs(s, new LinkedList<>());
        return list;
    }
    List<List<String>> list = new LinkedList<>();
    public void dfs(String s, List<String> flist) {
        // 子串长度唯一，不必再递归
        if (s.length()==1) {
            flist.add(s);
            list.add(flist);
            return;
        }
        // 子串本身就是回文数，直接添加到结果里，并继续拆解子串
        if (isPalindrome(s)) {
            List<String> clist = new LinkedList<>();
            clist.addAll(flist);
            clist.add(s);
            list.add(clist);
        }

        for (int i=1; i<s.length(); i++) {
            String sub = s.substring(0, i);
            List<String> clist = new LinkedList<>();
            clist.addAll(flist);
            clist.add(sub);
            if (isPalindrome(sub)) {
                dfs(s.substring(i), clist);
            }
        }
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
