package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 The thief has found himself a new place for his thievery again. There is only
 one entrance to this area, called root.

 Besides the root, each house has one and only one parent house. After a tour,
 the smart thief realized that all houses in this place form a binary tree. It
 will automatically contact the police if two directly-linked houses were broken
 into on the same night.

 Given the root of the binary tree, return the maximum amount of money the
 thief can rob without alerting the police.


 Example 1:


 Input: root = [3,2,3,null,3,null,1]
 Output: 7
 Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.


 Example 2:


 Input: root = [3,4,5,1,3,null,1]
 Output: 9
 Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 0 <= Node.val <= 10⁴

 Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1228 👎 0

 */
public class M_0337_HouseRobber {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,1,3,null,4});
        treeNode.prettyPrint();
        Logger.log("answer={}", rob(treeNode));

        Logger.log("My solution={}", new Solution1().rob(treeNode));
        Logger.log("solution2={}", new Solution2().rob(treeNode));

    }

    // 使用当前节点
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    // 不使用当前节点
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    /**
     * Runtime:1 ms, faster than 83.25% of Java online submissions.
     * Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
     */
    public int rob(TreeNode root) {
        /*
        动态规划求最值

        每一个节点都有两种状态即，使用和不使用，用0表示不使用，1表示使用
        使用时（左右子树都不能计算）
            最值=当前值+左子树最值[0]+右子树最值[1]
        不使用时（左右子树既可以用又可以不用）
            最值=max(左子树最值[0],左子树最值[1]) + max(右子树最值[0],右子树最值[1])

         f(root)[0] = max(f(left)[0],f(left)[1]) + max(f(right)[0],f(right)[1])
         f(root)[1] = f(left)[0]+f(right)[0]

         最终结果 = max(f(root)[0],f(root)[1])

         */
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        // 使用当前节点
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        // 不使用当前节点
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
