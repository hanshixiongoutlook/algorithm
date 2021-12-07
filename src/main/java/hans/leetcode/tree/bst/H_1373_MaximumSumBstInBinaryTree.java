package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class H_1373_MaximumSumBstInBinaryTree {

    @Test
    public void test() {
//        1,null,10,-5,20
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, null, 10, -5, 20});
        treeNode.prettyPrint();
        int i = new Mysolution().maxSumBST(treeNode);
        Logger.log(i);
    }

    class Mysolution {
        int max = 0;
        int sum = 0;

        public int maxSumBST(TreeNode root) {
            dfs(root);
            return max;
        }

        Map<TreeNode, Boolean> bstMap = new HashMap<>();
        Map<TreeNode, Integer> maxMap = new HashMap<>();
        Map<TreeNode, Integer> minMap = new HashMap<>();
        Map<TreeNode, Integer> sumMap = new HashMap<>();

        /**
         * Runtime:94 ms, faster than 5.31% of Java online submissions.
         * Memory Usage:131.2 MB, less than 5.10% of Java online submissions.
         *
         * @param root
         */
        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            boolean validBST = isValidBST(root, null, null);
            bstMap.put(root, validBST);
            sumMap.put(root, sum);
            maxMap.put(root, maxNode);
            minMap.put(root, minNode);
            if (validBST) {
                max = Math.max(sum, max);
            }
            maxNode = Integer.MIN_VALUE;
            minNode = Integer.MAX_VALUE;
            sum = 0;
        }

        int maxNode = Integer.MIN_VALUE;
        int minNode = Integer.MAX_VALUE;

        public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            }
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            sum += root.val;
            maxNode = Math.max(root.val, maxNode);
            minNode = Math.min(root.val, minNode);
            boolean left;
            if (bstMap.containsKey(root.left)) {
                minNode = Math.min(Math.min(root.val, maxNode), maxMap.getOrDefault(root.left, Integer.MIN_VALUE));
                sum += sumMap.getOrDefault(root.left, 0);
                left = bstMap.get(root.left) && (root.left == null || root.val > maxMap.getOrDefault(root.left, Integer.MIN_VALUE));
            } else {
                left = isValidBST(root.left, min, root);
            }
            boolean right;
            if (bstMap.containsKey(root.right)) {
                maxNode = Math.max(Math.max(root.val, maxNode), maxMap.getOrDefault(root.right, Integer.MIN_VALUE));
                sum += sumMap.getOrDefault(root.right, 0);
                right = bstMap.get(root.right) && (root.right == null || root.val < minMap.getOrDefault(root.right, Integer.MAX_VALUE));
            } else {
                right = isValidBST(root.right, min, root);
            }
            return right && left;
        }
    }

}
