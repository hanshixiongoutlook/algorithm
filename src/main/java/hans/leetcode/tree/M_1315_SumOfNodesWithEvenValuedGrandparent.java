package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 */
public class M_1315_SumOfNodesWithEvenValuedGrandparent {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5});
        treeNode.prettyPrint();
        Logger.log(sumEvenGrandparent(treeNode));

    }

    int sum = 0;

    /**
     * 			Runtime:1 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:40.4 MB, less than 33.46% of Java online submissions.
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root==null) {
            return sum;
        }
        dfs(root, null, null);
        return sum;
    }

    public void dfs(TreeNode root, TreeNode parent, TreeNode grand) {
        if (root==null) {
            return;
        }
        if (grand!=null&&grand.val%2==0) {
            sum = sum + root.val;
        }
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }


}
