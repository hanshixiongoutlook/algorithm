package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_1261_FindElementsInaContaminatedBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5});
        treeNode.prettyPrint();

    }

    /**
     * 			Runtime:1275 ms, faster than 5.29% of Java online submissions.
     * 			Memory Usage:42.8 MB, less than 73.58% of Java online submissions.
     */
    class FindElements {
        Map<TreeNode, Integer> map;
        public FindElements(TreeNode root) {
           map = new HashMap<>();
            dfs(root);
        }
        public void dfs(TreeNode root) {
            if (root==null) {
                return;
            }
            if (map.isEmpty()) {
                map.put(root, 0);
            }
            if (root.left!=null) {
                map.put(root.left, map.get(root)*2+1);
                dfs(root.left);
            }
            if (root.right!=null) {
                map.put(root.right, map.get(root)*2+2);
                dfs(root.right);
            }
        }

        public boolean find(int target) {
            return map.containsValue(target);
        }
    }

}
