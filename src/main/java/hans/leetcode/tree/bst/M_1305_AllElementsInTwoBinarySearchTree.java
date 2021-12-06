package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 同783
 */
public class M_1305_AllElementsInTwoBinarySearchTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,1,7,0,2});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, null});

        treeNode.prettyPrint();
        List<Integer> allElements = getAllElements(treeNode, null);
        Logger.log(allElements);
    }

    List<Integer> list = new LinkedList<>();

    /**
     * 			Runtime:25 ms, faster than 20.06% of Java online submissions.
     * 			Memory Usage:41.9 MB, less than 14.62% of Java online submissions.
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        return list.stream().sorted().collect(Collectors.toList());
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


}
