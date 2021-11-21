package hans.leetcode.tree;


import hans.common.utils.Logger;
import org.junit.Test;

/**
 Runtime:1 ms, faster than 83.25% of Java online submissions.
 Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class Medium0331_VerifyPreorderSerializationOfaBinaryTree {

    @Test
    public void test() {
        // 9,3,4,#,#,1,#,#,2,#,6,#,#  true
        // 9,#,#,1 false
        String preorder = "9,#,#,1";
        Logger.log(isValidSerialization(preorder));

    }

    /**
     * TODO 思路清奇
     * 			执行耗时:3 ms,击败了79.22% 的Java用户
     * 			内存消耗:38.5 MB,击败了33.30% 的Java用户
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder==null||preorder.length()==0) {
            return true;
        }

        String[] splits = preorder.split(",");
        int stack = 1;
        for (int i=0; i<splits.length; i++) {
            if (splits[i].equals("#")) {
                if (stack==0) {
                    return false;
                }
                stack--;
            } else {
                if (stack==0) {
                    return false;
                }
                stack++;
            }

        }
        return stack==0;
    }

}
