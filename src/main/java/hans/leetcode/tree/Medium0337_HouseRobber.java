package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime:1 ms, faster than 83.25% of Java online submissions.
 * Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class Medium0337_HouseRobber {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,1,3,null,4});
        treeNode.prettyPrint();
        Logger.log("answer={}", rob(treeNode));

        Logger.log("My solution={}", new Solution1().rob(treeNode));
        Logger.log("solution2={}", new Solution2().rob(treeNode));

    }

    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

    /**
     * 			执行耗时:3 ms,击败了23.77% 的Java用户
     * 			内存消耗:38.2 MB,击败了5.11% 的Java用户
     */
    class Solution2{
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);

            return Math.max(selected.getOrDefault(root,0), unselected.getOrDefault(root,0));
        }

        Map<TreeNode, Integer> selected = new HashMap<>();
        Map<TreeNode, Integer> unselected = new HashMap<>();
        public void dfs(TreeNode root) {
            if (root == null) {
                return ;
            }
            dfs(root.left);
            dfs(root.right);
            selected.put(root, unselected.getOrDefault(root.left, 0)+unselected.getOrDefault(root.right,0)+root.val);
            unselected.put(root, Math.max(selected.getOrDefault(root.left,0),unselected.getOrDefault(root.left,0))+
                    Math.max(selected.getOrDefault(root.right,0),unselected.getOrDefault(root.right,0)));
        }
    }

    /**
     * 			执行耗时:2 ms,击败了45.08% 的Java用户
     * 			内存消耗:37.9 MB,击败了76.46% 的Java用户
     */
    class Solution1 {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return rob(root, false);
        }

        Map<TreeNode, Integer[]> map = new HashMap<>();

        public int rob(TreeNode root, boolean isParentStolened) {
            if (root == null) {
                return 0;
            }
            Integer[] status = map.get(root);
            if (status == null) {
                status = new Integer[2];
                map.put(root, status);
            } else {
                if (isParentStolened && status[0] != null) {
                    return status[0];
                }
                if (!isParentStolened && status[1] != null) {
                    return status[1];
                }
            }
            int left, right;
            if (isParentStolened) {
                left = rob(root.left, false);
                right = rob(root.right, false);
                status[0] = left + right;
                return left + right;
            } else {
                left = rob(root.left, true);
                right = rob(root.right, true);

                int leftN = rob(root.left, false);
                int rightN = rob(root.right, false);
                int max = Math.max(root.val + left + right, leftN + rightN);
                status[1] = max;
                return max;
            }
        }
    }


}
