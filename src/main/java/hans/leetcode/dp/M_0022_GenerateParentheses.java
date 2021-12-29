package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

public class M_0022_GenerateParentheses {
    @Test
    public void test() {
        List<String> num = generateParenthesis(8);
        Logger.log(num);
    }

    List<String> res = new LinkedList<>();

    /**
     * TODO 深度优先遍历
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;

    }
    public void dfs(int left, int right, String s) {
        if (left==0) {
            for (int i=0; i<right; i++) {
                s+=")";
            }
            res.add(s);
            return;
        }
        if (left>0) {
            dfs(left-1, right, s+"(");
        }
        // 为了保证合法，左括号永远要比右括号先出现
        if (right>left) {
            dfs(left, right-1, s+")");
        }
    }

}
